package com.example.lab51.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.lab51.R
import com.example.lab51.databinding.EncuestaFragmentBinding
import com.example.lab51.viewmodels.EncuestaViewModel

/**
 * @author Bryann Alfaro
 * Fragment that displays the questions
 */

@Suppress("DEPRECATION")
class Encuesta : Fragment() {
    private lateinit var viewModel: EncuestaViewModel
    private lateinit var bindingEncuesta: EncuestaFragmentBinding


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the view
        bindingEncuesta = DataBindingUtil.inflate(inflater, R.layout.encuesta_fragment, container, false)
        //init the viewModel
        viewModel = ViewModelProviders.of(this).get(EncuestaViewModel::class.java)
        val string: String? = arguments?.getString("question")
        if (string==null){

        }else{
            viewModel.addPregunta(string.toString())
        }
        //Live data for the questions
        viewModel.preguntas.observe(this, Observer { nextQuestion ->
            bindingEncuesta.preguntas.text = nextQuestion.toString()
            if (nextQuestion.toString() == "Calificanos") {
                bindingEncuesta.editText2.visibility = View.GONE
                bindingEncuesta.ratingBar.visibility = View.VISIBLE
            } else if (nextQuestion.toString() == "") {
                view!!.findNavController().navigate(R.id.action_encuesta_to_resultado)
            }else{
                bindingEncuesta.editText2.visibility = View.VISIBLE
                bindingEncuesta.ratingBar.visibility = View.GONE
            }
        })
        //next question
        bindingEncuesta.button2.setOnClickListener {

            viewModel.selectPregunta()
        }
        return bindingEncuesta.root
    }
}
