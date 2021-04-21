package Calc.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.String.format

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private var operand = 0.0
    private var secondOperand = 0.0
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)

    }

    @SuppressLint("SetTextI18n")
    fun numberClick(ClickedView: View) {
        if (ClickedView is Button) {
            val number = ClickedView.text.toString()
            var result = textView.text.toString()
            if (result == "0") {
                result = ""
            }
            textView.text = result + number
        }
    }

    fun operationClick(ClickedView: View) {
        if (ClickedView is Button) {
            var resultText = textView.text.toString()
            if (resultText.isEmpty()) return

            operand = resultText.toDouble()
            operation = ClickedView.text.toString()
            textView.text = ""


        }
    }

    @SuppressLint("DefaultLocale")
    fun equalClick(ClickedView: View) {
        val equal = textView.text.toString()
        if (equal.isEmpty()) return
        secondOperand = equal.toDouble()
        var a = textView.text.indexOf(".")
        when (operation) {
            "+" -> textView.text = (operand + secondOperand).toString()
            "-" -> textView.text = (operand - secondOperand).toString()
            "*" -> textView.text = (operand * secondOperand).toString()
            "/" -> textView.text = (operand / secondOperand).toString()
        }

        var saved = textView.text.toString()
        var check = 1
        for (i in 0..saved.length) {
            if (saved[i] == '.') {
                var b = saved.substring(i + 1)

                for (k in b) {
                    if (k != '0') {
                        check = 0
                        break
                    }
                }
                if (check == 1) {
                    textView.text = saved.substring(0, i)
                }
                break
            }
        }
    }

    fun delClick(ClickedView: View) {
        val delText = textView.text.toString()
        if (delText.isEmpty()) return
        textView.text = delText.dropLast(1)
    }

}