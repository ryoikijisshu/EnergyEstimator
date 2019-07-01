package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val genderVal = intent.getIntExtra("GENDER", 0)
        val activeVal = intent.getIntExtra("ACTIVE", 0)
        val weightVal = intent.getIntExtra("WEIGHT", 0)
        val ageVal = intent.getIntExtra("AGE", 0)

        if(genderVal==1) {
            gender.setText("男性")
        }
        if (genderVal==2) {
            gender.setText("女性")
        }

        if(activeVal==1) {
            active.setText("低")
        }
        if (activeVal==2) {
            active.setText("中")
        }
        if(activeVal==3) {
            active.setText("高")
        }

        weight.setText(weightVal.toString()+"kg")
        age.setText(ageVal.toString()+"歳")

        next.setOnClickListener {
            val intent = Intent(this, EnergyActivity::class.java)
            intent.putExtra("GENDER", genderVal)
            intent.putExtra("ACTIVE", activeVal)
            intent.putExtra("WEIGHT", weightVal)
            intent.putExtra("AGE", ageVal)
            startActivity(intent)
        }

        back.setOnClickListener { finish() }
    }
}
