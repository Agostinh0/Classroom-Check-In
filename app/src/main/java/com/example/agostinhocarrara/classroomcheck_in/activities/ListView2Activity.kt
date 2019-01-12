package com.example.agostinhocarrara.classroomcheck_in.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.agostinhocarrara.classroomcheck_in.R
import com.example.agostinhocarrara.classroomcheck_in.adapters.RegistroAdapter
import com.example.agostinhocarrara.classroomcheck_in.beans.RegistroAula
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_list_view2.*

@Suppress("PLUGIN_WARNING")
class ListView2Activity : AppCompatActivity() {

    var aulasConfirmadas: ArrayList<RegistroAula> = ArrayList()

    var firebaseDatabase: FirebaseDatabase? = null
    var dbRef: DatabaseReference? = null
    var rAdapter: RegistroAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view2)

        firebaseDatabase = FirebaseDatabase.getInstance()
        dbRef = firebaseDatabase!!.getReference()

        rAdapter = RegistroAdapter(aulasConfirmadas, this)
        listView2.adapter = rAdapter

        getDataFromFirebase()

    }

    fun getDataFromFirebase() {
        val newReference = firebaseDatabase!!.getReference()

        newReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                rAdapter!!.clear()
                aulasConfirmadas.clear()

                for (snapshot in p0.children) {
                    val hashMap = snapshot.value as HashMap<String, String>
                    if (hashMap.size > 0) {
                        val registro = RegistroAula(
                            hashMap["id"].toString()!!,
                            hashMap["professor"].toString()!!,
                            hashMap["dia"].toString()!!,
                            hashMap["horaInicio"].toString()!!,
                            hashMap["horaFim"].toString()!!,
                            hashMap["usandoProjetor"].toString()!!,
                            hashMap["lab"].toString()!!,
                            hashMap["aprovado"].toString()!!
                        )

                        if (registro.aprovado.equals("true")) {
                            aulasConfirmadas.add(registro)
                        }

                        rAdapter!!.notifyDataSetChanged()
                    }
                }
            }

        })
    }
}
