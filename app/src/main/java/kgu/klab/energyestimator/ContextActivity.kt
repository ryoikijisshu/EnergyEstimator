package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_context.*

class ContextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)

        val sex = intent.getIntExtra("SEX_KEY", 0)
        val weight = intent.getIntExtra("WEIGHT_KEY", 0)
        val age = intent.getIntExtra("AGE_KEY", 0)
        val level = intent.getIntExtra("LEVEL_KEY", 0)

        if (sex == 1) {
            sextext.text = "男性"
        } else  {
            sextext.text = "女性"
        }
        weighttext1.text=weight.toString()+"kg"
        agetext1.text=age.toString()+"歳"

        if (level == 1) {
            leveltext.text = "低"
        } else if (level == 2) {
            leveltext.text = "中"
        } else  {
            leveltext.text = "高"
        }
        yesbutton.setOnClickListener {
            val intent = Intent(application, ResultActivity::class.java)
            intent.putExtra("SEX_KEY",sex)
            intent.putExtra("WEIGHT_KEY",weight)
            intent.putExtra("AGE_KEY",age)
            intent.putExtra("LEVEL_KEY",level)
            startActivity(intent)

        }
        nobutton.setOnClickListener {
            val intent = Intent(application, MainActivity::class.java)
            startActivity(intent)

        }
    }

}
