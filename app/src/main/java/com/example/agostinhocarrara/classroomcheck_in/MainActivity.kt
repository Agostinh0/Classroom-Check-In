package com.example.agostinhocarrara.classroomcheck_in

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn35.setOnClickListener{
            val intent = Intent(this, ClassRoomRequestActivity::class.java)
            intent.putExtra("lab", "Lab. 35")
            startActivityForResult(intent, 1)
        }

        btn37.setOnClickListener{
            val intent = Intent(this, ClassRoomRequestActivity::class.java)
            intent.putExtra("lab", "Lab. 37")
            startActivityForResult(intent, 1)
        }

        btn39.setOnClickListener{
            val intent = Intent(this, ClassRoomRequestActivity::class.java)
            intent.putExtra("lab", "Lab. 39")
            startActivityForResult(intent, 1)
        }

        btn41.setOnClickListener{
            val intent = Intent(this, ClassRoomRequestActivity::class.java)
            intent.putExtra("lab", "Lab. 41")
            startActivityForResult(intent, 1)
        }

        btn43.setOnClickListener{
            val intent = Intent(this, ClassRoomRequestActivity::class.java)
            intent.putExtra("lab", "Lab. 43")
            startActivityForResult(intent, 1)
        }
    }
}
