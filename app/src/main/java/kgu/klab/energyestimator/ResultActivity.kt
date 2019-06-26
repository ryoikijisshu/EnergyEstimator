package kgu.klab.energyestimator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val weight = intent.getIntExtra("weight",0)
        val age = intent.getIntExtra("age",0)
        val gender = intent.getIntExtra("gender",0)
        val level = intent.getIntExtra("level",0)

        weighttextView.text = weight.toString() + "kg"
        agetextView.text = age.toString() + "歳"

        if(gender == 1){
            gendertextView.text = "男性"
        }
        else if(gender == 2){
            gendertextView.text = "女性"
        }
        else{
            gendertextView.text = "性別を選択してください"
        }

        if(level == 1){
            leveltextView.text = "低"
        }
        else if(level == 2){
            leveltextView.text = "中"
        }
        else if(level == 3){
            leveltextView.text = "高"
        }
        else{
            leveltextView.text = "レベルを選択してください"
        }

        returnbutton.setOnClickListener { finish() }
    }
}
