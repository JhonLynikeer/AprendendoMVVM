package com.trkgames.mvvmcurso

class PersonReposytori {
    fun login(email: String, senha: String) : Boolean{
        return (email != "" && senha != "")
    }

}