package com.trkgames.mvvmcurso

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var textwelcom = MutableLiveData<String>()
    private var login = MutableLiveData<Boolean>()
    private val personReposytori = PersonReposytori()


    init {
        textwelcom.value = "Olá"
    }


    fun welcome(): LiveData<String>{
        return textwelcom
    }

    fun login(): LiveData<Boolean>{
        return login
    }

    fun doLogin(email: String, senha: String){
       login.value = personReposytori.login(email, senha)


    }

}