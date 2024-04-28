package com.example.mygamelist.ui

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mygamelist.R
import android.content.Intent


class login_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Boton-Textview-si el usuario no tiene cuenta, lo lleva a la actividad de singup
        val signUpButton: TextView = findViewById(R.id.sign_up_txt)
        signUpButton.setOnClickListener{

            val intent: Intent = Intent(this,singup_Activity::class.java)
            startActivity(intent)
        }

    }
}