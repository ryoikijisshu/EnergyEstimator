package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.preference.PreferenceManager
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*
import java.lang.reflect.Array.getInt

class ResultActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val gender = intent.getIntExtra("gender",0)
        val weight = intent.getIntExtra("weight",0)
        val age = intent.getIntExtra("age",0)
        val level = intent.getIntExtra("level",0)

        if(gender==1)
        {
            genderid.text = "男性"
        }
        else if(gender==2)
        {
            genderid.text = "女性"
        }
        if(level==1)
        {
            levelid.text = "低"
        }
        else if(level==2)
        {
            levelid.text = "中"
        }
        else if(level==3)
        {
            levelid.text = "高"
        }

        weightid.text = weight.toString()+"kg"
        ageid.text = age.toString()+"歳"

    button2.setOnClickListener{
        val intent = Intent(application,MainActivity::class.java)
        startActivity(intent)
    }

    }
}