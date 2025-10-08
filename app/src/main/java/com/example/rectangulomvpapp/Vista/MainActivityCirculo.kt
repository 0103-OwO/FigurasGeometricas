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
import com.example.rectangulomvpapp.Contrato.ContratoCirculo
import com.example.rectangulomvpapp.Vista.MainActivity
import com.example.rectangulomvpapp.Presentador.CirculoPresentar

import com.example.rectangulomvpapp.R

class MainActivityCirculo : AppCompatActivity(), ContratoCirculo.vista {

    private lateinit var txtResultado: TextView

    private lateinit var presentador: ContratoCirculo.presentador

    fun setPresentador(presentador: ContratoCirculo.presentador) {
        this.presentador = presentador
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_circulo)

        val btnRegresar: Button=findViewById<Button>(R.id.btnRegresar)

        val txtRadio: EditText =findViewById<EditText>(R.id.edtRadio)
        val btnArea: Button =findViewById<Button>(R.id.btnArea)
        val btnPerimetro: Button =findViewById<Button>(R.id.btnPerimetro)

        txtResultado=findViewById<TextView>(R.id.edtResultado)

        presentador= CirculoPresentar(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnRegresar.setOnClickListener {
            val intent: Intent = Intent(this, MainActivityMenu::class.java)
            startActivity(intent)
        }

        btnArea.setOnClickListener {
            val radio = txtRadio.text.toString().toDouble()
            presentador.area(radio)
        }

        btnPerimetro.setOnClickListener {
            val radio = txtRadio.text.toString().toDouble()
            presentador.perimetro(radio)
        }
    }
    override fun showArea(area : Double){
        txtResultado.text = "${area}"
    }

    override fun showPerimetro(perimetro: Double){
        txtResultado.text = "${perimetro}"
    }

    override fun showError(msg: String){
        txtResultado.text=msg;
    }
}