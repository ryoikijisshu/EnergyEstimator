package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_result.returnbutton
import kotlinx.android.synthetic.main.activity_result2.*

class Result2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)

        val weight = intent.getIntExtra("weight",0)
        val age = intent.getIntExtra("age",0)
        val gender = intent.getIntExtra("gender",0)
        val level = intent.getIntExtra("level",0)
        var s = 0
        var bm = 0.0
        var bl = 0.0

        //男性基礎代謝基準値
        if(gender == 1){
            if(1<=age && age<=2){
                bm = 61.0
            }
            else if(3<=age && age<=5){
                bm = 54.8
            }
            else if(6<=age && age<=7){
                bm = 44.3
            }
            else if(8<=age && age<=9){
                bm = 40.8
            }
            else if(10<=age && age<=11){
                bm = 37.2
            }
            else if(12<=age && age<=14){
                bm = 31.0
            }
            else if(15<=age && age<=17){
                bm = 27.0
            }
            else if(18<=age && age<=29){
                bm = 24.0
            }
            else if(30<=age && age<=49){
                bm = 22.3
            }
            else if(50<=age && age<=69){
                bm = 21.5
            }
            else if(70<=age){
                bm=21.5
            }
            else{
                resulttext.text = "あなたの年齢では計算できません"
            }
        }
        //女性基礎代謝基準値
        else if(gender == 2){
            if(1<=age && age<=2){
                bm = 59.7
            }
            else if(3<=age && age<=5){
                bm = 52.2
            }
            else if(6<=age && age<=7){
                bm = 41.9
            }
            else if(8<=age && age<=9){
                bm = 38.3
            }
            else if(10<=age && age<=11){
                bm = 34.8
            }
            else if(12<=age && age<=14){
                bm = 29.6
            }
            else if(15<=age && age<=17){
                bm = 25.3
            }
            else if(18<=age && age<=29){
                bm = 22.1
            }
            else if(30<=age && age<=49){
                bm = 21.7
            }
            else if(50<=age && age<=69){
                bm = 20.7
            }
            else if(70<=age){
                bm = 20.7
            }
            else{
                resulttext.text = "あなたの年齢では計算できません"
            }
        }
        else{
            resulttext.text = "性別を選択していないので計算できません"
        }

        //身体活動レベル指数
        if(1<=age && age<=2){
            bl = 1.35
        }
        else if(3<=age && age<=5){
            bl = 1.45
        }
        else if(6<=age && age<=7){
            if(level == 1){
                bl = 1.35
            }
            else if(level == 2){
                bl = 1.55
            }
            else if(level == 3){
                bl = 1.75
            }
            else{
                resulttext.text = "身体活動レベルを選択していないので計算できません"
            }
        }
        else if(8<=age && age<=9){
            if(level == 1){
                bl = 1.40
            }
            else if(level == 2){
                bl = 1.60
            }
            else if(level == 3){
                bl = 1.80
            }
            else{
                resulttext.text = "身体活動レベルを選択していないので計算できません"
            }
        }
        else if(10<=age && age<=11){
            if(level == 1){
                bl = 1.45
            }
            else if(level == 2){
                bl = 1.65
            }
            else if(level == 3){
                bl = 1.85
            }
            else{
                resulttext.text = "身体活動レベルを選択していないので計算できません"
            }
        }
        else if(12<=age && age<=14){
            if(level == 1){
                bl = 1.45
            }
            else if(level == 2){
                bl = 1.65
            }
            else if(level == 3){
                bl = 1.85
            }
            else{
                resulttext.text = "身体活動レベルを選択していないので計算できません"
            }
        }
        else if(15<=age && age<=17){
            if(level == 1){
                bl = 1.55
            }
            else if(level == 2){
                bl = 1.75
            }
            else if(level == 3){
                bl = 1.95
            }
            else{
                resulttext.text = "身体活動レベルを選択していないので計算できません"
            }
        }
        else if(18<=age && age<=29){
            if(level == 1){
                bl = 1.50
            }
            else if(level == 2){
                bl = 1.75
            }
            else if(level == 3){
                bl = 2.00
            }
            else{
                resulttext.text = "身体活動レベルを選択していないので計算できません"
            }
        }
        else if(30<=age && age<=49){
            if(level == 1){
                bl = 1.50
            }
            else if(level == 2){
                bl = 1.75
            }
            else if(level == 3){
                bl = 2.00
            }
            else{
                resulttext.text = "身体活動レベルを選択していないので計算できません"
            }
        }
        else if(50<=age && age<=69){
            if(level == 1){
                bl = 1.50
            }
            else if(level == 2){
                bl = 1.75
            }
            else if(level == 3){
                bl = 2.00
            }
            else{
                resulttext.text = "身体活動レベルを選択していないので計算できません"
            }
        }
        else if(70<=age){
            if(level == 1){
                bl = 1.45
            }
            else if(level == 2){
                bl = 1.70
            }
            else if(level == 3){
                bl = 1.95
            }
            else{
                resulttext.text = "身体活動レベルを選択していないので計算できません"
            }
        }
        else{
            resulttext.text = "あなたの年齢では計算できません"
        }

        if(0<weight && 0<age && 0<level && 0<gender){
            s = (bm * weight * bl).toInt()
            resulttext.text = s.toString() +"kcal/日です!!"
        }

        returnbutton.setOnClickListener { onreturnbuttonTapped(it) }
    }

    fun onreturnbuttonTapped(view: View?){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}
