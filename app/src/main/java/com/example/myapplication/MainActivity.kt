package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var newOp = true
    private var op = "+"
    private var oldNumber = ""
    private var zero = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun caseNumber(view: View) {
        if (newOp) {

            findViewById<EditText>(R.id.tvInput).setText("")
        }
        newOp = false
        val buttonSel: Button = view as Button

        var myClick = findViewById<EditText>(R.id.tvInput).text.toString()

        when(buttonSel.id)
        {
            R.id.but_zer->
            {
                myClick+="0"
            }
            R.id.but_one->
            {
                myClick+="1"
            }
            R.id.but_two->
            {
                myClick+="2"
            }
            R.id.but_thr->
            {
                myClick+="3"
            }
            R.id.but_for->
            {
                myClick+="4"
            }
            R.id.but_fiv->
            {
                myClick+="5"
            }
            R.id.but_six->
            {
                myClick+="6"
            }
            R.id.but_sev->
            {
                myClick+="7"
            }
            R.id.but_ei->
            {
                myClick+="8"
            }
            R.id.but_ni->
            {
                myClick+="9"
            }
            R.id.but_do->
            {
                if(!zero)
                {
                    myClick += "."
                }
                zero=true
            }
        }
        findViewById<EditText>(R.id.tvInput).setText(myClick)
    }


    fun operatorCase(view: View) {
        newOp = true
        zero = false


        val buSelect= view as Button
        when(buSelect.id)
        {
            R.id.but_mul->
            {
                op="*"
            }
            R.id.but_div ->
            {
                op="/"
            }
            R.id.but_min->
            {
                op="-"
            }
            R.id.but_plus->
            {
                op="+"
            }
            R.id.but_d->{
                op="%"
            }
        }
        oldNumber  = findViewById<EditText>(R.id.tvInput).text.toString()
        newOp=true
        zero =false
        findViewById<EditText>(R.id.tvInput).setText(op)

    }
    fun buPer(view: View)
    {
        val number=(findViewById<EditText>(R.id.tvInput).text.toString().toDouble())/100
        findViewById<EditText>(R.id.tvInput).setText(number.toString())
        newOp=true
    }

    fun deleteCase(view: View) {
//        val buttonSel: Button = view as Button
//        val hey: String = oldNumber.dropLast(oldNumber.length)
//        when (buttonSel.id) {
//            R.id.but_d -> {
//                findViewById<Button>(R.id.but_c).text = "0"
//                newOp = true
//            }
//
//        }

        findViewById<EditText>(R.id.tvInput).setText("")
        newOp = true
        zero= false
    }

    fun equalCase(view: View) {

        val newNumber: String = findViewById<EditText>(R.id.tvInput).text.toString()
        var result = 0.0
        when (op) {
            "+" -> {
                result = oldNumber.toDouble() + newNumber.toDouble()
            }
            "*" -> {
                result = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                result = oldNumber.toDouble() / newNumber.toDouble()
            }
            "-" -> {
                result = oldNumber.toDouble() - newNumber.toDouble()
            }
            "%"->{
                result=  (oldNumber.toDouble() * newNumber.toDouble())/100
            }
        }
        findViewById<EditText>(R.id.tvInput).setText(result.toString())
        newOp=true
    }

}








