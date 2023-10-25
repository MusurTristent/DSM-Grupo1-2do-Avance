package com.example.logincondosa.ui.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ForgotViewModel: ViewModel(){
    private val _correo = MutableLiveData<String>()
    val correo : LiveData<String> =_correo

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> =_password

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable: LiveData<Boolean> = _loginEnable

    fun onLoginChanged(correo: String, password: String){
        _correo.value = correo
        _password.value = password
        _loginEnable.value = isValidEmail(correo) && isValidPassword(password)
    }

    private fun isValidEmail     (correo: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(correo).matches()
    private fun isValidPassword (password: String): Boolean = password.length > 3

    fun onLoginSelected(){

    }

}