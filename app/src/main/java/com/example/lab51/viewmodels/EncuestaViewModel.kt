package com.example.lab51.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author Bryann
 * ViewModel for the encuesta
 */
class EncuestaViewModel : ViewModel() {


    private  var _pregunta=MutableLiveData<String>()
    private var index:Int=0
    val preguntas:LiveData<String>
        get() = _pregunta

    private lateinit var preguntasList:MutableList<String>

    init {
        makePregunta()
        selectPregunta()
        Log.i("EncuestaView","Creado View Model")
    }

    private fun makePregunta(){
        preguntasList= mutableListOf(
            "Cual es tu opinion",
            "Calificanos"
        )
    }
     fun selectPregunta(): String {
         if (preguntasList.getOrNull(index).isNullOrEmpty()){
             _pregunta.value=""
             return preguntas.toString()
         }else{
             _pregunta.value=preguntasList.get(index)
             index++
             return preguntas.toString()

         }

    }

    fun addPregunta(pregunta:String){
        preguntasList.add(pregunta)
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("EncuestaViewModel","OnCleared Model")
    }
}
