package com.example.agostinhocarrara.classroomcheck_in.beans

class Professor(s: String, s1: String, s2: String, s3: String) {
    var nome: String? = null
    var sobrenome: String? = null
    var nomeUsuario: String? = null
    var senha: String? = null

    fun Professor(nome: String, sobrenome: String, nomeUsuario: String, senha: String){
        this.nome = nome
        this.sobrenome = nome
        this.nomeUsuario = nomeUsuario
        this.senha = senha
    }

    override fun toString(): String{
        return nome + sobrenome
    }
}