package com.oyy.foodcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Button
import android.widget.TextView
import java.util.ArrayList

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val flavorTextView: TextView = findViewById(R.id.flavorView)
        val sizeTextView: TextView = findViewById(R.id.sizeView)
        val addOnsTextView: TextView = findViewById(R.id.addView)
        val totalPriceTextView: TextView = findViewById(R.id.totalView)

        val flavor = intent.getStringExtra("FLAVOR")
        val size = intent.getStringExtra("SIZE")
        val add = intent.getStringArrayListExtra("ADDONS")

        flavorTextView.text = "Flavor: $flavor"
        sizeTextView.text = "Size: $size"
        addOnsTextView.text = "Add Ons: $add"

        // Calculate total price based on selected options
        val totalPrice = calculateTotalPrice(size, add)
        totalPriceTextView.text = "Total Price: $totalPrice"

        val backButton: Button = findViewById<Button>(R.id.backButton)

        backButton.setOnClickListener {
            finish()
        }

        val menuView = findViewById<ImageView>(R.id.menuView)

        when (flavor) {
            "Kopi Susu" -> menuView.setImageResource(R.drawable.kopi)
            "Pink Sakura" ->  menuView.setImageResource(R.drawable.poqisakura)
            "Uji Matcha" ->  menuView.setImageResource(R.drawable.ujii)
            "Dark Choco" ->  menuView.setImageResource(R.drawable.ujii)
            else -> {
                menuView.setImageResource(R.drawable.menu)
            }
        }
    }


    private fun calculateTotalPrice(size: String?, addOns: ArrayList<String>?): Double {
            // Base price for the item
            var totalPrice = 0.00

            // Calculate price based on selected size
            if (size != null) {
                when (size) {
                    "Small" -> totalPrice += 30.00
                    "Medium" -> totalPrice += 50.00
                    "Large" -> totalPrice += 70.00
                    // Handle other size options if needed
                }
            }

            // Calculate price based on selected add-ons
            addOns?.let {
                for (addOn in it) {
                    when (addOn) {
                        "Jelly" -> totalPrice += 15.00
                        "Oreo" -> totalPrice += 20.00
                        "Pearl" -> totalPrice += 20.00
                        "Cream" -> totalPrice += 15.00
                    }
                }
            }

            return totalPrice
    }

}