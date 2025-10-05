package com.example.rectangulomvpapp.Modelo

import androidx.core.flagging.Flags
import com.example.rectangulomvpapp.Contrato.ContratoCirculo
import kotlin.math.pow

class CirculoModelo: ContratoCirculo.modelo {

    override fun area(radio: Double): Double{
        return Math.PI * (radio.pow(2))
    }

    override fun perimetro(radio: Double): Double{
        return 2 * Math.PI * radio
    }

    override fun validacion(radio: Double): Boolean{
        return if(radio>0)true else false
    }

}