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
import com.example.myapplicationintent.databinding.IngresarReciclablesPublicadorBinding
import com.example.myapplicationintent.databinding.ReciclablesRecicladorBinding

class Reciclables_reciclador: AppCompatActivity() { // View Binding
    private lateinit var binding:ReciclablesRecicladorBinding

    private var REQUESET_CODE2 = 123588
    private var REQUEST_CODE = 1234

    companion object {
        const val TAG_APP = "myExplicitIntent2"
        const val EXTRA_NAME = "userNAME"
        const val EXTRA_RESULT = "ratingSCORE"
        const val EXTRA_RESULT1 = "ratingSCORE"
    }
    val list: MutableList<String> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ReciclablesRecicladorBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Se recuperan los datos y se assigning al TextView.
        val material = intent.getStringExtra(Ingresar_reciclables_publicador2.MATERIAL)

        val materialString = getString(R.string.msgAccept, material)
        val cantidad = intent.getStringExtra(Ingresar_reciclables_publicador2.CANTIDAD)
        val cantidadString = getString(R.string.msgAccept, cantidad)
        val unidad = intent.getStringExtra(Ingresar_reciclables_publicador2.UNIDAD)
        val unidadString = getString(R.string.msgAccept, unidad)
        val mensaje = materialString + "\n" + cantidadString + " " + unidadString




        if(materialString!="null")
            if(materialString!="Ingrese el nombre del material")
        list.add(mensaje)
        else
            list.add("Botellas plástico \n 1 Kg")
        list.add("Botellas plástico \n 1 Kg")




            val adapter = ArrayAdapter(this, R.layout.listview_item, list)
            binding.myListView1.adapter = adapter
            binding.myListView1.onItemClickListener = object : AdapterView.OnItemClickListener {
                override fun onItemClick(
                    parent: AdapterView<*>?,
                    view: View?, position:
                    Int, id: Long
                ) {
                    Toast.makeText(
                        applicationContext,
                        "Select ${binding.myListView1.getItemAtPosition(position)}",
                        Toast.LENGTH_LONG
                    ).show()

                    agregarpublicacion2()
                }
            }

    }

    private fun agregarpublicacion2() {

        val myIntent = Intent(
            this,
            Ingresar_reciclables::class.java
        ).apply {
        } // Se lanza la activity.
        startActivityForResult(myIntent, REQUESET_CODE2)
    }




    private fun agregarpublicacion() {

        val myIntent = Intent(
            this,
            Ingresar_reciclables_publicador3::class.java
        ).apply {

            putExtra("string",list.toString())
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

