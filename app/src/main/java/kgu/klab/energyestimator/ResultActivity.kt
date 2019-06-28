package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

       var weight_number2:Int = 0
        var age_number2:Int = 0
        var number_of_gender:Int = 0
        var number_of_level:Int = 0
        val gender_id = intent.getIntExtra("GENDER_KEY",0)
        when(gender_id){
            1 -> gender_num_text.setText(R.string.result_men)
            2 -> gender_num_text.setText(R.string.result_women)
        }
        when(gender_id){
            1 -> number_of_gender = 1
            2 -> number_of_gender = 2
        }
        val level_id = intent.getIntExtra("LEVEL_KEY",0)
        when(level_id){
            1 -> level_num_text.setText(R.string.result_level_low)
            2 -> level_num_text.setText(R.string.result_level_medium)
            3 -> level_num_text.setText(R.string.result_level_high)
        }
        when(level_id) {
            1 -> number_of_level = 1
            2 -> number_of_level = 2
            3 -> number_of_level = 3
        }
        weight_number2 = intent.getIntExtra("WEIGHT_KEY",0)
        age_number2 = intent.getIntExtra("AGE_KEY",0)
        weight_num_text.setText(weight_number2.toString() + "kg")
        age_num_text.setText(age_number2.toString() + "歳")

        next_button.setOnClickListener {
                val intent = Intent(this,ResultActivity2::class.java)
                intent.putExtra("GENDER_KEY2",number_of_gender)
                intent.putExtra("WEIGHT_KEY2",weight_number2)
                intent.putExtra("AGE_KEY2",age_number2)
                intent.putExtra("LEVEL_KEY2",number_of_level)
                startActivity(intent)
            }

        backpage_button.setOnClickListener { finish() }

    }
}
