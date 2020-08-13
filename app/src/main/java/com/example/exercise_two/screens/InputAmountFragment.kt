package com.example.exercise_two.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.exercise_two.R
import kotlinx.android.synthetic.main.fragment_confirmation.*
import kotlinx.android.synthetic.main.fragment_input_amount.*
import kotlinx.android.synthetic.main.fragment_input_recipient.*


/**
 * A simple [Fragment] subclass.
 * Use the [InputAmountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputAmountFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        send_button.setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recipient_name_view.text = "TO : ${arguments?.getString("recipientName")}"
    }

    override fun onClick(v: View?) {
        when(v){
            send_button -> {
                val bundle = bundleOf(
                    "recipientName" to recipient_name_view.text.toString(),
                    "amount" to amount_text.text.toString()
                )
                navController.navigate(R.id.action_inputAmountFragment_to_confirmationFragment, bundle)
            }
        }
    }
}