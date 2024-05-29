package com.example.mygamelist.ui.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mygamelist.GamesFirebase
import com.example.mygamelist.R
import com.example.mygamelist.adapter.PlayingAdapter
import com.example.mygamelist.databinding.FragmentMylistBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.toObject

class MyListFragment : Fragment() {

    private lateinit var recyclerView:RecyclerView
    private lateinit var gameArrayList:ArrayList<GamesFirebase>
    private lateinit var myAdapter:PlayingAdapter
    private lateinit var db: FirebaseFirestore

    private var _binding: FragmentMylistBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMylistBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recyclerPlaying.layoutManager = LinearLayoutManager(context)
        binding.recyclerPlaying.setHasFixedSize(true)

        gameArrayList = arrayListOf()

        myAdapter = PlayingAdapter(gameArrayList)
        binding.recyclerPlaying.adapter = myAdapter

        EventChangeListener()

        return root
    }

    private fun EventChangeListener()
    {
        db=FirebaseFirestore.getInstance()
        val userEmail = FirebaseAuth.getInstance().currentUser?.email ?: return
        db.collection("users").document(userEmail).collection("Playing")
            .addSnapshotListener(object :EventListener<QuerySnapshot>{
                override fun onEvent(
                    value: QuerySnapshot?,
                    error: FirebaseFirestoreException?
                ) {
                    if (error !=null){
                        Log.e("Firestore Error",error.message.toString())
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