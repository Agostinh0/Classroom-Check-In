package com.example.agostinhocarrara.classroomcheck_in.activities

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.agostinhocarrara.classroomcheck_in.R
import com.example.agostinhocarrara.classroomcheck_in.adapters.RegistroAdapter
import com.example.agostinhocarrara.classroomcheck_in.beans.RegistroAula

import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    var aulas: ArrayList<RegistroAula> = ArrayList()

    var firebaseDatabase: FirebaseDatabase? = null
    var dbRef: DatabaseReference? = null
    var recordAdapter: RegistroAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        firebaseDatabase = FirebaseDatabase.getInstance()
        dbRef = firebaseDatabase!!.getReference()

        recordAdapter = RegistroAdapter(aulas, this)
        recycler.adapter = recordAdapter

        if (FirebaseDatabase.getInstance() == null) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        }

        recycler.layoutManager = LinearLayoutManager(this)

        getDataFromFirebase()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // initSignatures()
        }
    }



    fun getDataFromFirebase(){
        val newReference = firebaseDatabase!!.getReference("registros")

        newReference.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                aulas.clear()

                for(snapshot in p0.children){
                    val hashMap = snapshot.value as HashMap<Any, String>
                    val hashMap3: HashMap<Any, Boolean> = snapshot.value as HashMap<Any, Boolean>
                    if(hashMap.size > 0){
                        val registro = RegistroAula(hashMap["id"]!!, hashMap["professor"]!!, hashMap["dia"]!!,
                            hashMap["startTime"]!!, hashMap["endTime"]!!, hashMap["usingProjector"]!!.toBoolean(),
                            hashMap["lab"]!!, hashMap3["aprovado"]!!)

                        aulas.add(registro)

                        recordAdapter!!.notifyDataSetChanged()
                    }
                }
            }

        })
    }
}
