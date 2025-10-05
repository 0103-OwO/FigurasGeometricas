package com.example.rectangulomvpapp.Presentador

import com.example.rectangulomvpapp.Contrato.ContratoTrapecio
import com.example.rectangulomvpapp.Modelo.TrapecioModelo

class TrapecioPresentador(private val vista: ContratoTrapecio.vista): ContratoTrapecio.presentador {

    private val modelo : ContratoTrapecio.modelo = TrapecioModelo()

    override fun area(baseMayor: Float, baseMenor: Float, altura: Float){
        if(modelo.validacion(baseMayor,baseMenor)){
            val a = modelo.area(baseMayor,baseMenor,altura)
            vista.showArea(a)
        }
        else{
            vista.showError("Datos incorrectos")
        }
    }
    override fun perimetro(baseMayor: Float, baseMenor: Float, ladoOblicuo: Float){
        if(modelo.validacion(baseMayor,baseMenor)){
            val a = modelo.perimetro(baseMayor,baseMenor,ladoOblicuo)
            vista.showPerimetro(a)
        }
        else{
            vista.showError("Datos incorrectos")
        }
    }
}