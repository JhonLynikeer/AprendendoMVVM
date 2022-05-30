package com.trkgames.mvvmcurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.trkgames.mvvmcurso.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var  viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener(this)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)





        setObserver()

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_login){
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            viewModel.doLogin(email,senha)

        }
    }


    private fun setObserver(){
        viewModel.welcome().observe(this, Observer {
            binding.welcom.text = it
        })
        viewModel.login().observe(this, Observer {
            if (it){
                Toast.makeText(applicationContext,"SUCESSO!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext,"Falha!", Toast.LENGTH_LONG).show()
            }
        })

    }



}


