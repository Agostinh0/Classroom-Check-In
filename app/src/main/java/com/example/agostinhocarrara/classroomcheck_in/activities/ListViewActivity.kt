package com.example.agostinhocarrara.classroomcheck_in.activities

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.agostinhocarrara.classroomcheck_in.R
import com.example.agostinhocarrara.classroomcheck_in.adapters.RegistroAdapter
import com.example.agostinhocarrara.classroomcheck_in.beans.RegistroAula
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_class_room_request.*
import kotlinx.android.synthetic.main.activity_list_view.*
import kotlinx.android.synthetic.main.dialog.view.*
import kotlinx.android.synthetic.main.item_registro.*
import kotlinx.android.synthetic.main.item_registro.view.*


@Suppress("PLUGIN_WARNING")
class ListViewActivity : AppCompatActivity() {

    var aulas: ArrayList<RegistroAula> = ArrayList()

    var firebaseDatabase: FirebaseDatabase? = null
    var dbRef: DatabaseReference? = null
    var rAdapter: RegistroAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        firebaseDatabase = FirebaseDatabase.getInstance()
        dbRef = firebaseDatabase!!.getReference()

        rAdapter = RegistroAdapter(aulas, this)
        listView.adapter = rAdapter

        getDataFromFirebase()

            listView.onItemLongClickListener = AdapterView.OnItemLongClickListener { p0, p1, p2, p3 ->
            var record: RegistroAula = aulas.get(p2)
            showDialog(record.id!!)
            true
        }
    }

    fun approve(id: String?){
        if (id != null) {
            var myRef = dbRef!!.child(id).child("aprovado")

            myRef.setValue("true")
            Toast.makeText(this, "Solicitação aprovada!", Toast.LENGTH_SHORT).show()

        }
    }

    fun deny(id: String){
        dbRef!!.child(id).removeValue()
        Toast.makeText(this, "Solicitação excluída!", Toast.LENGTH_SHORT).show()
    }

    fun showDialog(id: String){
        var dialogBuilder = AlertDialog.Builder(this)
        var layoutInflater = getLayoutInflater()
        val dialogView = layoutInflater.inflate(R.layout.dialog, null)
        dialogBuilder.setView(dialogView)

        val buttonApprove = dialogView.btnApprove as Button
        val buttonDeny = dialogView.btnDeny as Button

        val b: AlertDialog = dialogBuilder.create()

        b.show()

        buttonDeny.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                deny(id)
                b.dismiss()
            }

        })

        buttonApprove.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                approve(id)
                b.dismiss()
            }

        })
    }

    fun getDataFromFirebase(){
        val newReference = firebaseDatabase!!.getReference()

        newReference.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                rAdapter!!.clear()
                aulas.clear()

                for(snapshot in p0.children){
                    val hashMap = snapshot.value as HashMap<String, String>
                    if(hashMap.size > 0){
                        val registro = RegistroAula(hashMap["id"].toString()!!, hashMap["professor"].toString()!!, hashMap["dia"].toString()!!,
                            hashMap["horaInicio"].toString()!!, hashMap["horaFim"].toString()!!, hashMap["usandoProjetor"].toString()!!,
                            hashMap["lab"].toString()!!, hashMap["aprovado"].toString()!!)

                        if(registro.aprovado.equals("false")){
                            aulas.add(registro)
                        }

                        rAdapter!!.notifyDataSetChanged()
                    }
                }
            }

        })
    }
}