package com.example.lab51.Principal


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.lab51.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A simple [Fragment] subclass.
 */
class Principal : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_principal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val floatingActionButton:FloatingActionButton=view!!.findViewById(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener{
            view!!.findNavController().navigate(R.id.action_principal_to_preguntas)
        }

        val button1:Button=view!!.findViewById(R.id.button)
        button1.setOnClickListener {
            view!!.findNavController().navigate(R.id.action_principal_to_encuesta)
        }
    }
}
