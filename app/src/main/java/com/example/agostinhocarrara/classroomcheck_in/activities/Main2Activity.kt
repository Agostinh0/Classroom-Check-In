package com.example.agostinhocarrara.classroomcheck_in.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.agostinhocarrara.classroomcheck_in.R
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnHistory.setOnClickListener{
            val intent = Intent(this, ListViewActivity::class.java)
            startActivity(intent)
        }

        btnHistory2.setOnClickListener{
            val intent = Intent(this, ListView2Activity::class.java)
            startActivity(intent)
        }
    }
}
