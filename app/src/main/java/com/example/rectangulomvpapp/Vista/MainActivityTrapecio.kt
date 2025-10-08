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
import com.example.rectangulomvpapp.Contrato.ContratoTrapecio
import com.example.rectangulomvpapp.Vista.MainActivity
import com.example.rectangulomvpapp.Presentador.TrapecioPresentador
import com.example.rectangulomvpapp.R

class MainActivityTrapecio : AppCompatActivity(), ContratoTrapecio.vista {

    private lateinit var txtResultado: TextView

    private lateinit var presentador: ContratoTrapecio.presentador

    fun setPresentador(presentador: ContratoTrapecio.presentador) {
        this.presentador = presentador
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_trapecio)

        val btnRegresar: Button=findViewById<Button>(R.id.btnRegresar)

        val txtBMayor: EditText =findViewById<EditText>(R.id.edtbMay)
        val txtBMenor: EditText =findViewById<EditText>(R.id.edtbMen)
        val txtAltura: EditText =findViewById<EditText>(R.id.edtAltura)
        val txtLOblicuo: EditText =findViewById<EditText>(R.id.edtLOblicuo)

        val btnArea: Button =findViewById<Button>(R.id.btnArea)
        val btnPerimetro: Button =findViewById<Button>(R.id.btnPerimetro)

        txtResultado=findViewById<TextView>(R.id.edtResultado)

        presentador= TrapecioPresentador(this)


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
            val bMayor = txtBMayor.text.toString().toFloat()
            val bMenor = txtBMenor.text.toString().toFloat()
            val altura = txtAltura.text.toString().toFloat()

            presentador.area(bMayor, bMenor, altura)
        }

        btnPerimetro.setOnClickListener {
            val bMayor = txtBMayor.text.toString().toFloat()
            val bMenor = txtBMenor.text.toString().toFloat()
            val lOblicuo = txtLOblicuo.text.toString().toFloat()

            presentador.perimetro(bMayor,bMenor,lOblicuo)
        }
    }

    override fun showArea(area: Float) {
        txtResultado.text="${area}"
    }

    override fun showPerimetro(perimetro: Float) {
        txtResultado.text="${perimetro}"
    }

    override fun showError(msg: String) {
        txtResultado.text=msg
    }
}