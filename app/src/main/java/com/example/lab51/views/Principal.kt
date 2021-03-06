package com.example.lab51.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.lab51.R
import com.example.lab51.databinding.FragmentPrincipalBinding

/**
 * @author Bryann
 * Fragment that displays the main view
 */
class Principal : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val bindingFirst= DataBindingUtil.inflate<FragmentPrincipalBinding>(inflater,R.layout.fragment_principal,container,false)

        //navigate to preguntas
        bindingFirst.floatingActionButton.setOnClickListener{
            view!!.findNavController().navigate(R.id.action_principal_to_preguntas)
        }

        //navigate to encuestas with bundle of the question
        bindingFirst.button.setOnClickListener {
            val string: String? = arguments?.getString("question")
            var bundle1= bundleOf("question" to string)
            view!!.findNavController().navigate(R.id.action_principal_to_encuesta,bundle1)
        }
        return bindingFirst.root
    }


}
