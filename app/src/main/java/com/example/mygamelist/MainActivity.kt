package com.example.mygamelist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.example.mygamelist.databinding.ActivityMainBinding
import com.example.mygamelist.ui.dashboard.SearchFragmentDirections
import com.example.mygamelist.ui.home.HomeFragment
import com.google.android.material.imageview.ShapeableImageView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding
    private val db = FirebaseFirestore.getInstance()
    private lateinit var navController: NavController
    private lateinit var sharedViewModel: SharedViewModel

    private var gameMutableList:MutableList<Videojuego> = GamesProvider.GameList.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //lista de juegos
        GamesProvider.GameList

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Guarda el email del usuario del login
        val bundle = intent.extras
        val email = bundle?.getString("email") ?: "default@example.com"
        //imageview del xml
        var imageUrl: String? = null


        //recuperar imagen de perfil del usuario
        db.collection("users").document(email).get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    imageUrl = document.getString("profile_Pic")
                    if (imageUrl != null) {
                        // Usar Glide para cargar la imagen
                        Glide.with(this)
                            .load(imageUrl)
                            .into(binding.roundedImageView)
                    } else {
                        println("Profile Pic URL not found")
                    }
                } else {
                    println("No such document")
                }
            }
            .addOnFailureListener { exception ->
                println("Error getting document: ${exception.message}")
            }

        //abrir fragment de perfil
        binding.roundedImageView.setOnClickListener {
            val currentDestination = navController.currentDestination?.id

            when (currentDestination) {
                R.id.navigation_home -> {
                    // Si estás en el fragmento de inicio, haz algo
                    navController.navigate(R.id.action_navigation_home_to_profileFragment)
                }

                R.id.navigation_search -> {
                    // Si estás en el fragmento de búsqueda, haz algo
                    navController.navigate(R.id.action_navigation_search_to_navigation_profile)
                }

                R.id.navigation_mylist -> {
                    // Si estás en el fragmento de mi lista, haz algo
                    navController.navigate(R.id.action_navigation_mylist_to_navigation_profile)
                }

                R.id.navigation_game -> {
                    // Si estas en el fragmento de game, haz algo
                    navController.navigate(R.id.action_navigation_game_to_navigation_profile)
                }
                R.id.navigation_completed -> {
                    // Si estas en el fragmento de completed, haz algo
                    navController.navigate(R.id.action_navigation_completed_to_navigation_profile)
                }
                R.id.navigation_dropped -> {
                    // Si estas en el fragmento de dropped, haz algo
                    navController.navigate(R.id.action_navigation_dropped_to_navigation_profile)
                }
                R.id.navigation_wishlist -> {
                    // Si estas en el fragmento de wishlist, haz algo
                    navController.navigate(R.id.action_navigation_wishlist_to_navigation_profile)
                }
            }

            sharedViewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

            sharedViewModel.profilePicUrl.observe(
                this,) { url ->
                Glide.with(this)
                    .load(url)
                    .into(binding.roundedImageView)
            }

        }

            /*
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_mylist
            )
        )
        //setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
*/
            val navHost =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
            navController = navHost.navController
            binding.navView.setupWithNavController(navController)


    }
}
