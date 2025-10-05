package com.example.rectangulomvpapp.Modelo

import com.example.rectangulomvpapp.Contrato.ContratoRectangulo

class ModeloRectangulo: ContratoRectangulo.modelo {

    override fun area(base: Float, altura: Float): Float{
        return base * altura;
    }

    override fun perimetro(base: Float, altura: Float): Float{
        return (base*2)+(altura*2)
    }

    override fun validacion(base: Float, altura: Float): Boolean {
        return if (base != altura)true else false
    }
}