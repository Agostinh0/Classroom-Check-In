package com.example.agostinhocarrara.classroomcheck_in.beans

import com.google.firebase.database.Exclude

class RegistroAula(var id: String, var professor: String, var dia: String, var startTime: String,
                   var endTime: String, var isUsingProjector: Boolean, var lab: String, var aprovado: Boolean){

    override fun toString(): String{
        var texto: String = professor
        texto += "\n" + isUsingProjector
        return texto
    }

    @Exclude
    fun toMap(): Map<String, Any>{

        val result = HashMap<String, Any>()
        result.put("id", id!!)
        result.put("professor", professor!!)
        result.put("dia", dia!!)
        result.put("startTime", startTime!!)
        result.put("endTime", endTime!!)
        result.put("usingProjector", isUsingProjector!!)
        result.put("lab", lab!!)
        result.put("aprovado", aprovado!!)

        return result

    }

}