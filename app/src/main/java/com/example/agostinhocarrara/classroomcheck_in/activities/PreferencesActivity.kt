package com.example.agostinhocarrara.classroomcheck_in.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agostinhocarrara.classroomcheck_in.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.android.synthetic.main.activity_preferences.*

class PreferencesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)

        tvDisplayName.setText(FirebaseAuth.getInstance().currentUser!!.displayName)

        btnSavePref.setOnClickListener{
            val user = FirebaseAuth.getInstance().currentUser

            val profileUpdates = UserProfileChangeRequest.Builder()
                .setDisplayName(prefName.text.toString())
                .build()

            user?.updateProfile(profileUpdates)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
