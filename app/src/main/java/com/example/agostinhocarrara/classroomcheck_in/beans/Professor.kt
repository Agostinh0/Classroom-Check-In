package com.example.agostinhocarrara.classroomcheck_in.beans

class Professor(var nome: String, var sobrenome: String, var nomeUsuario: String, var senha: String) {


    override fun toString(): String{
        return nome + sobrenome
    }
}