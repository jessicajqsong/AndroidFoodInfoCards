package com.jessicasjq.foodinfocardstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_details.*

class FoodDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)

        var bundle = intent.extras
        imageView2.setImageResource(bundle!!.getInt("image"))
        textView2.text = bundle!!.getString("name")
        textView3.text = bundle!!.getString("description")
    }
}