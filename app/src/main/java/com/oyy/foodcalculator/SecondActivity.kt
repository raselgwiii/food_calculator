package com.oyy.foodcalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    var selectedFlavor: String? = null
    var selectedSize: String? = null
    var selectedAddOns: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val kopiButton = findViewById<Button>(R.id.kopiButton)
        val poqiButton = findViewById<Button>(R.id.poqiButton)
        val ujiButton = findViewById<Button>(R.id.ujiButton)
        val darkButton = findViewById<Button>(R.id.darkButton)

        // Set click listeners for the buttons
        kopiButton.setOnClickListener { onFlavorSelected(it) }
        poqiButton.setOnClickListener { onFlavorSelected(it) }
        ujiButton.setOnClickListener { onFlavorSelected(it) }
        darkButton.setOnClickListener { onFlavorSelected(it) }

        val smallButton = findViewById<Button>(R.id.smallButton)
        val meduimButton = findViewById<Button>(R.id.mediumButton)
        val largeButton = findViewById<Button>(R.id.largeButton)

        // Set click listeners for size buttons
        smallButton.setOnClickListener { onSizeSelected(it) }
        meduimButton.setOnClickListener { onSizeSelected(it) }
        largeButton.setOnClickListener { onSizeSelected(it) }

        val jellyCheckBox = findViewById<CheckBox>(R.id.jellycheckBox)
        val pearlCheckBox = findViewById<CheckBox>(R.id.pearlcheckBox)
        val oreoCheckBox = findViewById<CheckBox>(R.id.oreocheckBox)
        val creamCheckBox = findViewById<CheckBox>(R.id.creamcheckBox)


        jellyCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                onAddOnsSelected(jellyCheckBox, "Jelly")
            }
        }

        pearlCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                onAddOnsSelected(pearlCheckBox, "Pearl")
            }
        }

        oreoCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                onAddOnsSelected(oreoCheckBox, "Oreo")
            }
        }

        creamCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                onAddOnsSelected(creamCheckBox, "Cream")
            }
        }

        val orderButton = findViewById<Button>(R.id.orderButton)
        orderButton.setOnClickListener {
            // Create an intent and set the extras here
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("FLAVOR", selectedFlavor)
            intent.putExtra("SIZE", selectedSize)
            intent.putStringArrayListExtra("ADDONS", ArrayList(selectedAddOns))

            // Start the next activity
            startActivity(intent)
        }
    }

    private fun onFlavorSelected(view: View) {
        // Get the text of the clicked button
        val flavor = (view as Button).text.toString()

        // Set the selected flavor to the variable
        selectedFlavor = flavor

        val kopiIndicator = findViewById<View>(R.id.kopiIndicator)
        val poqiIndicator = findViewById<View>(R.id.poqiIndicator)
        val ujiiIndicator = findViewById<View>(R.id.ujiiIndicator)
        val darkIndicator = findViewById<View>(R.id.darkIndicator)

        // Reset indicator visibility for all buttons
        kopiIndicator.visibility = View.GONE
        poqiIndicator.visibility = View.GONE
        ujiiIndicator.visibility = View.GONE
        darkIndicator.visibility = View.GONE

        // Set indicator visibility for the clicked button
        when (view.id) {
            R.id.kopiButton -> kopiIndicator.visibility = View.VISIBLE
            R.id.poqiButton -> poqiIndicator.visibility = View.VISIBLE
            R.id.ujiButton -> ujiiIndicator.visibility = View.VISIBLE
            R.id.darkButton -> darkIndicator.visibility = View.VISIBLE
        }
    }

    private fun onSizeSelected(view: View) {
        // Get the text of the clicked size button
        selectedSize = (view as Button).text.toString()

        val smallIndicator = findViewById<View>(R.id.smallIndicator)
        val meduimIndicator = findViewById<View>(R.id.meduimIndicator)
        val largeIndicator = findViewById<View>(R.id.largeIndicator)
        // Reset size indicators
        smallIndicator.visibility = View.GONE
        meduimIndicator.visibility = View.GONE
        largeIndicator.visibility = View.GONE

        // Set size indicator for the clicked button
        when (view.id) {
            R.id.smallButton -> smallIndicator.visibility = View.VISIBLE
            R.id.mediumButton -> meduimIndicator.visibility = View.VISIBLE
            R.id.largeButton -> largeIndicator.visibility = View.VISIBLE
        }
    }
    private fun onAddOnsSelected(checkBox: CheckBox, addOn: String) {
        if (checkBox.isChecked) {
            selectedAddOns.add(addOn)
        } else {
            selectedAddOns.remove(addOn)
        }

    }

}
