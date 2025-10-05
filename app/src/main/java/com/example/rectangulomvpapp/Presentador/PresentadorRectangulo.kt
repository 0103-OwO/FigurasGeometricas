package com.example.rectangulomvpapp.Presentador

import com.example.rectangulomvpapp.Contrato.ContratoRectangulo
import com.example.rectangulomvpapp.Modelo.ModeloRectangulo

class PresentadorRectangulo(private val vista: ContratoRectangulo.vista): ContratoRectangulo.presentador {

    private val modelo : ContratoRectangulo.modelo = ModeloRectangulo()

    override fun area(base: Float, altura: Float){
        if(modelo.validacion(base,altura)){
            val a = modelo.area(base,altura)
            vista.showArea(a)
        }
        else{
            vista.showError("Datos incorrectos")
        }
    }
    override fun perimetro(base: Float, altura: Float){
        if(modelo.validacion(base,altura)){
            val a = modelo.perimetro(base,altura)
            vista.showPerimetro(a)
        }
        else{
            vista.showError("Datos incorrectos")
        }
    }
}