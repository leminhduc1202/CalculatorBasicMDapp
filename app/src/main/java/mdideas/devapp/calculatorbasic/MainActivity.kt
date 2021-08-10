package mdideas.devapp.calculatorbasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mdideas.devapp.calculatorbasic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPlus.setOnClickListener {
            var number01 : Int = (binding.firstNumber.text.toString().toInt())
            var number02 : Int = (binding.secondNumber.text.toString().toInt())
            var result : Int = number01 + number02
            binding.result.text = result.toString()
        }
        binding.buttonPlus.setOnClickListener {
            var number01 : Int = (binding.firstNumber.text.toString().toInt())
            var number02 : Int = (binding.secondNumber.text.toString().toInt())
            var result : Int = number01 - number02
            binding.result.text = result.toString()
        }
        binding.buttonPlus.setOnClickListener {
            var number01 : Int = (binding.firstNumber.text.toString().toInt())
            var number02 : Int = (binding.secondNumber.text.toString().toInt())
            var result : Int = number01 * number02
            binding.result.text = result.toString()
        }
        binding.buttonPlus.setOnClickListener {
            var number01: Int = (binding.firstNumber.text.toString().toInt())
            var number02: Int = (binding.secondNumber.text.toString().toInt())
            var result: Int = number01 / number02
            binding.result.text = result.toString()
        }

    }

}
