package com.example.agostinhocarrara.classroomcheck_in.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.agostinhocarrara.classroomcheck_in.R
import com.example.agostinhocarrara.classroomcheck_in.beans.RegistroAula
import kotlinx.android.synthetic.main.item_registro.view.*

class RegistroAdapter(val items: ArrayList<RegistroAula>, val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvTeacher = view.tvTeacher!!
        val tvLab = view.tvLab!!
        val tvDate = view.tvDate!!
        val tvTime = view.tvTime!!
        val tvProjector = view.tvProjector!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_registro, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolder){
            holder.tvTeacher.setText(items.get(position).professor.toString())
            holder.tvLab.setText(items.get(position).lab.toString())
            holder.tvDate.setText(items.get(position).dia.toString())
            holder.tvTime.setText(items.get(position).startTime.toString())
            holder.tvProjector.setText(items.get(position).isUsingProjector.toString())
        }
    }

    override fun getItemCount(): Int{
        return items.size
    }
}