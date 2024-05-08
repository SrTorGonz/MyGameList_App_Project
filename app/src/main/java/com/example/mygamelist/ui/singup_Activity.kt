package com.example.mygamelist.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mygamelist.R
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class singup_Activity : AppCompatActivity() {

    private val db= FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_singup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Boton-Textview-si el usuario ya tiene cuenta, lo lleva a la actividad de login
        val loginButtonTxt: TextView = findViewById(R.id.login_txt)
        loginButtonTxt.setOnClickListener{

            val intent: Intent = Intent(this,login_Activity::class.java)
            startActivity(intent)
        }

        //registro
        singup()
    }

    // funcion que registra el email y contrasena del usuario
    private fun singup() {

        val signupButton: Button = findViewById(R.id.signup_button)
        val email_input: EditText=findViewById(R.id.email_input)
        val password_input: EditText=findViewById(R.id.password_input)
        val nickname_input: EditText=findViewById(R.id.nickname_input)

        signupButton.setOnClickListener{
            if (email_input.text.isNotEmpty() && password_input.text.isNotEmpty() && nickname_input.text.isNotEmpty() ){

                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email_input.text.toString(),password_input.text.toString())

                    .addOnCompleteListener{
                        //si es correcto lleva a la actividad login
                        if(it.isSuccessful){
                            db.collection("users").document(email_input.text.toString()).set(
                                hashMapOf("nickname" to nickname_input.text.toString(),"profile_Pic" to "https://firebasestorage.googleapis.com/v0/b/mygamelist-28430.appspot.com/o/Default_Profile_Pic.png?alt=media&token=5b174c0c-1157-4dc1-a3aa-19272da13db6")
                            )
                            val intent: Intent = Intent(this,login_Activity::class.java)
                            startActivity(intent)
                        //de lo contrario mostrar una alerta
                        }else{
                            showAlert("Email is already in use, please login or enter a new one")
                        }
                    }

            }else{
                showAlert("Please complete all fields before continuing")
            }
        }
    }

    //funcion que muestra un error recibe el mensaje a mostrar
    private fun showAlert(msg: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage(msg)
        builder.setPositiveButton("Accept", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}