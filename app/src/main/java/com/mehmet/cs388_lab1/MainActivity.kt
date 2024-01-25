package com.mehmet.cs388_lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<ImageView>(R.id.button_pickaxe)
        val textView = findViewById<TextView>(R.id.tapCounter)
        val upgradeButton = findViewById<Button>(R.id.upgrade_button)

        button.setOnClickListener {
            counter++
            textView.text = counter.toString()

            if (counter in 20..59) {
                upgradeButton.visibility = View.VISIBLE
                upgradeButton.setOnClickListener {
                    button.setImageResource(R.drawable.pickaxe_stone)
                    Toast.makeText(it.context, R.string.toast_upgrade_stone, Toast.LENGTH_SHORT)
                        .show()


                    button.setOnClickListener {
                        counter += 2
                        textView.text = counter.toString()

                        if (counter in 60..159) {
                            upgradeButton.visibility = View.VISIBLE
                            upgradeButton.setOnClickListener {
                                button.setImageResource(R.drawable.pickaxe_gold)
                                Toast.makeText(
                                    it.context, R.string.toast_upgrade_gold, Toast.LENGTH_SHORT
                                ).show()

                                button.setOnClickListener {
                                    counter += 5
                                    textView.text = counter.toString()

                                    if (counter >= 160) {
                                        upgradeButton.visibility = View.VISIBLE
                                        upgradeButton.setOnClickListener {
                                            button.setImageResource(R.drawable.pickaxe_diamond)
                                            Toast.makeText(
                                                it.context,
                                                R.string.toast_upgrade_diamond,
                                                Toast.LENGTH_SHORT
                                            ).show()

                                            button.setOnClickListener {
                                                counter += 10
                                                textView.text = counter.toString()
                                            }

                                            upgradeButton.visibility = View.INVISIBLE
                                        }
                                    }
                                }
                                upgradeButton.visibility = View.INVISIBLE
                            }
                        }
                    }
                    upgradeButton.visibility = View.INVISIBLE
                }
            }

        }
    }
}