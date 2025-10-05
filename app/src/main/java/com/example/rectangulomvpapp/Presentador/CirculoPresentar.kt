package com.example.rectangulomvpapp.Presentador

import com.example.rectangulomvpapp.Contrato.ContratoCirculo
import com.example.rectangulomvpapp.Modelo.CirculoModelo


class CirculoPresentar(private val vista: ContratoCirculo.vista): ContratoCirculo.presentador {

    private val modelo : ContratoCirculo.modelo = CirculoModelo()

    override fun area(radio: Double){
        if(modelo.validacion(radio)){
            val a = modelo.area(radio)
            vista.showArea(a)
        }
        else{
            vista.showError("Datos incorrectos")
        }
    }
    override fun perimetro(radio: Double){
        if(modelo.validacion(radio)){
            val a = modelo.perimetro(radio)
            vista.showPerimetro(a)
        }
        else{
            vista.showError("Datos incorrectos")
        }
    }
}