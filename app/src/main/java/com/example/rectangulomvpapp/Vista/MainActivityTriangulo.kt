package com.example.rectangulomvpapp.Vista

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.example.rectangulomvpapp.Contrato.ContratoTriangulo
import com.example.rectangulomvpapp.Vista.MainActivity

import com.example.rectangulomvpapp.Presentador.TrianguloPresentar
import com.example.rectangulomvpapp.R

class MainActivityTriangulo : AppCompatActivity(), ContratoTriangulo.Vista {

    private lateinit var txtResultado: TextView

    private lateinit var presentador: ContratoTriangulo.Presentador

    fun setPresentador(presentador: ContratoTriangulo.Presentador) {
        this.presentador = presentador
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_triangulo)

        val btnRegresar: Button=findViewById<Button>(R.id.btnRegresar)

        val txtl1: EditText =findViewById<EditText>(R.id.edtL1)
        val txtl2: EditText =findViewById<EditText>(R.id.edtL2)
        val txtl3: EditText =findViewById<EditText>(R.id.edtL3)
        val btnArea: Button =findViewById<Button>(R.id.btnArea)
        val btnPerimetro: Button =findViewById<Button>(R.id.btnPerimetro)
        val btnTipo: Button =findViewById<Button>(R.id.btnTipo)
        txtResultado=findViewById<TextView>(R.id.edtResultado)

        presentador = TrianguloPresentar(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnRegresar.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnPerimetro.setOnClickListener{
            val l1=txtl1.text.toString().toFloat()
            val l2=txtl2.text.toString().toFloat()
            val l3=txtl3.text.toString().toFloat()
            presentador.perimetro(l1,l2,l3)
        }
        //listener del boton para definir el tipo de triangulo
        btnTipo.setOnClickListener {
            val l1=txtl1.text.toString().toFloat()
            val l2=txtl2.text.toString().toFloat()
            val l3=txtl3.text.toString().toFloat()
            presentador.tipo(l1,l2,l3)
        }
        //listener del boton para calcular el area llamando a una funcion
        btnArea.setOnClickListener {
            val l1=txtl1.text.toString().toFloat()
            val l2=txtl2.text.toString().toFloat()
            val l3=txtl3.text.toString().toFloat()
            presentador.area(l1,l2,l3)
        }
    }

    override fun showArea(area: Float) {
        txtResultado.text="El area es ${area}"
    }

    override fun showPerimetro(perimetro: Float) {
        txtResultado.text="El perimetro es ${perimetro}"
    }

    override fun showTipo(tipo: String) {
        txtResultado.text="${tipo}"
    }

    override fun showError(msg: String) {
        txtResultado.text=msg
    }
}