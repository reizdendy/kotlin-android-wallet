package com.example.exercise_two.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.exercise_two.R
import kotlinx.android.synthetic.main.fragment_confirmation.*
import kotlinx.android.synthetic.main.fragment_input_amount.*

/**
 * A simple [Fragment] subclass.
 * Use the [ConfirmationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConfirmationFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        done_button.setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recipient_name_confirmation.text = "${arguments?.getString("recipientName")}"
        amount_confirmation.text = "AMOUNT : Rp.  ${arguments?.getString("amount")}"
    }

    override fun onClick(v: View?) {
        when(v){
            done_button -> {navController.navigate(R.id.action_confirmationFragment_to_homeFragment2)}
        }
    }
}