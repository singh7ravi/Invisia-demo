package com.example.myapplication.common

import com.example.invisiademo.R


object Constant {

    const val SMALL_PIZZA = "Small Pizza"
    const val MEDIUM_PIZZA = "Medium Pizza"
    const val LARGE_PIZZA = "Large Pizza"
    const val PIZZA_10_INCH = "10'' pizza for one person"
    const val PIZZA_12_INCH = "12'' pizza for two person"
    const val PIZZA_15_INCH = "15'' pizza for four person"

    const val smallSizePrice = 11.99
    const val mediumSizePrice = 15.99
    const val largeSizePrice = 21.99
    const val discountLPrice = 19.99

    const val KEY_TITLE = "title"
    const val KEY_SHORT_DESC = "shortDescription"
    const val KEY_PRICE = "price"
    const val KEY_IMG_RES = "imgResource"

    const val validationMessage = "Sorry! Qantity should not be empty."

    val pizzaIconsList = listOf<Int>(R.drawable.pizza01, R.drawable.pizza02, R.drawable.pizza03, R.drawable.pizza04, R.drawable.pizza05, R.drawable.pizza06, R.drawable.pizza07, R.drawable.pizza08, R.drawable.pizza09, R.drawable.pizza010, R.drawable.pizza11)
    val pizzaBgList = listOf<Int>(R.drawable.bg01, R.drawable.bg02, R.drawable.bg03, R.drawable.bg04, R.drawable.bg05, R.drawable.bg06, R.drawable.bg07, R.drawable.bg08, R.drawable.bg09, R.drawable.bg10, R.drawable.bg11)
    val pizzaTitleList = listOf<String>(
        "Power Play Deal : 2 Personal Pizzas starting at Rs 299",
        "Match Time Combo starting at Rs.799 (Save Upto 39%)",
        "Super Value Deal : 2 Medium Pizzas starting at Rs 649",
        "Flavour Fun Box of 4",
        "1 Plus 1 San Francisco Style",
        "Hut Treat Box 4 San Francisco Style",
        "Meal for 2 with Pizza & Classic Bread Stix",
        "Stuffed Crust - Meal for 2",
        "MY BOX PASTA starting @229",
        "Double Treat (2 Pizzas) with Cornetto Double Chocolate",
        "Meal for 1: 1 Pasta, 2 Pc Plain Garlic Bread & 1 Pepsi Pet Bottle",
    )
    val pizzaShortDescList = listOf<String>(
        "Choose any 2 of your favorite personal pizza",
        "2 Med Pizza of Choice, 1 Classic Breadstix, 1 Creamy Breadstix, 2 Pepsi Pet Bottles",
        "Pickup & home delivery 24X7 available",
        "Choose any 2 of your favorite medium pizza",
        "Get 4 assorted Flavor Fun Pizzas. Perfect pizza crust topped with exciting new sauces, cheesy dressing & your favorite toppings",
        "Choose from 2 of your favorite personal pizza with new San Fransisco Crust",
        "2 Med Pizza with new San Fransisco Crust, 1 Classic Breadstix, 1 Creamy Breadstix, 2 Pepsi Pet Bottles",
        "2 Personal Pizza Upto Veg Signature, 1 Classic Bread Stix",
        "Delicious Meal for 2 with great choice of pizzas and signature crusts with Pepsi",
        "1 Classic Bread Stix & 2 Cornetto Double Chocolate (105 ml)",
        "Your basket looks a little empty. "
    )


}