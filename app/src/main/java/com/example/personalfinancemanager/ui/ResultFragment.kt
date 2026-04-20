package com.example.personalfinancemanager.ui

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.personalfinancemanager.R
import com.example.personalfinancemanager.model.FinanceModel
import com.example.personalfinancemanager.manager.FinanceManager

class ResultFragment : Fragment(R.layout.fragment_result) {

    private val manager = FinanceManager()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val firstName = "Giorgi"
        val surname = "Arabuli"
        val birthYear = 2003
        val birthMonth = 11
        val savingsPercent = surname.length + birthMonth

        val resultText = view.findViewById<TextView>(R.id.ga_text_result)
        val identityText = view.findViewById<TextView>(R.id.ga_text_identity)

        parentFragmentManager.setFragmentResultListener("financeKey", this) { _, bundle ->

            val model = FinanceModel(
                salary = bundle.getDouble("salary"),
                rent = bundle.getDouble("rent"),
                food = bundle.getDouble("food")
            )

            val expenses = manager.calculateExpenses(model)
            val savings = manager.calculateSavingsAmount(model, savingsPercent)
            val remaining = manager.calculateRemaining(model, savingsPercent)

            resultText.text = """
                Salary: ${model.salary}
                Expenses: $expenses
                Savings ($savingsPercent%): $savings
                Remaining: $remaining
            """.trimIndent()

            // ვიზუალური ვალიდაცია
            if (manager.isValid(model)) {
                resultText.setTextColor(Color.GREEN)
            } else {
                resultText.setTextColor(Color.RED)
            }
        }

        identityText.text = "$firstName $surname - $birthYear"
    }
}