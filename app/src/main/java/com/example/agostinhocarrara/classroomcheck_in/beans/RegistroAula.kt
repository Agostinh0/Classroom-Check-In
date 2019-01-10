package com.example.agostinhocarrara.classroomcheck_in.beans

import com.google.firebase.database.Exclude

class RegistroAula(var id: String, var professor: String, var dia: String, var horaInicio: String,
                   var horaFim: String, var usandoProjetor: Boolean, var lab: String, var aprovado: Boolean){

    override fun toString(): String{
        var texto: String = professor
        texto += "\n" + usandoProjetor
        return texto
    }

    @Exclude
    fun toMap(): Map<String, Any>{

        val result = HashMap<String, Any>()
        result.put("id", id!!)
        result.put("professor", professor!!)
        result.put("dia", dia!!)
        result.put("startTime", horaInicio!!)
        result.put("endTime", horaFim!!)
        result.put("usingProjector", usandoProjetor!!)
        result.put("lab", lab!!)
        result.put("aprovado", aprovado!!)

        return result

    }

}