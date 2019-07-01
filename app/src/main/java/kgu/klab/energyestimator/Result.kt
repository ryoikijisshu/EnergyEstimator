package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_kakunin.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_result.seibetu

class Result : AppCompatActivity() {

    var kcal:Double = 0.0
    var kijunti:Double = 0.0
    var level_number:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val intent=getIntent()
        val seibetu = intent.getStringExtra("seibetu")
        val level = intent.getStringExtra("level")
        val weight:Int = intent.getIntExtra("weight",0)
        val age:Int = intent.getIntExtra("age",0)

        seibetu_result.text = seibetu
        level_result.text = level
        weight_result2.text = weight.toString()
        age_result2.text = age.toString()


        when(age){

            in 1..2 -> {

                level_number = 1.35

                if (seibetu == "男性") {

                    kijunti = 61.0

                }else{

                    kijunti = 59.7

                }
            }
            in 3..5 -> {

                level_number = 1.45

                if (seibetu == "男性") {

                    kijunti = 54.8

                }else{

                    kijunti = 52.2

                }
            }
            in 6..7 -> {

                if(level == "低"){

                    level_number = 1.35

                }
                else if(level == "中"){

                    level_number = 1.55

                }
                else{

                    level_number = 1.75

                }

                if (seibetu == "男性") {

                    kijunti = 44.3


                }else{

                    kijunti = 41.9

                }
            }
            in 8..9 -> {

                if(level == "低"){

                    level_number = 1.40

                }
                else if(level == "中"){

                    level_number = 1.60

                }
                else{

                    level_number = 1.80

                }

                if (seibetu == "男性") {

                    kijunti = 40.8


                }else{

                    kijunti = 38.3

                }
            }
            in 10..11 -> {

                if(level == "低"){

                    level_number = 1.45

                }
                else if(level == "中"){

                    level_number = 1.65

                }
                else{

                    level_number = 1.85

                }

                if (seibetu == "男性") {

                    kijunti = 37.4


                }else{

                    kijunti = 34.8

                }
            }
            in 12..14 -> {

                if(level == "低"){

                    level_number = 1.45

                }
                else if(level == "中"){

                    level_number = 1.65

                }
                else{

                    level_number = 1.85

                }

                if (seibetu == "男性") {

                    kijunti = 31.0


                }else{

                    kijunti = 29.6

                }
            }
            in 15..17 -> {

                if(level == "低"){

                    level_number = 1.55

                }
                else if(level == "中"){

                    level_number = 1.75

                }
                else{

                    level_number = 1.95

                }

                if (seibetu == "男性") {

                    kijunti = 27.0


                }else{

                    kijunti = 25.3

                }
            }
            in 18..29 -> {

                if(level == "低"){

                    level_number = 1.50

                }
                else if(level == "中"){

                    level_number = 1.75

                }
                else{

                    level_number = 2.00

                }

                if (seibetu == "男性") {

                    kijunti = 24.0


                }else{

                    kijunti = 22.1

                }
            }
            in 30..49 -> {

                if(level == "低"){

                    level_number = 1.50

                }
                else if(level == "中"){

                    level_number = 1.75

                }
                else{

                    level_number = 2.00

                }

                if (seibetu == "男性") {

                    kijunti = 22.3


                }else{

                    kijunti = 21.7

                }
            }
            in 50..69 -> {

                if(level == "低"){

                    level_number = 1.50

                }
                else if(level == "中"){

                    level_number = 1.75

                }
                else{

                    level_number = 2.00

                }

                if (seibetu == "男性") {

                    kijunti = 21.5


                }else{

                    kijunti = 20.7

                }
            }
            in 70..100 -> {

                if(level == "低"){

                    level_number = 1.45

                }
                else if(level == "中"){

                    level_number = 1.70

                }
                else{

                    level_number = 1.95

                }

                if (seibetu == "男性") {

                    kijunti = 21.5


                }else{

                    kijunti = 20.7

                }
            }

        }

        //推定エネルギー必要量(kcal/日)= 基礎代謝基準値 * 体重(kg) * 身体活動レベル指数
        kcal = kijunti * weight *level_number

        no.setOnClickListener{finish()}


    }

    fun onYesButtonTapped(view: View?){

        val intent2 = Intent(this,Kakunin::class.java)
        intent2.putExtra("kcal",kcal)
        startActivity(intent2)

    }


}
