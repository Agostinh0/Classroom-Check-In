package com.example.agostinhocarrara.classroomcheck_in.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.agostinhocarrara.classroomcheck_in.beans.Professor
import com.example.agostinhocarrara.classroomcheck_in.R
import kotlinx.android.synthetic.main.item_professor.view.*

class ProfessorAdapter(val items: ArrayList<Professor>, val context: Context): RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvNome = view.tvName
        val tvSobrenome = view.tvLasname

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_professor, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolder){
            holder?.tvNome?.text = items.get(position).nome.toString()
            holder?.tvSobrenome?.text = items.get(position).sobrenome.toString()
        }
    }

    override fun getItemCount(): Int{
        return items.size
    }
}