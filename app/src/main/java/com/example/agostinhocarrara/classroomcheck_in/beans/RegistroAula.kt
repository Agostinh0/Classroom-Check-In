package com.example.agostinhocarrara.classroomcheck_in.beans

import java.time.LocalDate
import java.time.LocalTime


class RegistroAula(var professor: Professor, var dia: LocalDate, var startTime: LocalTime,
                   var endTime: LocalTime, var isUsingProjector: Boolean, var lab: Int){

    override fun toString(): String{
        var texto: String = professor.nome
        texto += "\n" + isUsingProjector
        return texto
    }

}