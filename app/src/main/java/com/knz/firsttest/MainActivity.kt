package com.knz.firsttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    var operator: String = ""
    var oldNumber: String = ""
    var newFlag: Boolean = true
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.editText)

        oldNumber = editText.text.toString()
    }

    fun String.dotIsPresent(): Boolean {
        return this.contains(".")
    }

    fun clickNumber(view: View) {
        if (newFlag) {
            editText.setText("")
        }
        newFlag = false
        var number = editText.text.toString()
        when (view.id) {
            R.id.b5 -> {
                if (zeroCount(number) && number.length == 1) {
                    number = number.substring(1)
                }
                number += "1"
            }

            R.id.b6 -> {
                if (zeroCount(number) && number.length == 1) {
                    number = number.substring(1)
                }
                number += "2"
            }

            R.id.b7 -> {
                if (zeroCount(number) && number.length == 1) {
                    number = number.substring(1)
                }
                number += "3"
            }


            R.id.b9 -> {
                if (zeroCount(number) && number.length == 1) {
                    number = number.substring(1)
                }
                number += "4"
            }

            R.id.b10 -> {
                if (zeroCount(number) && number.length == 1) {
                    number = number.substring(1)
                }
                number += "5"
            }

            R.id.b11 -> {
                if (zeroCount(number) && number.length == 1) {
                    number = number.substring(1)
                }
                number += "6"
            }

            R.id.b13 -> {
                if (zeroCount(number) && number.length == 1) {
                    number = number.substring(1)
                }
                number += "7"
            }

            R.id.b14 -> {

                if (zeroCount(number) && number.length == 1) {
                    number = number.substring(1)
                }
                number += "8"
            }

            R.id.b15 -> {
                if (zeroCount(number) && number.length == 1) {
                    number = number.substring(1)
                }
                number += "9"
            }

            R.id.b17 -> {
                if (zero2Count(number)) {
                    number = "0"
                } else {
                    number += "00"
                }
            }

            R.id.b18 -> {
                if (zeroCount(number) && number.length == 1) {
                    number = "0"
                } else {
                    number += "0"
                }
            }

            R.id.b19 -> {
                if (number.dotIsPresent()) {
                }else
                if(zeroCount(number)){
                    number="0."
                }
                else {
                    number += "."
                }
            }

            R.id.b3 -> {
                if (numberisZero(number)) {
                    number = "0"

                } else {
                    if (minusIsPresent(number)) {
                        number = number.substring(1)
                    } else {
                        number = "-$number"
                    }
                }
            }
        }
        editText.setText(number)
    }

    fun zero2Count(number: String): Boolean {
        if (number.equals("")) {
            return true
        }
        if (number[0] == '0') {
            return true
        } else {
            return false
        }
    }


    fun zeroCount(number: String): Boolean {
        if (number.equals("")) {
            return true
        }
        if (number[0] == '0') {
            return true
        } else {
            return false
        }
    }

    fun numberisZero(number: String): Boolean {
        if (number.equals("0") || number.equals("")) {
            return true;
        } else {
            return false
        }
    }

    fun minusIsPresent(number: String): Boolean {
        if (number.get(0) == '-') {
            return true
        } else
            return false
    }


    fun operation(view: View) {
        newFlag = true
        oldNumber = editText.text.toString()
        newFlag = true
        when (view.id) {
            R.id.b4 -> {
                operator = "/";editText.setText("")
            }

            R.id.b8 -> {

                operator = "*";editText.setText("")
            }

            R.id.b12 -> {
                operator = "-";editText.setText("")
            }

            R.id.b16 -> {
                operator = "+";editText.setText("")
            }
        }


    }

    fun procent(view: View) {
        oldNumber = editText.text.toString()
        var result = 0.0
        result = oldNumber.toDouble() / 100
        editText.setText(result.toString())
    }

    fun clickResult(view: View) {

        var newNumber = editText.text.toString()

        var result = 0.0

        if(newNumber.toDouble()<0.0000001 && operator=="/"||
                newNumber.equals("0") && operator=="/" ||
            newNumber.equals("") && operator=="/" ){
            Toast.makeText(this@MainActivity,"На ноль делить нелзя",Toast.LENGTH_SHORT).show()
        }else{}



        when (operator) {
            "-" -> result = oldNumber.toDouble() - newNumber.toDouble()
            "/" -> result = oldNumber.toDouble() / newNumber.toDouble()
            "*" -> result = oldNumber.toDouble() * newNumber.toDouble()
            "+" -> result = oldNumber.toDouble() + newNumber.toDouble()
        }
        editText.setText(result.toString())
    }

    fun cClick(view: View) {
        editText.setText("0")
    }


}