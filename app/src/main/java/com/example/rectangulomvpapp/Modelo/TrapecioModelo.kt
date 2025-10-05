package com.example.rectangulomvpapp.Modelo

import com.example.rectangulomvpapp.Contrato.ContratoTrapecio

class TrapecioModelo: ContratoTrapecio.modelo {

    override fun area(baseMayor: Float, baseMenor: Float, altura: Float) : Float{
        return ((baseMayor + baseMenor) * altura)/2
    }

    override fun perimetro(baseMayor: Float, baseMenor: Float, ladoOblicuo: Float) : Float{
        return baseMenor + baseMayor + (ladoOblicuo * 2)
    }

    override fun validacion(baseMayor: Float, baseMenor: Float): Boolean{
        return if(baseMenor>baseMayor) false else true
    }
}