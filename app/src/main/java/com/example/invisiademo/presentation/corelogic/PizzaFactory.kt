package com.example.myapplication.presentation.corelogic

import com.example.myapplication.common.Constant.LARGE_PIZZA
import com.example.myapplication.common.Constant.MEDIUM_PIZZA
import com.example.myapplication.common.Constant.PIZZA_10_INCH
import com.example.myapplication.common.Constant.PIZZA_12_INCH
import com.example.myapplication.common.Constant.PIZZA_15_INCH
import com.example.myapplication.common.Constant.SMALL_PIZZA
import com.example.myapplication.common.Constant.discountLPrice
import com.example.myapplication.common.Constant.largeSizePrice
import com.example.myapplication.common.Constant.mediumSizePrice
import com.example.myapplication.common.Constant.smallSizePrice


val smallPizza = Pizza(SMALL_PIZZA, PIZZA_10_INCH, smallSizePrice)
val mediumPizza = Pizza(MEDIUM_PIZZA, PIZZA_12_INCH, mediumSizePrice)
val largePizza = Pizza(LARGE_PIZZA, PIZZA_15_INCH, largeSizePrice)


class PizzaCategory constructor() {

    private val customers = listOf(
        Customer("default") { items ->
            items.sumByDouble { it.retailPrice }
        },
        Customer("Microsoft") { items ->
            val smallPizzaCount = items.count { it == smallPizza }
            // Logic for Small pizza while ordered by customer: Microsoft
            val remainingSmallPizzas = smallPizzaCount % 3
            val smallPizzaPrice = (smallPizzaCount / 3) * 2 * smallPizza.retailPrice +
                    remainingSmallPizzas * smallPizza.retailPrice

            val largePizzaPrice = items.count { it == largePizza } * largePizza.retailPrice
            val mediumPizzaPrice = items.count { it == mediumPizza } * mediumPizza.retailPrice
            smallPizzaPrice + mediumPizzaPrice + largePizzaPrice
        },
        Customer("Amazon") { items ->
            val mediumPizzaPrice = items.count { it == mediumPizza } * mediumPizza.retailPrice
            val largePizzaCount = items.count { it == largePizza }
            val smallPizzaPrice = items.count { it == smallPizza } * smallPizza.retailPrice

            // Logic for Large pizza while ordered by customer: Amazon
            val largePizzaPrice = largePizzaCount * discountLPrice

            smallPizzaPrice + mediumPizzaPrice + largePizzaPrice
        },
        Customer("Facebook") { items ->

            val smallPizzaPrice = items.count { it == smallPizza } * smallPizza.retailPrice
            val mediumPizzaCount = items.count { it == mediumPizza }

            // Logic for Medium pizza while ordered by customer: Facebook
            val mediumPizzaPrice = (mediumPizzaCount / 5) * 4 * mediumPizza.retailPrice +
                    (mediumPizzaCount % 5) * mediumPizza.retailPrice // Logic

            val largePizzaPrice = items.count { it == largePizza } * largePizza.retailPrice

            smallPizzaPrice + mediumPizzaPrice + largePizzaPrice
        }
    )

    fun getProducts(type: PizzaType, quantity: Int): List<Pizza> {
        val list = mutableListOf<Pizza>()
        var retailsPrice: Double = 0.0;
        var pizzaType: String
        var pizzaDesc: String
         when (type) {
            PizzaType.SMALL_PIZZA -> {
                pizzaType = SMALL_PIZZA
                pizzaDesc = PIZZA_10_INCH
                retailsPrice =  11.99
            }

            PizzaType.MEDIUM_PIZZA -> {
                pizzaType = MEDIUM_PIZZA
                pizzaDesc = PIZZA_12_INCH
                retailsPrice = 15.99
            }

            PizzaType.LARGE_PIZZA  -> {
                pizzaType = LARGE_PIZZA
                pizzaDesc = PIZZA_15_INCH
                retailsPrice = 21.99
            }
        }
        for (i in 1..quantity) {
            list.add(Pizza(pizzaType, pizzaDesc, retailsPrice))
        }
        return list
    }

    fun calculateTotalAmount(customerName: String, items: List<Pizza>): Double {
        val customer =
            customers.find { it.name == customerName } ?: customers.first { it.name == "default" }
        return customer.specialPricing(items)
    }

}