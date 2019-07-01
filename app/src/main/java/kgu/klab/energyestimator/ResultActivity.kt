package kgu.klab.energyestimator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val gender = intent.getIntExtra("gender", 0)
        val weight = intent.getIntExtra("weight", 0)
        val age = intent.getIntExtra("age", 0)
        val level = intent.getIntExtra("level", 0)

        if (gender==1){
            genderid.text = "男性"
        }
        else{
            genderid.text = "女性"
        }
        if (level==1){
            levelid.text = "低"
        }
        else if(level==2){
            levelid.text = "中"
        }
        else{
            levelid.text = "高"
        }

        weightid.text = weight.toString()+"kg"
        ageid.text = age.toString()+"歳"

        back.setOnClickListener {
            finish()
        }
    }
}
