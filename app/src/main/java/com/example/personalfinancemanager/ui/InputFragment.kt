package com.example.personalfinancemanager.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.personalfinancemanager.R

class InputFragment : Fragment(R.layout.fragment_input) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val salaryEdit = view.findViewById<EditText>(R.id.ga_edit_salary)
        val rentEdit = view.findViewById<EditText>(R.id.ga_edit_rent)
        val foodEdit = view.findViewById<EditText>(R.id.ga_edit_food)
        val button = view.findViewById<Button>(R.id.ga_btn_calculate)

        button.setOnClickListener {

            val salary = salaryEdit.text.toString().toDoubleOrNull() ?: 0.0
            val rent = rentEdit.text.toString().toDoubleOrNull() ?: 0.0
            val food = foodEdit.text.toString().toDoubleOrNull() ?: 0.0

            val bundle = Bundle().apply {
                putDouble("salary", salary)
                putDouble("rent", rent)
                putDouble("food", food)
            }

            parentFragmentManager.setFragmentResult("financeKey", bundle)

            parentFragmentManager.beginTransaction()
                .replace(R.id.ga_fragment_container, ResultFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}