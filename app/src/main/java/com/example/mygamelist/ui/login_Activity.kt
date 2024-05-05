package com.example.mygamelist.ui

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mygamelist.R
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.mygamelist.MainActivity
import com.google.firebase.auth.FirebaseAuth


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

        //inicio de sesion
        login()
    }
    // funcion que registra el email y contrasena del usuario
    private fun login() {

        val loginButton: Button = findViewById(R.id.login_button)
        val email_input: EditText =findViewById(R.id.email_input)
        val password_input: EditText =findViewById(R.id.password_input)

        loginButton.setOnClickListener{
            if (email_input.text.isNotEmpty() && password_input.text.isNotEmpty()){

                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(email_input.text.toString(),password_input.text.toString())

                    .addOnCompleteListener{
                        //si es correcto lleva a la actividad Main
                        if(it.isSuccessful){
                            val intent: Intent = Intent(this,MainActivity::class.java)
                            startActivity(intent)
                            //de lo contrario mostrar una alerta
                        }else{
                            showAlert("INCORRECT user or password, please try again")
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