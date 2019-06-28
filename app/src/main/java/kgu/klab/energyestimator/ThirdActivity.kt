package kgu.klab.energyestimator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val intent=getIntent()
        val valueSex:Int=intent.extras.getInt("sex")
        val valueAge:Int=intent.extras.getInt("age")
        val valueWeight:Double=intent.extras.getDouble("weight")
        val valueActivity:Int=intent.extras.getInt("activity")
        var energyNeeded:Double=0.0
        var bms:Double=0.0 //基礎代謝基準値
        var realActivityValue:Double=0.0

        when(valueAge){
            in 1..2 -> {
                if (valueSex==0) {
                    bms=61.0
                }else{
                    bms=59.7
                }
            }

            in 3..5->{
                if(valueSex==0){
                    bms=54.8
                }else{
                    bms=52.2
                }
            }

            in 6..7->{
                if(valueSex==0){
                    bms=44.3
                }else{
                    bms=41.9
                }
            }

            in 8..9->{
                if(valueSex==0){
                    bms=40.8
                }else{
                    bms=38.3
                }
            }

            in 10..11->{
                if(valueSex==0){
                    bms=37.4
                }else{
                    bms=34.8
                }
            }

            in 12..14->{
                if(valueSex==0){
                    bms=31.0
                }else{
                    bms=29.6
                }
            }

            in 15..17->{
                if(valueSex==0){
                    bms=27.0
                }else{
                    bms=25.3
                }
            }

            in 18..29->{
                if(valueSex==0){
                    bms=24.0
                }else{
                    bms=22.1
                }
            }

            in 30..49->{
                if(valueSex==0){
                    bms=22.3
                }else{
                    bms=21.7
                }
            }

            in 50..69->{
                if(valueSex==0){
                    bms=21.5
                }else{
                    bms=20.7
                }
            }

            in 70..100->{
                if(valueSex==0){
                    bms=21.5
                }else{
                    bms=20.7
                }
            }
        }

        when(valueAge){
            in 1..2 -> {
                realActivityValue=1.35
                }

            in 3..5-> {
                realActivityValue=1.45
            }

            in 6..7->{
                if(valueActivity==0){
                    realActivityValue=1.35
                }else if(valueActivity==1){
                    realActivityValue=1.55
                }else{
                    realActivityValue=1.75
                }
            }

            in 8..9->{
                if(valueActivity==0){
                    realActivityValue=1.40
                }else if(valueActivity==1){
                    realActivityValue=1.60
                }else{
                    realActivityValue=1.80
                }
            }

            in 10..11->{
                if(valueActivity==0){
                    realActivityValue=1.45
                }else if(valueActivity==1){
                    realActivityValue=1.65
                }else{
                    realActivityValue=1.85
                }
            }

            in 12..14->{
                if(valueActivity==0){
                    realActivityValue=1.45
                }else if(valueActivity==1){
                    realActivityValue=1.65
                }else{
                    realActivityValue=1.85
                }
            }

            in 15..17->{
                if(valueActivity==0){
                    realActivityValue=1.55
                }else if(valueActivity==1){
                    realActivityValue=1.75
                }else{
                    realActivityValue=1.95
                }
            }

            in 18..29->{
                if(valueActivity==0){
                    realActivityValue=1.50
                }else if(valueActivity==1){
                    realActivityValue=1.75
                }else{
                    realActivityValue=2.00
                }
            }

            in 30..49->{
                if(valueActivity==0){
                    realActivityValue=1.50
                }else if(valueActivity==1){
                    realActivityValue=1.75
                }else{
                    realActivityValue=2.00
                }
            }

            in 50..69->{
                if(valueActivity==0){
                    realActivityValue=1.50
                }else if(valueActivity==1){
                    realActivityValue=1.75
                }else{
                    realActivityValue=2.00
                }
            }

            in 70..100->{
                if(valueActivity==0){
                    realActivityValue=1.45
                }else if(valueActivity==1){
                    realActivityValue=1.70
                }else{
                    realActivityValue=1.95
                }
            }
        }

        energyNeeded=bms*valueWeight*realActivityValue

        textCal.text=String.format("%.0f kcalです",energyNeeded)

        buttonBackToTop.setOnClickListener(){
            finish()
        }
    }
}
