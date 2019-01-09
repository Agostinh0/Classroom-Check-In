package com.example.agostinhocarrara.classroomcheck_in.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.agostinhocarrara.classroomcheck_in.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login_screen.*

class LoginScreenActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    var mAuthListener: FirebaseAuth.AuthStateListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        mAuth = FirebaseAuth.getInstance()
        mAuthListener = FirebaseAuth.AuthStateListener{}

    }

        fun login(view: View){

            if(swTeacher.isChecked == true && swRecep.isChecked == false) {
                mAuth!!.signInWithEmailAndPassword(tfLogin.text.toString(), tfPassword.text.toString())
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(applicationContext, MainActivity::class.java)
                            startActivity(intent)
                        }
                    }
                    .addOnFailureListener { exception ->
                        Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG).show()
                    }

            }else if(swTeacher.isChecked == false && swRecep.isChecked == true){
                mAuth!!.signInWithEmailAndPassword(tfLogin.text.toString(), tfPassword.text.toString())
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(applicationContext, Main2Activity::class.java)
                            startActivity(intent)
                        }
                    }
                    .addOnFailureListener { exception ->
                        Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG).show()
                    }
            }else {
                Toast.makeText(this@LoginScreenActivity, R.string.warning, Toast.LENGTH_SHORT).show()
            }

        }

        fun signUp(view: View){

            if(swTeacher.isChecked == true && swRecep.isChecked == false){
                mAuth!!.createUserWithEmailAndPassword(tfLogin.text.toString(),tfPassword.text.toString())
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(applicationContext,"User Created", Toast.LENGTH_LONG).show()
                            val intent = Intent(applicationContext,MainActivity::class.java)
                            startActivity(intent)
                        }
                    }

                    .addOnFailureListener { exception ->
                        if (exception != null) {
                            Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG).show()
                        }
                    }
            }else if(swTeacher.isChecked == false && swRecep.isChecked == true){
                mAuth!!.createUserWithEmailAndPassword(tfLogin.text.toString(),tfPassword.text.toString())
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(applicationContext,"User Created", Toast.LENGTH_LONG).show()
                            val intent = Intent(applicationContext,Main2Activity::class.java)
                            startActivity(intent)
                        }
                    }

                    .addOnFailureListener { exception ->
                        if (exception != null) {
                            Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG).show()
                        }
                    }
            }else {
                Toast.makeText(this@LoginScreenActivity, R.string.warning, Toast.LENGTH_SHORT).show()
            }
        }
        override fun onStart() {
            super.onStart()

            val currentUser = mAuth?.currentUser
            Log.i( "FireBase", "Email:" + currentUser?.email)



    }
    }
