package com.example.myapplication

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val card1 = findViewById<CardView>(R.id.card1)
        val card2 = findViewById<CardView>(R.id.card2)
        val card3 = findViewById<CardView>(R.id.card3)
        val card4 = findViewById<CardView>(R.id.card4)
        val card5 = findViewById<CardView>(R.id.card5)
        val card6 = findViewById<CardView>(R.id.card6)
        val card7 = findViewById<CardView>(R.id.card7)
        val card8 = findViewById<CardView>(R.id.card8)
        val card9 = findViewById<CardView>(R.id.card9)
        val card10 = findViewById<CardView>(R.id.card10)
        val card11 = findViewById<CardView>(R.id.card11)
        val card12 = findViewById<CardView>(R.id.card12)
        val checkout = findViewById<Button>(R.id.button)
        val image1 = findViewById<ImageView>(R.id.imageView1)
        val image2 = findViewById<ImageView>(R.id.imageView2)
        val image3 = findViewById<ImageView>(R.id.imageView3)
        val image4 = findViewById<ImageView>(R.id.imageView4)
        val image5 = findViewById<ImageView>(R.id.imageView5)
        val image6 = findViewById<ImageView>(R.id.imageView6)
        val image7 = findViewById<ImageView>(R.id.imageView7)
        val image8 = findViewById<ImageView>(R.id.imageView8)
        val image9 = findViewById<ImageView>(R.id.imageView9)
        val image10 = findViewById<ImageView>(R.id.imageView10)
        val image11 = findViewById<ImageView>(R.id.imageView11)
        val image12 = findViewById<ImageView>(R.id.imageView12)

        card1.setOnClickListener { changeAlpha(it) }
        card2.setOnClickListener { changeAlpha(it) }
        card3.setOnClickListener { changeAlpha(it) }
        card4.setOnClickListener { changeAlpha(it) }
        card5.setOnClickListener { changeAlpha(it) }
        card6.setOnClickListener { changeAlpha(it) }
        card7.setOnClickListener { changeAlpha(it) }
        card8.setOnClickListener { changeAlpha(it) }
        card9.setOnClickListener { changeAlpha(it) }
        card10.setOnClickListener { changeAlpha(it) }
        card11.setOnClickListener { changeAlpha(it) }
        card12.setOnClickListener { changeAlpha(it) }
        checkout.setOnClickListener { checkoutclick(it) }
        image1.setOnClickListener { popuppage(it,0) }
        image2.setOnClickListener { popuppage(it,1) }
        image3.setOnClickListener { popuppage(it,2) }
        image4.setOnClickListener { popuppage(it,3) }
        image5.setOnClickListener { popuppage(it,4) }
        image6.setOnClickListener { popuppage(it,5) }
        image7.setOnClickListener { popuppage(it,6) }
        image8.setOnClickListener { popuppage(it,7) }
        image9.setOnClickListener { popuppage(it,8) }
        image10.setOnClickListener { popuppage(it,9) }
        image11.setOnClickListener { popuppage(it,10) }
        image12.setOnClickListener { popuppage(it,11) }
    }

    private fun changeAlpha(view: View) {
        if (view.alpha == 1.0f) {
            view.alpha = 0.4f
        } else {
            view.alpha = 1.0f
        }
    }

    private fun popuppage(view: View, position: Int) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.popuppage)

        val nameTextView = dialog.findViewById<TextView>(R.id.textView)
        val detailsTextView = dialog.findViewById<TextView>(R.id.textView2)
        val image = dialog.findViewById<ImageView>(R.id.imageView)

        // Set the details based on the position clicked
        nameTextView.text = MyData.nameArr[position]
        detailsTextView.text = MyData.detailsArr[position]
        image.setImageResource(MyData.drawableArr[position])
        dialog.show()
    }



    private fun checkoutclick(view: View) {
        var total = 0.0
        val buttontext = findViewById<Button>(R.id.button)
        if (view.alpha != 1.0f) {
            for (i in 1..12) {
                val cardId = resources.getIdentifier("card$i", "id", packageName)
                val card = findViewById<CardView>(cardId)
                if (card.alpha != 1.0f) {
                    card.alpha = 0.0f
                    card.isClickable = false
                    val imageId = resources.getIdentifier("imageView${i}", "id", packageName)
                    val imageView = findViewById<ImageView>(imageId)
                    imageView.isClickable = false
                }
                if (card.alpha == 1.0f) {
                    if (i == 1) {
                        total += 10.99
                    }
                    if (i == 2) {
                        total += 16.99
                    }
                    if (i == 3) {
                        total += 12.99
                    }
                    if (i == 4) {
                        total += 11.99
                    }
                    if (i == 5) {
                        total += 14.99
                    }
                    if (i == 6) {
                        total += 14.99
                    }
                    if (i == 7) {
                        total += 14.99
                    }
                    if (i == 8) {
                        total += 18.99
                    }
                    if (i == 9) {
                        total += 15.99
                    }
                    if (i == 10) {
                        total += 17.99
                    }
                    if (i == 11) {
                        total += 19.99
                    }
                    if (i == 12) {
                        total += 25.99
                    }
                }
            }
            view.alpha = 1.0f
            buttontext.setText("Total Price: $total $")
        }
        else {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.totalpricepage)
            val totalpay = dialog.findViewById<TextView>(R.id.paytext)
            val paybtn = dialog.findViewById<Button>(R.id.button2)
            totalpay.text = buttontext.text
            paybtn.setOnClickListener {
                Toast.makeText(this, "Thank You, Payment successful!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            dialog.show()
            for (i in 1..12) {
                val cardId = resources.getIdentifier("card$i", "id", packageName)
                val card = findViewById<CardView>(cardId)
                    card.alpha = 0.4f
                    card.isClickable = true
                    val imageId = resources.getIdentifier("imageView${i}", "id", packageName)
                    val imageView = findViewById<ImageView>(imageId)
                    imageView.isClickable = true
            }
            view.alpha = 0.4f
            total = 0.0
            buttontext.setText("CHECKOUT")
        }
    }
}

