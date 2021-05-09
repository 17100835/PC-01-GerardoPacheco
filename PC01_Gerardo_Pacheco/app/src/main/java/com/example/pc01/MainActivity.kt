package com.example.pc01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getTalla: EditText = findViewById(R.id.txtTalla)
        val getPeso: EditText = findViewById(R.id.txtPeso)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener {

            var talla = getTalla.text.toString().toFloat()/100
            var peso =  getPeso.text.toString().toFloat()
            var clasi = ""
            var imc = (peso/(talla * talla))

            /*Bajo Peso < 18.5 amarillo
              Normal 18.5 - 24.9 verde
              Sobrepeso 25.0 - 29.9 naranja
              Obesidad grado I 30.0 - 34.5 naranja
              Obesidad grado II 35.0 - 39.9 rojo
              Obesidad grado III > 40.0 rojo*/

            if(imc >= 0 && imc <18.5) {
                clasi = "Bajo"
            }else if(imc >= 18.5 && imc <= 24.9){
                clasi = "Normal"
            }else if(imc >= 25.0 && imc <= 29.9){
                clasi = "Sobrepeso"
            }else if(imc >= 30.0 && imc <= 34.5){
                clasi = "Obesidad grado I"
            }else if(imc >= 35.0 && imc <= 39.9){
                clasi = "Obesidad grado II"
            }else{
                clasi = "Obesidad grado III"
            }

            this.sendMessage(imc.toString(), clasi)
        }

    }

    private fun sendMessage(imc: String, clasi: String)
    {
        val intent = Intent(this, ResultadoActivity::class.java)
        intent.putExtra("paramImc", imc)
        intent.putExtra("paramClasi", clasi)
        startActivity(intent);
    }
}