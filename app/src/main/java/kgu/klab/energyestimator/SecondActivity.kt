package kgu.klab.energyestimator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent=getIntent()
        val valueSex:Int=intent.extras.getInt("sex")
        val valueAge:Int=intent.extras.getInt("age")
        val valueWeight:Double=intent.extras.getDouble("weight")
        val valueActivity:Int=intent.extras.getInt("activity")

        var sex:String =""
        var activity:String=""

        if(valueSex==0){
            sex="男性"
        }else{
            sex="女性"
        }

        if(valueActivity==0){
            activity="低"
        }else if(valueActivity==1){
            activity="中"
        }else{
            activity="高"
        }

        textSex.text=sex
        textAge.text=valueAge.toString()+" 歳"
        textWeight.text=String.format("%.1f kg", valueWeight)
        textActivity.text=activity

        buttonBack.setOnClickListener(){
            finish()
        }
    }

}
