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
import com.example.rectangulomvpapp.Contrato.ContratoRectangulo
import com.example.rectangulomvpapp.Vista.MainActivity
import com.example.rectangulomvpapp.Presentador.PresentadorRectangulo
import com.example.rectangulomvpapp.R

class MainActivityRectangulo : AppCompatActivity(), ContratoRectangulo.vista{

    private lateinit var txtResultado: TextView

    private  lateinit var presentador: ContratoRectangulo.presentador

    fun setPresentador(presentador: ContratoRectangulo.presentador){
        this.presentador=presentador
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_rectangulo)

        val btnRegresar: Button=findViewById<Button>(R.id.btnRegresar)

        val txtBase: EditText=findViewById<EditText>(R.id.edtBase)
        val txtAltura: EditText=findViewById<EditText>(R.id.edtAltura)
        val btnArea: Button=findViewById<Button>(R.id.btnArea)
        val btnPerimetro: Button=findViewById<Button>(R.id.btnPerimetro)

        txtResultado = findViewById<EditText>(R.id.edtResultado)

        presentador = PresentadorRectangulo(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnRegresar.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnArea.setOnClickListener {
            val base = txtBase.text.toString().toFloat()
            val altura = txtAltura.text.toString().toFloat()
            presentador.area(base,altura)
        }

        btnPerimetro.setOnClickListener {
            val base = txtBase.text.toString().toFloat()
            val altura = txtAltura.text.toString().toFloat()
            presentador.perimetro(base,altura)
        }
    }

    //Rectangulo
    override fun showArea(area : Float){
        txtResultado.text = "${area}"
    }

    override fun showPerimetro(perimetro: Float){
        txtResultado.text = "${perimetro}"
    }

    override fun showError(msg: String){
        txtResultado.text=msg;
    }
}