package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result2.*

class ResultActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)

        var gender_number:Int = 0
        var level_number:Int = 0
        var weight_number:Int = 0
        var age_number:Int = 0
        var kiso_number:Double = 0.0
        var sintai_number:Double = 0.0
        val gender_id2 = intent.getIntExtra("GENDER_KEY2",0)
        when(gender_id2){
          1 -> gender_number = 1
          2 ->    gender_number = 2
        }
        val level_id2 = intent.getIntExtra("LEVEL_KEY2",0)
        when(level_id2){
            1 -> level_number = 1
            2 -> level_number = 2
            3 -> level_number = 3
        }
        weight_number = intent.getIntExtra("WEIGHT_KEY2",0)
        age_number = intent.getIntExtra("AGE_KEY2",0)

        if( gender_number == 1) {


            if (1 <= age_number && age_number <= 2) {
                kiso_number = 61.0
            }
            else if(3 <= age_number && age_number <= 5){
                kiso_number = 54.8
            }
            else if( 6 <= age_number && age_number <= 7){
                kiso_number = 44.3
            }
            else if( 8 <= age_number && age_number <= 9){
                kiso_number = 40.8
            }
            else if( 10 <= age_number && age_number <= 11){
                kiso_number = 37.4
            }
            else if( 12 <= age_number && age_number <= 14){
                kiso_number = 31.0
            }
            else if( 15 <= age_number && age_number <= 17){
                kiso_number = 27.0
            }
            else if( 18 <= age_number && age_number <= 29){
                kiso_number = 24.0
            }
            else if( 30 <= age_number && age_number <= 49){
                kiso_number = 22.3
            }
            else if( 50 <= age_number && age_number <= 69){
                kiso_number = 21.5
            }
            else if( 70 >= age_number){
                kiso_number = 21.5
            }
            else
            {
                result_text.setText("NG")
            }
        }
        if( gender_number == 2) {


            if (1 <= age_number && age_number <= 2) {
                kiso_number = 59.7
            }
            else if(3 <= age_number && age_number <= 5){
                kiso_number = 52.2
            }
            else if( 6 <= age_number && age_number <= 7){
                kiso_number = 41.9
            }
            else if( 8 <= age_number && age_number <= 9){
                kiso_number = 38.3
            }
            else if( 10 <= age_number && age_number <= 11){
                kiso_number = 34.8
            }
            else if( 12 <= age_number && age_number <= 14){
                kiso_number = 29.6
            }
            else if( 15 <= age_number && age_number <= 17){
                kiso_number = 25.3
            }
            else if( 18 <= age_number && age_number <= 29){
                kiso_number = 22.1
            }
            else if( 30 <= age_number && age_number <= 49){
                kiso_number = 21.7
            }
            else if( 50 <= age_number && age_number <= 69){
                kiso_number = 20.7
            }
            else if( 70 >= age_number){
                kiso_number = 20.7
            }
            else
            {
                result_text.setText("NG")
            }
        }
        if( level_number == 1) {


            if (1 <= age_number && age_number <= 2) {
                sintai_number = 1.35
            }
            else if(3 <= age_number && age_number <= 5){
                sintai_number = 1.45
            }
            else if( 6 <= age_number && age_number <= 7){
                sintai_number = 1.35
            }
            else if( 8 <= age_number && age_number <= 9){
                sintai_number = 1.40
            }
            else if( 10 <= age_number && age_number <= 11){
                sintai_number = 1.45
            }
            else if( 12 <= age_number && age_number <= 14){
                sintai_number = 1.45
            }
            else if( 15 <= age_number && age_number <= 17){
                sintai_number = 1.55
            }
            else if( 18 <= age_number && age_number <= 29){
                sintai_number = 1.50
            }
            else if( 30 <= age_number && age_number <= 49){
                sintai_number = 1.50
            }
            else if( 50 <= age_number && age_number <= 69){
                sintai_number = 1.50
            }
            else if( 70 >= age_number){
                sintai_number = 1.45
            }
            else
            {
                result_text.setText("NG")
            }
        }
        if( level_number == 2) {


            if (1 <= age_number && age_number <= 2) {
                sintai_number = 1.35
            }
            else if(3 <= age_number && age_number <= 5){
                sintai_number = 1.45
            }
            else if( 6 <= age_number && age_number <= 7){
                sintai_number = 1.55
            }
            else if( 8 <= age_number && age_number <= 9){
                sintai_number = 1.60
            }
            else if( 10 <= age_number && age_number <= 11){
                sintai_number = 1.65
            }
            else if( 12 <= age_number && age_number <= 14){
                sintai_number = 1.65
            }
            else if( 15 <= age_number && age_number <= 17){
                sintai_number = 1.75
            }
            else if( 18 <= age_number && age_number <= 29){
                sintai_number = 1.75
            }
            else if( 30 <= age_number && age_number <= 49){
                sintai_number = 1.75
            }
            else if( 50 <= age_number && age_number <= 69){
                sintai_number = 1.75
            }
            else if( 70 >= age_number){
                sintai_number = 1.70
            }
            else
            {
                result_text.setText("NG")
            }
        }
        if( level_number == 3) {


            if (1 <= age_number && age_number <= 2) {
                sintai_number = 1.35
            }
            else if(3 <= age_number && age_number <= 5){
                sintai_number = 1.45
            }
            else if( 6 <= age_number && age_number <= 7){
                sintai_number = 1.75
            }
            else if( 8 <= age_number && age_number <= 9){
                sintai_number = 1.80
            }
            else if( 10 <= age_number && age_number <= 11){
                sintai_number = 1.85
            }
            else if( 12 <= age_number && age_number <= 14){
                sintai_number = 1.85
            }
            else if( 15 <= age_number && age_number <= 17){
                sintai_number = 1.95
            }
            else if( 18 <= age_number && age_number <= 29){
                sintai_number = 2.00
            }
            else if( 30 <= age_number && age_number <= 49){
                sintai_number = 2.00
            }
            else if( 50 <= age_number && age_number <= 69){
                sintai_number = 2.00
            }
            else if( 70 >= age_number){
                sintai_number = 1.95
            }
            else
            {
                result_text.setText("NG")
            }
        }


        var result_number:Int = 0
        result_number = (kiso_number * weight_number * sintai_number).toInt()

            result_text.setText(result_number.toString() + "kcal/日です！")
        top_button.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
