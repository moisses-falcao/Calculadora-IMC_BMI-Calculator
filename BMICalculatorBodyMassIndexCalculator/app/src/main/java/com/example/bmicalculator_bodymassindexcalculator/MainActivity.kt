package com.example.bmicalculator_bodymassindexcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.bmicalculator_bodymassindexcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCalculate.setOnClickListener{

            val weight = binding.inWeight.text.toString()
            val height = binding.inHeight.text.toString()

            if(weight.isEmpty()){
                binding.message.setText("Please informe Weight.")
            }
            else if(height.isEmpty()){
                binding.message.setText("Please inform heigh.")
            }
            else{
                BMI_Calc()
            }
        }

    }
    private fun BMI_Calc(){

        var BMI: Float
        val weight = java.lang.Float.parseFloat(binding.inWeight.text.toString())
        val height = java.lang.Float.parseFloat(binding.inHeight.text.toString())
        var result = binding.message
        BMI = weight/(height*height)

        val message = when{
            BMI <=18.5 -> "Low Weight"
            BMI <=24.9 -> "Normal Weight"
            BMI <=29.9 -> "Overweight"
            BMI <=34.9 -> "Obesity (Level 1)"
            BMI <=39.9 -> "Severe Obesity (Level 2)"
            else -> "Morbid Obesity (Level 3)"

        }
        result.setText("BIM: $BMI\n$message")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.bt_refresh ->{
                binding.inWeight.setText("")
                binding.inHeight.setText("")
                binding.message.setText("")
            }
        }

        return super.onOptionsItemSelected(item)
    }
}