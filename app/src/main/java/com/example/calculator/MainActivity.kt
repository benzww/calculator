package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    private lateinit var tvOne:TextView
    private lateinit var tvTwo:TextView
    private lateinit var tvThree:TextView
    private lateinit var tvFour: TextView
    private lateinit var tvFive: TextView
    private lateinit var tvSix: TextView
    private lateinit var tvSeven: TextView
    private lateinit var tvEight:TextView
    private lateinit var tvNine: TextView
    private lateinit var tvZero: TextView
    private lateinit var tvDot: TextView
    private lateinit var tvPlus: TextView
    private lateinit var tvMinus: TextView
    private lateinit var tvMul: TextView
    private lateinit var tvDivide: TextView
    private lateinit var tvOpen: TextView
    private lateinit var tvClose: TextView
    private lateinit var tvClear: TextView
    private lateinit var tvResult: TextView
    private lateinit var tvExpression: TextView
    private lateinit var tvBack: ImageView
    private lateinit var tvEquals: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvOne =findViewById(R.id.tvOne)
        tvTwo =findViewById(R.id.tvTwo)
        tvThree =findViewById(R.id.tvThree)
        tvFour =findViewById(R.id.tvFour)
        tvFive =findViewById(R.id.tvFive)
        tvSix =findViewById(R.id.tvSix)
        tvSeven =findViewById(R.id.tvSeven)
        tvEight =findViewById(R.id.tvEight)
        tvNine =findViewById(R.id.tvNine)
        tvZero=findViewById(R.id.tvZero)
        tvDot =findViewById(R.id.tvDot)
        tvPlus=findViewById(R.id.tvPlus)
        tvMinus=findViewById(R.id.tvMinus)
        tvMul=findViewById(R.id.tvMul)
        tvDivide=findViewById(R.id.tvDivide)
        tvOpen=findViewById(R.id.tvOpen)
        tvClose=findViewById(R.id.tvClose)
        tvClear=findViewById(R.id.tvClear)
        tvResult=findViewById(R.id.tvResult)
        tvExpression=findViewById(R.id.tvExpression)
        tvBack=findViewById(R.id.tvBack)
        tvEquals=findViewById(R.id.tvEquals)


        tvOne.setOnClickListener{ appendOnExpression("1", true) }
        tvTwo.setOnClickListener { appendOnExpression("2", true) }
        tvThree.setOnClickListener { appendOnExpression("3", true) }
        tvFour.setOnClickListener { appendOnExpression("4", true) }
        tvFive.setOnClickListener { appendOnExpression("5", true) }
        tvSix.setOnClickListener { appendOnExpression("6", true) }
        tvSeven.setOnClickListener { appendOnExpression("7", true) }
        tvEight.setOnClickListener { appendOnExpression("8", true) }
        tvNine.setOnClickListener { appendOnExpression("9", true) }
        tvZero.setOnClickListener { appendOnExpression("0", true) }
        tvDot.setOnClickListener { appendOnExpression(".", true) }
        tvPlus.setOnClickListener { appendOnExpression("+", true) }
        tvMinus.setOnClickListener { appendOnExpression("-", true) }
        tvMul.setOnClickListener { appendOnExpression("*", true) }
        tvDivide.setOnClickListener { appendOnExpression("/", true) }
        tvOpen.setOnClickListener { appendOnExpression("(", true) }
        tvClose.setOnClickListener { appendOnExpression(")", true) }
        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvExpression.text = ""
            tvResult.text = ""
        }
        tvBack.setOnClickListener {
            val string = tvExpression.text.toString()
            if (string.isNotEmpty()) {
                tvExpression.text = string.substring(0, string.length - 1)
            }
            tvResult.text = ""
        }
        tvEquals.setOnClickListener{
            try {
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toString()
            } catch (e:Exception)
            {
                 Log.d("Exception", "message : $e")
            }
        } }
    private fun appendOnExpression(string:String,canClear : Boolean){
        if(canClear) {
            tvResult.text = ""
            tvExpression.append(string)
        }else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }}


