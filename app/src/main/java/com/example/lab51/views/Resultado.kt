package com.example.lab51.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.lab51.R
import com.example.lab51.databinding.ResultadoFragmentBinding
import com.example.lab51.viewmodels.ResultadoViewModel

/**
 * @author Bryann Alfaro
 * Fragment that initialize the result view
 */

class Resultado : Fragment() {

    companion object {
        fun newInstance() = Resultado()
    }

    private lateinit var viewModel: ResultadoViewModel
    private lateinit var bindinResultado:ResultadoFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate the view
        bindinResultado=DataBindingUtil.inflate<ResultadoFragmentBinding>(inflater,R.layout.resultado_fragment,container,false)

        viewModel=ViewModelProviders.of(activity!!).get(ResultadoViewModel::class.java)
        var rate=viewModel.promedioRating.toString()
        var survey=viewModel.cantidadSurveys.toString()

        bindinResultado.Rating.setText("Promedio calificacioness: $rate")
        bindinResultado.Cantidad.setText("Cantidad de encuestas: $survey")

        //navigate to the new encuesta
        bindinResultado.button3.setOnClickListener {
            view!!.findNavController().navigate(R.id.action_resultado_to_principal)
        }
        //shows the toast
        bindinResultado.button4.setOnClickListener {
            Toast.makeText(activity,"Resultados: ${viewModel.returnAll()}",Toast.LENGTH_SHORT).show()
        }
        return bindinResultado.root
    }





}
