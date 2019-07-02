package kgu.klab.energyestimator

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    lateinit var prefs : PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val id = intent.getIntExtra("Sex",0)
        val id2 = intent.getIntExtra("Level",0)
        val weight = intent.getIntExtra("Weight",0)
        val age = intent.getIntExtra("Age",0)


        when(id){
            R.id.men -> sex_result.setText("男")
            R.id.women -> sex_result.setText("女")
        }

        weight_result.text = weight.toString()

        age_result.text = age.toString()

        when(id2){
            R.id.low -> level_result.setText("低")
            R.id.medium -> level_result.setText("中")
            R.id.high -> level_result.setText("高")
        }


        backbutton.setOnClickListener{onBackButtonTapped(it)}


        var sex = 0
        var level = 0
        var cal = 0.0
        var meta = 0.0
        var act = 0.0

        when(id){
            R.id.men -> sex = 0
            R.id.women -> sex = 1
        }

        when(id2){
            R.id.low -> level = 0
            R.id.medium -> level = 1
            R.id.high -> level = 2
        }

        if(sex == 0){
            if(1 <= age && age <=2){
                meta = 61.0
            }
            else if(3 <= age && age <=5){
                meta = 54.8
            }
            else if(6 <= age && age <=7){
                meta = 44.3
            }
            else if(8 <= age && age <=9){
                meta = 40.8
            }
            else if(10 <= age && age <=11){
                meta = 37.4
            }
            else if(12 <= age && age <=14){
                meta = 31.0
            }
            else if(15 <= age && age <=17){
                meta = 27.0
            }
            else if(18 <= age && age <=29){
                meta = 24.0
            }
            else if(30 <= age && age <=49){
                meta = 22.3
            }
            else if(50 <= age && age <=69){
                meta = 21.5
            }
            else if(70 <= age){
                meta = 21.5
            }
        }
        else if(sex == 1){
            if(1 <= age && age <=2){
                meta = 59.7
            }
            else if(3 <= age && age <=5){
                meta = 52.2
            }
            else if(6 <= age && age <=7){
                meta = 41.9
            }
            else if(8 <= age && age <=9){
                meta = 38.3
            }
            else if(10 <= age && age <=11){
                meta = 34.8
            }
            else if(12 <= age && age <=14){
                meta = 29.6
            }
            else if(15 <= age && age <=17){
                meta = 25.3
            }
            else if(18 <= age && age <=29){
                meta = 22.1
            }
            else if(30 <= age && age <=49){
                meta = 21.7
            }
            else if(50 <= age && age <=69){
                meta = 20.7
            }
            else if(70 <= age){
                meta = 20.7
            }
        }

        if(level == 0){
            if(1 <= age && age <=2){
                act = 0.0
            }
            else if(3 <= age && age <=5){
                act = 0.0
            }
            else if(6 <= age && age <=7){
                act = 1.35
            }
            else if(8 <= age && age <=9){
                act = 1.40
            }
            else if(10 <= age && age <=11){
                act = 1.45
            }
            else if(12 <= age && age <=14){
                act = 1.45
            }
            else if(15 <= age && age <=17){
                act = 1.55
            }
            else if(18 <= age && age <=29){
                act = 1.50
            }
            else if(30 <= age && age <=49){
                act = 1.50
            }
            else if(50 <= age && age <=69){
                act = 1.50
            }
            else if(70 <= age){
                act = 1.45
            }
        }
        else if(level == 1){
            if(1 <= age && age <=2){
                act = 1.35
            }
            else if(3 <= age && age <=5){
                act = 1.45
            }
            else if(6 <= age && age <=7){
                act = 1.55
            }
            else if(8 <= age && age <=9){
                act = 1.60
            }
            else if(10 <= age && age <=11){
                act = 1.65
            }
            else if(12 <= age && age <=14){
                act = 1.65
            }
            else if(15 <= age && age <=17){
                act = 1.75
            }
            else if(18 <= age && age <=29){
                act = 1.75
            }
            else if(30 <= age && age <=49){
                act = 1.75
            }
            else if(50 <= age && age <=69){
                act = 1.75
            }
            else if(70 <= age){
                act = 1.70
            }
        }
        else if(level == 2){
            if(1 <= age && age <=2){
                act = 0.0
            }
            else if(3 <= age && age <=5){
                act = 0.0
            }
            else if(6 <= age && age <=7){
                act = 1.75
            }
            else if(8 <= age && age <=9){
                act = 1.80
            }
            else if(10 <= age && age <=11){
                act = 1.85
            }
            else if(12 <= age && age <=14){
                act = 1.85
            }
            else if(15 <= age && age <=17){
                act = 1.95
            }
            else if(18 <= age && age <=29){
                act = 2.00
            }
            else if(30 <= age && age <=49){
                act = 2.00
            }
            else if(50 <= age && age <=69){
                act = 2.00
            }
            else if(70 <= age){
                act = 1.95
            }
        }


        cal = meta * weight * act

        result.text = cal.toString() + "kcal/日"

    }

    fun onBackButtonTapped(view: View?){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
