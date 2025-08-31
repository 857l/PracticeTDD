package com.github.johnnysc.practicetdd


data class WeatherUiModel(
    private val description: String,
    private val isError: Boolean = false
) {

    fun map(communication: LoginCommunication){
        if (isError) communication.map(LoginState.Error(this))
        else communication.map(LoginState.Success(this))
    }
}