package com.example.agostinhocarrara.classroomcheck_in

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_class_room_request.*

class ClassRoomRequestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_room_request)

        val intent: Intent = getIntent()
        val laboratorio: String = intent.getStringExtra("lab")

        tvClassroom.setText(laboratorio)
    }
}
