package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val sexvalue = intent.getIntExtra("SEX_KEY", 0)
        val weightvalue = intent.getIntExtra("WEIGHT_KEY", 0)
        val agevalue = intent.getIntExtra("AGE_KEY", 0)
        val levelvalue = intent.getIntExtra("LEVEL_KEY", 0)
        var energy: Double = 0.0
        var calculatedvalue: Double = 0.0
        var activity: Double = 0.0
        if (sexvalue == 1) {
            when (agevalue) {
                1, 2 -> calculatedvalue = 61.0
                3, 4, 5 -> calculatedvalue = 54.8
                6, 7 -> calculatedvalue = 44.3
                8, 9 -> calculatedvalue = 40.8
                10, 11 -> calculatedvalue = 37.4
                12, 13, 14 -> calculatedvalue = 31.0
                15, 16, 17 -> calculatedvalue = 27.0
                in 18..29 -> calculatedvalue = 24.0
                in 30..49 -> calculatedvalue = 22.3
                in 50..69 -> calculatedvalue = 21.5
                in 70..99 -> calculatedvalue = 21.5
            }
        } else {
            when (agevalue) {
                1, 2 -> calculatedvalue = 59.7
                3, 4, 5 -> calculatedvalue = 52.2
                6, 7 -> calculatedvalue = 41.9
                8, 9 -> calculatedvalue = 38.3
                10, 11 -> calculatedvalue = 34.8
                12, 13, 14 -> calculatedvalue = 29.6
                15, 16, 17 -> calculatedvalue = 25.3
                in 18..29 -> calculatedvalue = 22.1
                in 30..49 -> calculatedvalue = 21.7
                in 50..69 -> calculatedvalue = 20.7
                in 70..99 -> calculatedvalue = 20.7
            }
        }
        if (levelvalue == 1) {
            when (agevalue) {
                1, 2 -> activity = 1.35
                3, 4, 5 -> activity = 1.45
                6, 7 -> activity = 1.35
                8, 9 -> activity = 1.40
                10, 11 -> activity = 1.45
                12, 13, 14 -> activity = 1.45
                15, 16, 17 -> activity = 1.55
                in 18..29 -> activity = 1.50
                in 30..49 -> activity = 1.50
                in 50..69 -> activity = 1.50
                in 70..99 -> activity = 1.45
            }
        } else if(levelvalue==2) {
            when (agevalue) {
                1, 2 -> activity = 1.35
                3, 4, 5 -> activity = 1.45
                6, 7 -> activity = 1.55
                8, 9 -> activity = 1.60
                10, 11 -> activity = 1.65
                12, 13, 14 -> activity = 1.65
                15, 16, 17 -> activity = 1.75
                in 18..29 -> activity = 1.75
                in 30..49 -> activity = 1.75
                in 50..69 -> activity = 1.75
                in 70..99 -> activity = 1.70
            }
        }else {
            when (agevalue) {
                1, 2 -> activity = 1.35
                3, 4, 5 -> activity = 1.45
                6, 7 -> activity = 1.75
                8, 9 -> activity = 1.80
                10, 11 -> activity = 1.85
                12, 13, 14 -> activity = 1.85
                15, 16, 17 -> activity = 1.95
                in 18..29 -> activity = 2.00
                in 30..49 -> activity = 2.00
                in 50..69 -> activity = 2.00
                in 70..99 -> activity = 1.95
            }
        }
        energy=weightvalue*calculatedvalue*activity
        resulttext.text=energy.toString()+"kcalです"
        backbutton.setOnClickListener {
            val intent = Intent(application, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
