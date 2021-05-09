package com.example.pc01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val imc =intent.getStringExtra("paramImc")
        val clasi =intent.getStringExtra("paramClasi")
        val txtIMC = findViewById<TextView>(R.id.txtIMC)
        val txtClasi = findViewById<TextView>(R.id.txtClasificacion)
        txtIMC.text = imc
        txtClasi.text = clasi

        val btnSave : Button = findViewById(R.id.btnGuardar)

        btnSave.setOnClickListener {

            Toast.makeText(applicationContext, "Su IMC es de : $imc", Toast.LENGTH_SHORT).show()
            Toast.makeText(applicationContext, "Clasificación: $clasi", Toast.LENGTH_SHORT).show()
        }


    }
}