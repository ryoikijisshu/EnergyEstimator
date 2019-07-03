package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_check.*
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var sex:String
        var weight:Int
        var age:Int
        var level:String
        var num0:Double = 0.0
        var num1:Double = 0.0
        var result:Int = 0

        PreferenceManager.getDefaultSharedPreferences(this).apply {
            sex = getString("SEX", "")
            weight = getInt("WEIGHT", 0)
            age = getInt("AGE", 0)
            level = getString("LEVEL", "")
        }

        when(sex){
            "男性" ->
                when{
                    age==1 || age==2 ->  num0 = 61.0
                    age==3 || age==4 || age==5 -> num0 = 54.8
                    age==6 || age==7 -> num0 = 44.3
                    age==8 || age==9 -> num0 = 40.8
                    age==10 || age==11 -> num0 = 37.4
                    age==12 || age==13 || age==14 -> num0 = 31.0
                    age==15 || age==16 || age==17 -> num0 = 27.0
                    age>=18 && age<=29 -> num0 = 24.0
                    age>=30 && age>=49 -> num0 = 22.3
                    age>=50-> num0 = 21.5
                }
            "女性" ->
                when{
                    age==1 || age==2 ->  num0 = 59.7
                    age==3 || age==4 || age==5 -> num0 = 52.2
                    age==6 || age==7 -> num0 = 41.9
                    age==8 || age==9 -> num0 = 38.3
                    age==10 || age==11 -> num0 = 34.8
                    age==12 || age==13 || age==14 -> num0 = 29.6
                    age==15 || age==16 || age==17 -> num0 = 25.3
                    age>=18 && age<=29 -> num0 = 22.1
                    age>=30 && age>=49 -> num0 = 21.7
                    age>=50-> num0 = 20.7
                }
        }

        when(level){
            "低" ->
                when{
                    age==1 || age==2 ->  num1 = 1.35
                    age==3 || age==4 || age==5 -> num1 = 1.35
                    age==6 || age==7 -> num1 = 1.35
                    age==8 || age==9 -> num1 = 1.40
                    age==10 || age==11 -> num1 = 1.45
                    age==12 || age==13 || age==14 -> num1 = 1.45
                    age==15 || age==16 || age==17 -> num1 = 1.55
                    age>=18 && age<=29 -> num1 = 1.50
                    age>=30 && age<=49 -> num1 = 1.50
                    age>=50 && age<=69 -> num1 = 1.50
                    age>=70 -> num1 = 1.45
                }
            "中" ->
                when{
                    age==1 || age==2 ->  num1 = 1.35
                    age==3 || age==4 || age==5 -> num1 = 1.45
                    age==6 || age==7 -> num1 = 1.55
                    age==8 || age==9 -> num1 = 1.60
                    age==10 || age==11 -> num1 = 1.65
                    age==12 || age==13 || age==14 -> num1 = 1.65
                    age==15 || age==16 || age==17 -> num1 = 1.75
                    age>=18 && age<=29 -> num1 = 1.75
                    age>=30 && age<=49 -> num1 = 1.75
                    age>=50 && age<=69 -> num1 = 1.75
                    age>=70 -> num1 = 1.70
                }
            "高" ->
                when{
                    age==1 || age==2 ->  num1 = 1.75
                    age==3 || age==4 || age==5 -> num1 = 1.75
                    age==6 || age==7 -> num1 = 1.75
                    age==8 || age==9 -> num1 = 1.80
                    age==10 || age==11 -> num1 = 1.85
                    age==12 || age==13 || age==14 -> num1 = 1.85
                    age==15 || age==16 || age==17 -> num1 = 1.95
                    age>=18 && age<=29 -> num1 = 2.0
                    age>=30 && age<=49 -> num1 = 2.0
                    age>=50 && age<=69 -> num1 = 2.0
                    age>=70 -> num1 = 1.95
                }
        }

        result = (num0 * weight.toDouble() * num1).toInt()
        resultText.setText(result.toString())

        returnButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
