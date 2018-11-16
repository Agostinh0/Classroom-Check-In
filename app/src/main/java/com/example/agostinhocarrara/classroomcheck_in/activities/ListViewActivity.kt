package com.example.agostinhocarrara.classroomcheck_in.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.agostinhocarrara.classroomcheck_in.R
import com.example.agostinhocarrara.classroomcheck_in.adapters.ProfessorAdapter
import com.example.agostinhocarrara.classroomcheck_in.beans.Professor
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    val teachers: ArrayList<Professor> = ArrayList()

    fun initTeachers(){
        val profUm = Professor("José", "Silva", "josesilva", "1234")
        teachers.add(profUm)
        var profDois =  Professor("João", "Souza", "joaosouza", "9876")
        teachers.add(1, profDois)
        var profTres = Professor("Paulo", "Santos", "paulosantos", "5647")
        teachers.add(2, profTres)
        var profQuatro = Professor("Renato", "de Moura", "renatodemoura", "4536")
        teachers.add(3, profQuatro)
        var profCinco = Professor("Marcelo", "Costa", "marcelocosta", "7483")
        teachers.add(profCinco)
        var profSeis = Professor("Rodolfo", "Abreu", "rodolfoabreu", "5463")
        teachers.add(profSeis)
        var profSete = Professor("Cristiano", "Ronaldo", "cristianoronaldo", "3425")
        teachers.add(profSete)
        var profOito = Professor("Leonardo", "Moraes", "leonardomoraes", "8970")
        teachers.add(profOito)
        var profNove = Professor("Robert", "Smith", "robertsmith", "5461")
        teachers.add(profNove)
        var profDez = Professor("Felipe", "Massa", "felipemassa", "1111")
        teachers.add(profDez)
        var profOnze = Professor("Sebastião", "Pires", "sebastiaopires", "9873")
        teachers.add(profOnze)
        var profDoze = Professor("Luis", "Vieira", "luisvieira", "6781")
        teachers.add(profDoze)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        recycler.layoutManager = LinearLayoutManager(this)


        recycler.adapter = ProfessorAdapter(teachers, this)

        initTeachers()
        }

    }
