package com.example.agostinhocarrara.classroomcheck_in.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.agostinhocarrara.classroomcheck_in.R
import com.example.agostinhocarrara.classroomcheck_in.adapters.ProfessorAdapter
import com.example.agostinhocarrara.classroomcheck_in.beans.Professor

class ListViewActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    val teachers: ArrayList<Professor> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        this.recyclerView = findViewById(R.id.recycler) as RecyclerView
        var mLayoutManager = LinearLayoutManager(this)
        this.recyclerView.setLayoutManager(mLayoutManager)

        var adapter = ProfessorAdapter(recyclerView)
        this.recyclerView.setAdapter(adapter)

        addTeachers()
        }

    fun addTeachers(){
        teachers.add(
            Professor(
                "José",
                "Silva",
                "josesilva",
                "12345"
            )
        )
        teachers.add(
            Professor(
                "João",
                "Souza",
                "joaosouza",
                "98765"
            )
        )
        teachers.add(
            Professor(
                "Pedro",
                "Lima",
                "pedrolima",
                "13579"
            )
        )
        teachers.add(
            Professor(
                "Roberto",
                "de Moura",
                "robertodemoura",
                "24680"
            )
        )
        teachers.add(
            Professor(
                "Paulo",
                "Miranda",
                "paulomiranda",
                "45361"
            )
        )
    }

    }