package com.basibuyuk.affirmationsapp

import android.graphics.Typeface
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    object random : Random()

    // message calculator
    var msgNumber = 15
    var countPeriod: Long = 5000
    var msgTotal: Long = countPeriod * msgNumber

    // message arrayList
    var message = arrayListOf<String>(
        "I am successful.",
        "I am confident.",
        "I am powerful.",
        "I am strong.",
        "I am getting better and better every day.",
        "All I need is within me right now.",
        "I wake up motivated.",
        "I am an unstoppable force of nature.",
        "I am a living, breathing example of motivation.",
        "I am living with abundance.",
        "I am having a positive and inspiring impact on the people I come into contact with.",
        "I am inspiring people through my work.",
        "I’m rising above the thoughts that are trying to make me angry or afraid.",
        "Today is a phenomenal day.",
        "I am turning DOWN the volume of negativity in my life, while simultaneously turning UP the volume of positivity."

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




    }


    fun start(view: View) {
        object : CountDownTimer(msgTotal, countPeriod) {
            override fun onTick(p0: Long) {
                textView.text = message.get(random.nextInt(15))
            }


            override fun onFinish() {

                val alertDialog = AlertDialog.Builder(this@MainActivity)
                alertDialog.setTitle("Restart")
                alertDialog.setMessage("Restart affrimations?")
                alertDialog.setPositiveButton("Yes") { dialog, which ->

                    val intent = intent
                    finish()
                    startActivity(intent)
                }
                alertDialog.setNegativeButton("No") { dialog, which ->
                    textView.text = "SEE YOU LATER"

                }
                alertDialog.show()


            }
        }.start()
    }


}


