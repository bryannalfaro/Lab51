package com.example.lab51.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.lab51.R
import com.example.lab51.databinding.EncuestaFragmentBinding
import com.example.lab51.viewmodels.EncuestaViewModel
import com.example.lab51.viewmodels.ResultadoViewModel

/**
 * @author Bryann Alfaro
 * Fragment that displays the questions
 */

@Suppress("DEPRECATION")
class Encuesta : Fragment() {
    private lateinit var viewModel: EncuestaViewModel
    private lateinit var viewModelR:ResultadoViewModel
    private lateinit var bindingEncuesta: EncuestaFragmentBinding
    private var ratingShow:Int=0



    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the view
        bindingEncuesta = DataBindingUtil.inflate(inflater, R.layout.encuesta_fragment, container, false)

        //init the viewModel
        viewModel = ViewModelProviders.of(activity!!).get(EncuestaViewModel::class.java)
        viewModelR=ViewModelProviders.of(activity!!).get(ResultadoViewModel::class.java)
        bindingEncuesta.encuestaModel=viewModel


        bindingEncuesta.lifecycleOwner=viewLifecycleOwner

        //Init the info in the view
        viewModel.makePregunta()
        viewModel.selectPregunta()

        //next question
        bindingEncuesta.button2.setOnClickListener {

            if(ratingShow>=1){
                //set the rating
                viewModelR.endSurvey()//increment the value for the survey
                viewModelR.rating(bindingEncuesta.ratingBar.rating)//get the rating for the ratinbar
                viewModelR.establecerRespuesta(bindingEncuesta.ratingBar.rating.toString())//add to the list of answers

                //navigate to results
                view!!.findNavController().navigate(R.id.action_encuesta_to_resultado)
            }else if(viewModel.preguntasList.size<=1){
                ratingShow=1
                bindingEncuesta.ratingBar.visibility=View.VISIBLE
                bindingEncuesta.editText2.visibility=View.GONE
            }
            viewModelR.establecerRespuesta(bindingEncuesta.editText2.text.toString())
            viewModel.selectPregunta()
            bindingEncuesta.editText2.setText("")
        }
        return bindingEncuesta.root
    }
}
