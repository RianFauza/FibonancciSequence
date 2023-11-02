package com.example.fibonanccisequence

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var count = 0
    var countFibo = 0
    lateinit var showCount: TextView
    lateinit var showCountFibo: TextView
    lateinit var buttonToast: Button
    lateinit var buttonCount: Button
    lateinit var buttonReset: Button
    var toastA: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonToast = findViewById(R.id.button_toast)
        buttonCount = findViewById(R.id.buttonCount)
        buttonReset = findViewById(R.id.buttonReset)
        showCount = findViewById(R.id.textCount)
        showCountFibo = findViewById(R.id.textCountFibo)

        buttonToast.setOnClickListener(View.OnClickListener {
            if (toastA != null) {
                toastA!!.cancel()
            }
            toastA = Toast.makeText(applicationContext, "Angka Fibonancci",
                Toast.LENGTH_SHORT)
            toastA!!.show()
        })

        buttonCount.setOnClickListener(View.OnClickListener { view -> calculate(view) })
        buttonReset.setOnClickListener(View.OnClickListener { view -> reset(view) })
    }

    protected fun calculate(view: View) {
        count++
        countFibo = calculateFibo(count)
        showCount.text = "Tombol Hitung Diklik Sebanyak : " + count.toString()
        showCountFibo.text = countFibo.toString()
        if (count % 5 == 0) {
            if (toastA != null) toastA!!.cancel()
            toastA = Toast.makeText(applicationContext, "Tombol Hitung Diklik Sebanyak",
                Toast.LENGTH_LONG)
            toastA!!.show()
        }
    }

    protected fun calculateFibo(n: Int): Int {
        if (n <= 1) return n
        var prev: Int
        var current: Int
        var next: Int
        prev = 0
        current = 1
        for (i in 2..n) {
            next = prev + current
            prev = current
            current = next
        }
        return current
    }

    protected fun reset(view: View) {
        count = 0
        countFibo = 0
        showCount.text = "Tombol Hitung Diklik Sebanyak : " + count.toString()
        showCountFibo.text = count.toString()
    }
}