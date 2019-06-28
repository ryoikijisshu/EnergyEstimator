package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.preference.PreferenceManager
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_result2.*
import java.lang.reflect.Array.getInt

class ResultActivity2:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)

        val gender = intent.getIntExtra("gender", 0)
        val weight = intent.getIntExtra("weight", 0)
        val age = intent.getIntExtra("age", 0)
        val level = intent.getIntExtra("level", 0)

        var metabolism : Double = 0.0
        var bodylevel : Double = 0.00
        var energy : Double = 0.00

        if(gender==1)
        {
            if(age>=1 && age<=2)
            {
                metabolism = 61.0
            }
            else if(age>=3 && age<=5)
            {
                metabolism = 54.8
            }
            else if(age>=6 && age<=7)
            {
                metabolism = 44.3
            }
            else if(age>=8 && age<=9)
            {
                metabolism = 40.8
            }
            else if(age>=10 && age<=11)
            {
                metabolism = 37.4
            }
            else if(age>=12 && age<=14)
            {
                metabolism = 31.0
            }
            else if(age>=15 && age<=17)
            {
                metabolism = 27.0
            }
            else if(age>=18 && age<=29)
            {
                metabolism = 24.0
            }
            else if(age>=30 && age<=49)
            {
                metabolism = 22.3
            }
            else if(age>=50 && age<=69)
            {
                metabolism = 21.5
            }
            else if(age>=70)
            {
                metabolism = 21.5
            }
        }
        else if(gender==2)
        {
            if(age>=1 && age<=2)
            {
                metabolism = 59.7
            }
            else if(age>=3 && age<=5)
            {
                metabolism = 52.2
            }
            else if(age>=6 && age<=7)
            {
                metabolism = 41.9
            }
            else if(age>=8 && age<=9)
            {
                metabolism = 38.3
            }
            else if(age>=10 && age<=11)
            {
                metabolism = 34.8
            }
            else if(age>=12 && age<=14)
            {
                metabolism = 29.6
            }
            else if(age>=15 && age<=17)
            {
                metabolism = 25.3
            }
            else if(age>=18 && age<=29)
            {
                metabolism = 22.1
            }
            else if(age>=30 && age<=49)
            {
                metabolism = 21.7
            }
            else if(age>=50 && age<=69)
            {
                metabolism = 20.7
            }
            else if(age>=70)
            {
                metabolism = 20.7
            }
        }
        if(level==1)
        {
            if(age>=1 && age<=2)
            {
                bodylevel = 1.00
            }
            else if(age>=3 && age<=5)
            {
                bodylevel = 1.00
            }
            else if(age>=6 && age<=7)
            {
                bodylevel = 1.35
            }
            else if(age>=8 && age<=9)
            {
                bodylevel = 1.40
            }
            else if(age>=10 && age<=11)
            {
                bodylevel = 1.45
            }
            else if(age>=12 && age<=14)
            {
                bodylevel = 1.45
            }
            else if(age>=15 && age<=17)
            {
                bodylevel = 1.55
            }
            else if(age>=18 && age<=29)
            {
                bodylevel = 1.50
            }
            else if(age>=30 && age<=49)
            {
                bodylevel = 1.50
            }
            else if(age>=50 && age<=69)
            {
                bodylevel = 1.50
            }
            else if(age>=70)
            {
                bodylevel = 1.45
            }
        }
        else if(level==2)
        {
            if(age>=1 && age<=2)
            {
                bodylevel = 1.35
            }
            else if(age>=3 && age<=5)
            {
                bodylevel = 1.45
            }
            else if(age>=6 && age<=7)
            {
                bodylevel = 1.55
            }
            else if(age>=8 && age<=9)
            {
                bodylevel = 1.60
            }
            else if(age>=10 && age<=11)
            {
                bodylevel = 1.65
            }
            else if(age>=12 && age<=14)
            {
                bodylevel = 1.65
            }
            else if(age>=15 && age<=17)
            {
                bodylevel = 1.75
            }
            else if(age>=18 && age<=29)
            {
                bodylevel = 1.75
            }
            else if(age>=30 && age<=49)
            {
                bodylevel = 1.75
            }
            else if(age>=50 && age<=69)
            {
                bodylevel = 1.75
            }
            else if(age>=70)
            {
                bodylevel = 1.70
            }
        }
        else if(level==3)
        {
            if(age>=1 && age<=2)
            {
                bodylevel = 1.00
            }
            else if(age>=3 && age<=5)
            {
                bodylevel = 1.00
            }
            else if(age>=6 && age<=7)
            {
                bodylevel = 1.75
            }
            else if(age>=8 && age<=9)
            {
                bodylevel = 1.80
            }
            else if(age>=10 && age<=11)
            {
                bodylevel = 1.85
            }
            else if(age>=12 && age<=14)
            {
                bodylevel = 1.85
            }
            else if(age>=15 && age<=17)
            {
                bodylevel = 1.95
            }
            else if(age>=18 && age<=29)
            {
                bodylevel = 2.00
            }
            else if(age>=30 && age<=49)
            {
                bodylevel = 2.00
            }
            else if(age>=50 && age<=69)
            {
                bodylevel = 2.00
            }
            else if(age>=70)
            {
                bodylevel = 1.95
            }
        }
        energy = metabolism*weight*bodylevel

        resultview.text = energy.toString()+"kcal/日です！"

        top.setOnClickListener {
            val intent = Intent(application, MainActivity::class.java)
            startActivity(intent)

        }

    }
}