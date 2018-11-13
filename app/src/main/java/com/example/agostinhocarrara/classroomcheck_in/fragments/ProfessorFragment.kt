package com.example.agostinhocarrara.classroomcheck_in.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.agostinhocarrara.classroomcheck_in.beans.Professor
import com.example.agostinhocarrara.classroomcheck_in.R

class ProfessorFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    private lateinit var mList: List<Professor>

    fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?){
        var view: View = inflater.inflate(R.layout.activity_list_view, container, false)

        recyclerView = view.findViewById(R.id.recycler) as RecyclerView
        recyclerView.setHasFixedSize(true)


        var llm: LinearLayoutManager = LinearLayoutManager(getActivity())
        llm.setOrientation(LinearLayoutManager.VERTICAL)

        recyclerView.setLayoutManager(llm)

        /*mList = getActivity().setP
        var adapter = ProfessorAdapter(getActivity())*/ 
    }

}
