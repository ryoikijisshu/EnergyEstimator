package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result2.*

class Result2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)

        var kcal = 0.0
        var activelevel = 0.00
        var energy = 0.0

        val gender = intent.getIntExtra("gender", 0)
        val weight = intent.getIntExtra("weight", 0)
        val age = intent.getIntExtra("age", 0)
        val level = intent.getIntExtra("level", 0)

        if(gender==1){
            when(age){
                1,2 -> kcal = 61.0
                3,4,5 -> kcal = 54.8
                6,7 -> kcal = 44.3
                8,9 -> kcal =40.8
                10,11 -> kcal = 37.4
                12,13,14 -> kcal = 31.0
                15,16,17 -> kcal = 27.0
                in 18..29 -> kcal = 24.0
                in 30..49 -> kcal = 22.3
                in 50..69 -> kcal = 21.5
                in 70..80 -> kcal = 21.5
            }
        }
        else{
            when(age){
                1,2 -> kcal = 59.7
                3,4,5 -> kcal = 52.2
                6,7 -> kcal = 41.9
                8,9 -> kcal =38.3
                10,11 -> kcal = 34.8
                12,13,14 -> kcal = 29.6
                15,16,17 -> kcal = 25.3
                in 18..29 -> kcal = 22.1
                in 30..49 -> kcal = 21.7
                in 50..69 -> kcal = 20.7
                in 70..80 -> kcal = 20.7
            }
        }
        if(level==1){
            when(age){
                in 1..7 -> activelevel = 1.35
                8,9 -> activelevel =1.40
                in 10..14 -> activelevel = 1.45
                15,16,17 -> activelevel = 1.55
                in 18..69 -> activelevel = 1.50
                in 70..80 -> activelevel = 1.45
            }
        }
        else if(level==2){
            when(age){
                1,2 -> activelevel = 1.35
                3,4,5 -> activelevel = 1.45
                6,7 -> activelevel = 1.55
                8,9 -> activelevel =1.60
                in 10..14 -> activelevel = 1.65
                in 15..69 -> activelevel = 1.75
                in 70..80 -> activelevel = 1.70
            }
        }
        else{
            when(age){
                in 1..7 -> activelevel = 1.75
                8,9 -> activelevel =1.80
                in 10..14 -> activelevel = 1.85
                15,16,17 -> activelevel = 1.95
                in 18..69 -> activelevel = 2.00
                in 70..80 -> activelevel = 1.95
            }
        }
        energy = kcal * weight * activelevel
        calculation.text = "推定エネルギー必要量は"+energy.toString()+"kcal/日です"
        back.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}
