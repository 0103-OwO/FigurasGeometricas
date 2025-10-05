package com.example.rectangulomvpapp.Contrato

interface ContratoCirculo {

    interface modelo {
        fun area(radio: Double): Double
        fun perimetro(radio: Double): Double
        fun validacion(radio: Double): Boolean
    }

    interface vista {
        fun showArea(area: Double)
        fun showPerimetro(perimetro: Double)
        fun showError(msg: String)
    }

    interface presentador{
        fun area(radio: Double)
        fun perimetro(radio: Double)
    }
}