package kgu.klab.energyestimator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

       var weight_number2:Int = 0
        var age_number2:Int = 0

        val gender_id = intent.getIntExtra("GENDER_KEY",0)
        when(gender_id){
            1 -> gender_num_text.setText(R.string.result_men)
            2 -> gender_num_text.setText(R.string.result_women)
        }
        val level_id = intent.getIntExtra("LEVEL_KEY",0)
        when(level_id){
            1 -> level_num_text.setText(R.string.result_level_low)
            2 -> level_num_text.setText(R.string.result_level_medium)
            3 -> level_num_text.setText(R.string.result_level_high)
        }
        weight_number2 = intent.getIntExtra("WEIGHT_KEY",0)
        age_number2 = intent.getIntExtra("AGE_KEY",0)
        weight_num_text.setText(weight_number2.toString() + "kg")
        age_num_text.setText(age_number2.toString() + "歳")
        back_button.setOnClickListener { finish() }

    }
}
