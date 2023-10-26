package com.example.myapplication.presentation.corelogic

data class Customer(val name: String, val specialPricing: (List<Pizza>) -> Double)
