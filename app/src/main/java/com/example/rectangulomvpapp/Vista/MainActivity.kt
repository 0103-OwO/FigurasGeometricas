package com.example.rectangulomvpapp.Vista

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rectangulomvpapp.R

class MainActivity : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnTriangulo: Button =findViewById<Button>(R.id.btnTriangulo)
        val btnRectangulo: Button =findViewById<Button>(R.id.btnRectangulo)
        val btnPentagono: Button =findViewById<Button>(R.id.btnPentagono)
        val btnCirculo: Button =findViewById<Button>(R.id.btnCirculo)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Botones para moverse atraves de las demas pantallas
        btnTriangulo.setOnClickListener {
            val intent: Intent = Intent(this, MainActivityTriangulo::class.java)
            startActivity(intent)
        }

        btnRectangulo.setOnClickListener {
            val intent: Intent = Intent(this, MainActivityRectangulo::class.java)
            startActivity(intent)
        }
        btnPentagono.setOnClickListener {
            val intent: Intent = Intent(this, MainActivityTrapecio::class.java)
            startActivity(intent)
        }

        btnCirculo.setOnClickListener {
            val intent: Intent = Intent(this, MainActivityCirculo::class.java)
            startActivity(intent)
        }


    }
}