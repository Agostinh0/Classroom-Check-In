package com.example.agostinhocarrara.classroomcheck_in.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.agostinhocarrara.classroomcheck_in.R

class RecordDetailsFragment: Fragment(){

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    companion object {
        fun newInstance() = RecordDetailsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.record_details_fragment, container, false)
    }
}