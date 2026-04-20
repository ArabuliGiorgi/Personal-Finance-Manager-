package com.example.personalfinancemanager.manager

import com.example.personalfinancemanager.model.FinanceModel

class FinanceManager {

    fun calculateExpenses(model: FinanceModel): Double {
        return model.rent + model.food
    }

    fun calculateSavingsAmount(model: FinanceModel, savingsPercent: Int): Double {
        return model.salary * savingsPercent / 100
    }

    fun calculateRemaining(model: FinanceModel, savingsPercent: Int): Double {
        val expenses = calculateExpenses(model)
        val savings = calculateSavingsAmount(model, savingsPercent)
        return model.salary - expenses - savings
    }

    fun isValid(model: FinanceModel): Boolean {
        return model.salary >= calculateExpenses(model)
    }
}