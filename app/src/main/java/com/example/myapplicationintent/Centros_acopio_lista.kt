package com.example.myapplicationintent


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.myapplicationintent.databinding.CentrosAcopioListaBinding
import com.example.myapplicationintent.databinding.IngresarReciclablesPublicadorBinding

class Centros_acopio_lista: AppCompatActivity() { // View Binding
    private lateinit var binding: CentrosAcopioListaBinding

    private var REQUESET_CODE2 = 123588





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CentrosAcopioListaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var list:MutableList<String> = arrayListOf()
        list.add("Centro 1 \n En Av. peru 2424")
        list.add("Centro 2 \n En Av. Jose Ganda 2020")
        list.add("Mercado 1 \n En Av. Universitaria 1010")
        list.add("Mercado 2 \n En Av. Perú 1515")

        val adapter = ArrayAdapter(this, R.layout.listview_item, list)
            binding.myListViewCentrosAcopio.adapter = adapter
            binding.myListViewCentrosAcopio.onItemClickListener = object : AdapterView.OnItemClickListener {
                override fun onItemClick(
                    parent: AdapterView<*>?,
                    view: View?, position:
                    Int, id: Long
                ) {
                    Toast.makeText(
                        applicationContext,
                        "Select ${binding.myListViewCentrosAcopio.getItemAtPosition(position)}",
                        Toast.LENGTH_LONG
                    ).show()
                    
                    centrositem()

                }
            }

    }

    private fun centrositem() {

        val myIntent = Intent(
            this, Centros_acopio_detalle::class.java
        ).apply {
        } // Se lanza la activity.
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

