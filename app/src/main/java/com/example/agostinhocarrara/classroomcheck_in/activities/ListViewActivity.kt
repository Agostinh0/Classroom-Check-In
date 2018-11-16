package com.example.agostinhocarrara.classroomcheck_in.activities

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.agostinhocarrara.classroomcheck_in.R
import com.example.agostinhocarrara.classroomcheck_in.adapters.RegistroAdapter
import com.example.agostinhocarrara.classroomcheck_in.beans.Professor
import com.example.agostinhocarrara.classroomcheck_in.beans.RegistroAula
import com.example.agostinhocarrara.classroomcheck_in.fragments.RecordDetailsFragment
import kotlinx.android.synthetic.main.activity_list_view.*
import java.time.LocalDate
import java.time.LocalTime

class ListViewActivity : AppCompatActivity() {


    val aulas: ArrayList<RegistroAula> = ArrayList()

    val profUm = Professor("José", "Silva", "josesilva", "1234")

    var profDois =  Professor("João", "Souza", "joaosouza", "9876")

    var profTres = Professor("Paulo", "Santos", "paulosantos", "5647")

    var profQuatro = Professor("Renato", "de Moura", "renatodemoura", "4536")

    @RequiresApi(Build.VERSION_CODES.O)
    fun initSignatures(){
        val registroUm = RegistroAula(profUm, LocalDate.of(2018, 12, 3),
        LocalTime.of(14, 0), LocalTime.of(16, 0), true, 35)

        aulas.add(registroUm)

        val registroDois = RegistroAula(profDois, LocalDate.of(2018, 12, 3),
            LocalTime.of(16, 0), LocalTime.of(18, 0), false, 37)

        aulas.add(registroDois)

        val registroTres = RegistroAula(profTres, LocalDate.of(2018, 12, 3),
            LocalTime.of(16, 0), LocalTime.of(18, 0), true, 39)

        aulas.add(registroTres)

        val registroQuatro = RegistroAula(profQuatro, LocalDate.of(2018, 12, 3),
            LocalTime.of(14, 0), LocalTime.of(16, 0), false, 41)

        aulas.add(registroQuatro)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        recycler.layoutManager = LinearLayoutManager(this)


        recycler.adapter = RegistroAdapter(aulas, this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            initSignatures()
        }

        //val fragment: RecordDetailsFragment = RecordDetailsFragment.newInstance()
        //replaceFragment(fragment)

    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

    }
