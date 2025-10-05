package com.example.rectangulomvpapp.Contrato

interface ContratoTrapecio {

    interface modelo {
        fun area(baseMayor: Float, baseMenor: Float, altura: Float) : Float

        fun perimetro(baseMayor: Float, baseMenor: Float, ladoOblicuo: Float) : Float

        fun validacion(baseMayor: Float, baseMenor: Float): Boolean
    }

    interface vista {
        fun showArea(area: Float)
        fun showPerimetro(perimetro: Float)
        fun showError(msg: String)
    }

    interface presentador{
        fun area(baseMayor: Float, baseMenor: Float, altura: Float)
        fun perimetro(baseMayor: Float, baseMenor: Float, ladoOblicuo: Float)
    }
}