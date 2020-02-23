package com.example.lab51.views

import android.os.Bundle
import android.view.*
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil

import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.lab51.R
import com.example.lab51.databinding.PreguntasFragmentBinding

/**
 * @author Bryann Alfaro
 * Fragment that displays the view for the question
 */
@Suppress("DEPRECATION")
class Preguntas : Fragment() {



    var texto:String=""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the view
        val bindingPreguntas=DataBindingUtil.inflate<PreguntasFragmentBinding>(inflater,R.layout.preguntas_fragment,container,false)

        setHasOptionsMenu(true)

        return bindingPreguntas.root
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.save_menu,menu)
    }
    //when the button save is pressed
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val edit:EditText = view!!.findViewById(R.id.editText)
        texto=edit.text.toString()

        edit.setText("")
        var bundle= bundleOf("question" to texto)
        view!!.findNavController().navigate(R.id.action_preguntas_to_principal,bundle)
        return super.onOptionsItemSelected(item)
    }
}
