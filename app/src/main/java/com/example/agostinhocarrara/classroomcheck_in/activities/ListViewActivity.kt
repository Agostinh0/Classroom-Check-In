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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        addTeachers()

        recycler.layoutManager = LinearLayoutManager(this)


        recycler.adapter = ProfessorAdapter(teachers, this)

        addTeachers()
        }

    fun addTeachers(){
        var profUm = Professor("José", "Silva", "josesilva", "1234")
        teachers.add(profUm)
        var profDois =  Professor("João", "Souza", "joaosouza", "9876")
        teachers.add(profDois)
        var profTres = Professor("Paulo", "Santos", "paulosantos", "5647")
        teachers.add(profTres)
        var profQuatro = Professor("Renato", "de Moura", "renatodemoura", "4536")
        teachers.add(profQuatro)
    }

    }
