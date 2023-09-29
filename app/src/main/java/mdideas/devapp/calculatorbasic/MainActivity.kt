package mdideas.devapp.calculatorbasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import mdideas.devapp.calculatorbasic.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val nf = DecimalFormat()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonClear.setOnClickListener {
            binding.input.text = " "
            binding.output.text = " "
        }
        binding.buttonBracketLeft.setOnClickListener {
            binding.input.text = addToInputText(getString(R.string.app_bracket_left))
        }
        binding.buttonBracketRight.setOnClickListener {
            binding.input.text = addToInputText(getString(R.string.app_bracket_right))
        }
        binding.button0.setOnClickListener {
            binding.input.text = addToInputText(getString(R.string.app_number_zero))
        }
        binding.button1.setOnClickListener {
            binding.input.text = addToInputText(getString(R.string.app_number_one))
        }
        binding.button2.setOnClickListener {
            binding.input.text = addToInputText(getString(R.string.app_number_two))
        }
        binding.button3.setOnClickListener {
            binding.input.text = addToInputText(getString(R.string.app_number_three))
        }
        binding.button4.setOnClickListener {
            binding.input.text = addToInputText(getString(R.string.app_number_four))
        }
        binding.button5.setOnClickListener {
            binding.input.text = addToInputText(getString(R.string.app_number_five))
        }
        binding.button6.setOnClickListener {
            binding.input.text = addToInputText(getString(R.string.app_number_six))
        }
        binding.button7.setOnClickListener {
            binding.input.text = addToInputText(getString(R.string.app_number_seven))
        }
        binding.button8.setOnClickListener {
            binding.input.text = addToInputText(getString(R.string.app_number_eight))
        }
        binding.button9.setOnClickListener {
            binding.input.text = addToInputText(getString(R.string.app_number_nine))
        }
        binding.buttonDot.setOnClickListener {
            binding.input.text = addToInputText(getString(R.string.app_dot))
        }
        binding.buttonAddition.setOnClickListener {
            binding.input.text = addToInputText(getString(R.string.app_plus))
        }
        binding.buttonSubtraction.setOnClickListener {
            binding.input.text = addToInputText(getString(R.string.app_minus))
        }
        binding.buttonMultiply.setOnClickListener {
            binding.input.text = addToInputText(getString(R.string.app_multiply))
        }
        binding.buttonDivision.setOnClickListener {
            binding.input.text = addToInputText(getString(R.string.app_division))
        }
        binding.buttonEquals.setOnClickListener {
            showResult()
        }
        binding.backSpace.setOnClickListener {
            clearInputText()
        }
    }

    //Replace * and /
    private fun getInputExpression(): String {
        var expression = binding.input.text.replace(
            Regex(getString(R.string.app_division)),
            getString(R.string.app_char_division)
        )
        expression = expression.replace(
            Regex(getString(R.string.app_multiply)),
            getString(R.string.app_char_multiply)
        )
        return expression
    }

    //Show calculator result
    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                binding.output.text = getString(R.string.app_error)
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                binding.output.text = nf.format(result).toString()
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            binding.output.text = getString(R.string.app_error)
            binding.output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }

    //Add input function
    private fun addToInputText(buttonValue: String): String {
        return "${binding.input.text}$buttonValue"
    }

    //Add back space
    private fun clearInputText() {
        val length = binding.input.length()
        if (length > 0) {
            binding.input.text = binding.input.text.subSequence(0, length - 1)
        }
    }
}
