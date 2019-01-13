package com.example.agostinhocarrara.classroomcheck_in.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.Toast
import com.example.agostinhocarrara.classroomcheck_in.R
import com.example.agostinhocarrara.classroomcheck_in.beans.Professor
import com.example.agostinhocarrara.classroomcheck_in.beans.RegistroAula
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_class_room_request.*
import java.lang.Exception
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class ClassRoomRequestActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    var dbRef: DatabaseReference? = database.getReference("messsage")

    private lateinit var locationManager: LocationManager
    private lateinit var locationListener: LocationListener

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_room_request)

        locationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationListener = object: LocationListener{
            override fun onLocationChanged(p0: Location?) {
                Toast.makeText(this@ClassRoomRequestActivity, p0.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onProviderEnabled(p0: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onProviderDisabled(p0: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }

        //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener)

        //Firebase
        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        dbRef = database!!.reference

        //Recuperando dados do intent
        val intent: Intent = getIntent()
        val laboratorio: String = intent.getStringExtra("lab")

        //definindo valores padrão
        textViewTeacher.setText(FirebaseAuth.getInstance().currentUser!!.displayName)
        tvClassroom.setText(laboratorio)
        tvDate.setText(LocalDate.now().toString())

        //UUID
        val uuid = UUID.randomUUID()
        val uuidString = uuid.toString()



        btnConfirm.setOnClickListener{
            val professor: Professor = Professor(textViewTeacher.text.toString())

            try{
                val recordId = dbRef!!.push().key

                val registro: RegistroAula = RegistroAula(recordId!!, professor.nome, tvDate.text.toString() , tfStartTime.text.toString(),
                    tfEndTime.text.toString(), projectorSwitch.isChecked.toString(), tvClassroom.text.toString(), false.toString())

                    dbRef!!.child(recordId).setValue(registro).addOnCompleteListener{
                        Toast.makeText(this@ClassRoomRequestActivity, R.string.requestCreated, Toast.LENGTH_SHORT).show()
                    }

            }catch(e: Exception){
                Toast.makeText(this@ClassRoomRequestActivity, R.string.somethingWrong , Toast.LENGTH_LONG).show()
            }
        }
    }


}
