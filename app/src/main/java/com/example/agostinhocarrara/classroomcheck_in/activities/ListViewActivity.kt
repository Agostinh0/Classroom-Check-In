package com.example.agostinhocarrara.classroomcheck_in.activities

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.NonNull
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.agostinhocarrara.classroomcheck_in.R
import com.example.agostinhocarrara.classroomcheck_in.adapters.RegistroAdapter
import com.example.agostinhocarrara.classroomcheck_in.beans.RegistroAula
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_class_room_request.view.*
import kotlinx.android.synthetic.main.activity_list_view.*
import kotlinx.android.synthetic.main.item_registro.view.*

class ListViewActivity : AppCompatActivity() {

    /*var aulas: ArrayList<RegistroAula> = ArrayList()

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
    } */

    var mDatabase: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        mDatabase = FirebaseDatabase.getInstance().getReference()
        mDatabase!!.keepSynced(true)

        recycler.setHasFixedSize(true)
        recycler.setLayoutManager(LinearLayoutManager(this))

    }

    override fun onStart() {
        super.onStart()

        var query: Query = FirebaseDatabase.getInstance().reference

        var options = FirebaseRecyclerOptions.Builder<RegistroAula>()
            .setQuery(query, RegistroAula::class.java)
            .build()

        var rAdapter = object : FirebaseRecyclerAdapter<RegistroAula, RegistroHolder>(options) {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegistroHolder {
                var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_registro, parent, false)

                var holder = RegistroHolder(view)

                return holder
            }

            override fun onBindViewHolder(holder: RegistroHolder, position: Int, model: RegistroAula) {
                if(holder is ListViewActivity.RegistroHolder){
                    holder.tvTeacher.setText(model.professor)
                    holder.tvLab.setText(model.lab)
                    //holder.tvDate.setText(model.dia)
                    holder.tvTime.setText(model.horaInicio)
                    holder.tvProjector.setText(model.usandoProjetor.toString())
                }
            }

        }

        recycler.adapter = rAdapter

}

    class RegistroHolder(var mView: View): RecyclerView.ViewHolder(mView){
        val tvTeacher = mView.tvTeacher!!
        val tvLab = mView.tvLab!!
        //val tvDate = mView.tvDate!!
        val tvTime = mView.tvTime!!
        val tvProjector = mView.tvProjector!!
    }
}
