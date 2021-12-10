
package com.example.myapplicationintent


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.myapplicationintent.Ingresar_reciclables_publicador
import com.example.myapplicationintent.databinding.IngresarReciclablesPublicador2Binding
import com.example.myapplicationintent.databinding.IngresarReciclablesPublicador3Binding
import com.example.myapplicationintent.databinding.IngresarReciclablesPublicadorBinding

class Ingresar_reciclables_publicador2: AppCompatActivity() { // View Binding
    private lateinit var binding: IngresarReciclablesPublicador2Binding

    private var REQUESET_CODE2 = 123588
    private var REQUEST_CODE = 1234

    companion object {
        const val TAG_APP = "myExplicitIntent2"
        const val MATERIAL = "MATERIAL"
        const val CANTIDAD = "CANTIDAD"
        const val UNIDAD = "UNIDAD"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = IngresarReciclablesPublicador2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAgregar.setOnClickListener {  datospublicacion()}

    }


    private fun datospublicacion() {

        val myIntent = Intent(
            this,
            Ingresar_reciclables_publicador::class.java
        ).apply {
            // Se lanza la activity.
            putExtra(Ingresar_reciclables_publicador2.MATERIAL, binding.spn1.selectedItem.toString())
            putExtra(Ingresar_reciclables_publicador2.CANTIDAD, binding.txtcantidad.text.toString())
            putExtra(Ingresar_reciclables_publicador2.UNIDAD, binding.spn2.selectedItem.toString())
        }
        startActivityForResult(myIntent, REQUESET_CODE2)
    }
/*
    private fun askConditions() {
        Log.d(TAG_APP, "askConditions()")
        // Se vuelve a ocultar el TV que mostrará el resultado.
        binding.tvResult.visibility = View.INVISIBLE // Se crea un objeto de tipo  Intent.
        val myIntent = Intent(
            this,
            SecondActivity::class.java
        ).apply { // Se añade la información a pasar por clave-valor.
            putExtra(EXTRA_NAME, binding.textToSend.text.toString())
        } // Se lanza la activity.
        startActivityForResult(myIntent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val resultado = data?.getFloatExtra(EXTRA_RESULT, 0.0F).toString()
                binding.tvResult.text =
                    "Accepted conditions.\n" + "Thank you for rating with $resultado stars."
                binding.tvResult.visibility = View.VISIBLE
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                binding.tvResult.text = " The contract was canceled! "
                binding.tvResult.visibility = View.VISIBLE
            }
        }
        if (resultCode == REQUESET_CODE2) {

            val resultado = data?.getFloatExtra(EXTRA_RESULT1, 0.0F).toString()

            binding.textToSend3.setText(resultado)

            binding.tvResult2.text = " El imc es: ! $resultado"
            binding.tvResult2.visibility = View.VISIBLE
        }


            val resultado = data?.getFloatExtra(EXTRA_RESULT, 0.0F).toString()

        binding.textToSend3.setText(resultado)

    }*/
}

