package com.example.agostinhocarrara.classroomcheck_in.adapters

import android.app.Activity
import android.content.Context
import android.database.DataSetObserver
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import com.example.agostinhocarrara.classroomcheck_in.R
import com.example.agostinhocarrara.classroomcheck_in.beans.RegistroAula
import kotlinx.android.synthetic.main.item_registro.view.*

class RegistroAdapter(val records: ArrayList<RegistroAula>, val context: Activity): ArrayAdapter<RegistroAula>(context, R.layout.item_registro, records) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater = context.layoutInflater
        val customView = layoutInflater.inflate(R.layout.item_registro,null,true)

        customView.tvTeacher.text = records[position].professor
        customView.tvLab.text = records[position].lab
        customView.tvDate.text = records[position].dia
        customView.tvTime.text = records[position].horaInicio.toString()
        customView.tvEndTime.text = records[position].horaFim.toString()
        if(records[position].usandoProjetor.toString().equals("true")) {
            customView.tvProjector.setText(R.string.useProjector)
        }else{
            customView.tvProjector.setText(R.string.didntUseProjector)
        }
        return customView

    }
}