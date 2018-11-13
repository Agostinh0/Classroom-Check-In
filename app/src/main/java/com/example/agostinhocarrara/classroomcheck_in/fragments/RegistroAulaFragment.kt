package com.example.agostinhocarrara.classroomcheck_in.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.agostinhocarrara.classroomcheck_in.R

class RegistroAulaFragment: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view : View = inflater.inflate(R.layout.registro_fragment, container, false)

        return view

    }
}
