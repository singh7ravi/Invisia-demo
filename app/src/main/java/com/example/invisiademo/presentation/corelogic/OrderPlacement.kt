package com.example.myapplication.presentation.corelogic

fun main() {

    val customerName01 = "default"
    val customerName02 = "Microsoft"
    val customerName03 = "Amazon"
    val customerName04 = "Facebook"

    val pizzaCategory = PizzaCategory()
             /*
               Note Pizza price and offer amount
               can be change from Constant.kt file
               */
    val smallList = pizzaCategory.getProducts(PizzaType.SMALL_PIZZA, 1)
    val mediumList = pizzaCategory.getProducts(PizzaType.MEDIUM_PIZZA, 2)
    val largeList = pizzaCategory.getProducts(PizzaType.LARGE_PIZZA, 2)

    val totalAmount = pizzaCategory.calculateTotalAmount(customerName03,smallList + mediumList + largeList)
    println("Case  # $customerName01 Total: $$totalAmount")



}
