package com.example.rectangulomvpapp.Contrato

interface ContratoRectangulo {
    interface modelo {
        fun area(base: Float, altura: Float): Float
        fun perimetro(base: Float, altura: Float): Float
        fun validacion(base: Float, altura: Float): Boolean
    }

    interface vista {
        fun showArea(area: Float)
        fun showPerimetro(perimetro: Float)
        fun showError(msg: String)
    }

    interface presentador{
        fun area(base: Float, altura: Float)
        fun perimetro(base: Float, altura: Float)
    }
}