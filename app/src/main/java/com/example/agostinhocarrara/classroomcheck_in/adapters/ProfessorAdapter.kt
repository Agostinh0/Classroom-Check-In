package com.example.agostinhocarrara.classroomcheck_in.adapters

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.agostinhocarrara.classroomcheck_in.beans.Professor
import com.example.agostinhocarrara.classroomcheck_in.R

class ProfessorAdapter(recyclerView: RecyclerView): RecyclerView.Adapter<ProfessorAdapter.ProfessorViewHolder>() {

    private var teachers = ArrayList<Professor>()

    class ProfessorViewHolder(val textView: View) : ViewHolder(textView){
        lateinit var view: View
        lateinit var tvName: TextView
        lateinit var tvLasname: TextView

        fun ProfessorViewHolder(view: View){
            this.view = view
            tvName = view.findViewById(R.id.tvName)
            tvLasname = view.findViewById(R.id.tvLasname)
        }
    }

    fun ProfessorAdapter(teachers: ArrayList<Professor>){
        this.teachers = teachers
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessorViewHolder {
        var view: View = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_professor, parent, false)

        var newViewHolder =
            ProfessorViewHolder(view)
        return newViewHolder
    }

    override fun onBindViewHolder(holder: ProfessorViewHolder, position: Int) {
        var teacher = teachers.get(position)

        holder.tvName.setText(teacher.nome)
        holder.tvLasname.setText(teacher.sobrenome)
    }

    override fun getItemCount(): Int{
        if(teachers != null){
            return teachers.size
        }else{
            return 0
        }
    }
}