package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val sexid = intent.getIntExtra("Sex",0)
        when(sexid){
            0 -> s_View.setText("男性")
            1 -> s_View.setText("女性")
        }

        val weightid = intent.getIntExtra("Weight",0)
        w_View.setText( "" + weightid + "kg")

        val oldid = intent.getIntExtra("Old",0)
        o_View.setText( "" + oldid + "歳")

        val activityid = intent.getIntExtra("Activity",0)
        when(activityid){
            0 -> a_View.setText("低")
            1 -> a_View.setText("中")
            2 -> a_View.setText("高")
        }

        b_back.setOnClickListener{
            finish()
        }

        go.setOnClickListener{
            val intent =  Intent(this, Main3Activity::class.java)
            intent.putExtra("Sex",sexid)
            intent.putExtra("Weight",weightid)
            intent.putExtra("Old",oldid)
            intent.putExtra("Activity",activityid)
            startActivity(intent)
        }
    }
}
