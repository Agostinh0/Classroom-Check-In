package com.example.agostinhocarrara.classroomcheck_in.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agostinhocarrara.classroomcheck_in.R
import kotlinx.android.synthetic.main.activity_login_screen.*

class LoginScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        btnLogin.setOnClickListener{
            if(tfLogin.text.toString().equals("prof") && tfPassword.text.toString().equals("prof")){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else if (tfLogin.text.toString().equals("recep") && tfPassword.text.toString().equals("recep")){
                val intent = Intent(this, Main2Activity::class.java)
                startActivity(intent)
            }else {
                Toast.makeText(applicationContext, R.string.error, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
