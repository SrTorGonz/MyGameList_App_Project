package com.example.mygamelist.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mygamelist.GamesFirebase
import com.example.mygamelist.adapter.PlayingAdapter
import com.example.mygamelist.databinding.FragmentWishlistBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot

class WishlistFragment : Fragment() {

    private lateinit var gameArrayList:ArrayList<GamesFirebase>
    private lateinit var myAdapter: PlayingAdapter
    private lateinit var db: FirebaseFirestore

    private var _binding: FragmentWishlistBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWishlistBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.titlePlaying.setOnClickListener{
            val action = WishlistFragmentDirections.actionNavigationWishlistToNavigationMylist()
            findNavController().navigate(action)
        }

        binding.titleCompleted.setOnClickListener{
            val action = WishlistFragmentDirections.actionNavigationWishlistToNavigationCompleted()
            findNavController().navigate(action)
        }

        binding.titleDropped.setOnClickListener{
            val action = WishlistFragmentDirections.actionNavigationWishlistToNavigationDropped()
            findNavController().navigate(action)
        }


        binding.recyclerPlaying.layoutManager = LinearLayoutManager(context)
        binding.recyclerPlaying.setHasFixedSize(true)

        gameArrayList = arrayListOf()

        myAdapter = PlayingAdapter(gameArrayList)
        binding.recyclerPlaying.adapter = myAdapter

        eventChangeListener()

        return root
    }

    private fun eventChangeListener()
    {
        db=FirebaseFirestore.getInstance()
        val userEmail = FirebaseAuth.getInstance().currentUser?.email ?: return
        db.collection("users").document(userEmail).collection("WishList")
            .addSnapshotListener(object :EventListener<QuerySnapshot>{
                override fun onEvent(
                    value: QuerySnapshot?,
                    error: FirebaseFirestoreException?
                ) {
                    if (error !=null){
                        Toast.makeText(requireContext(), "Nothing to show", Toast.LENGTH_SHORT).show()
                        return
                    }

                    for(dc:DocumentChange in value?.documentChanges!!){

                        if (dc.type==DocumentChange.Type.ADDED){
                            gameArrayList.add(dc.document.toObject(GamesFirebase::class.java))
                        }
                    }

                    myAdapter.notifyDataSetChanged()
                }

            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}