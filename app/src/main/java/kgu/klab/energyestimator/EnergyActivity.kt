package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_energy.*

class EnergyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_energy)

        val genderVal = intent.getIntExtra("GENDER", 0)
        val activeVal = intent.getIntExtra("ACTIVE", 0)
        val weightVal = intent.getIntExtra("WEIGHT", 0)
        val ageVal = intent.getIntExtra("AGE", 0)

        var metabo: Double = 0.0
        var active: Double = 0.0

        var energyEstimator:Double = 0.0

        if (genderVal == 1) {
            if (ageVal >= 1 && ageVal <= 2) metabo = 61.0
            else if (ageVal <= 5) metabo = 54.8
            else if (ageVal <= 7) metabo = 44.3
            else if (ageVal <= 9) metabo = 40.8
            else if (ageVal <= 11) metabo = 37.4
            else if (ageVal <= 14) metabo = 31.0
            else if (ageVal <= 17) metabo = 27.0
            else if (ageVal <= 29) metabo = 24.0
            else if (ageVal <= 49) metabo = 22.3
            else if (ageVal <= 69) metabo = 21.5
            else metabo = 21.5
        }

        if (genderVal == 2) {
            if (ageVal >= 1 && ageVal <= 2) metabo = 59.7
            else if (ageVal <= 5) metabo = 52.2
            else if (ageVal <= 7) metabo = 41.9
            else if (ageVal <= 9) metabo = 38.3
            else if (ageVal <= 11) metabo = 34.8
            else if (ageVal <= 14) metabo = 29.6
            else if (ageVal <= 17) metabo = 25.3
            else if (ageVal <= 29) metabo = 22.1
            else if (ageVal <= 49) metabo = 21.7
            else if (ageVal <= 69) metabo = 20.7
            else metabo = 20.7
        }

        if (activeVal == 1) {
            if (ageVal >= 1 && ageVal <= 2) active = 1.35
            else if (ageVal <= 5) active = 1.45
            else if (ageVal <= 7) active = 1.35
            else if (ageVal <= 9) active = 1.40
            else if (ageVal <= 11) active = 1.45
            else if (ageVal <= 14) active = 1.45
            else if (ageVal <= 17) active = 1.55
            else if (ageVal <= 29) active = 1.50
            else if (ageVal <= 49) active = 1.50
            else if (ageVal <= 69) active = 1.50
            else active = 1.45
        }

        if (activeVal == 2) {
            if (ageVal >= 1 && ageVal <= 2) active = 1.35
            else if (ageVal <= 5) active = 1.45
            else if (ageVal <= 7) active = 1.55
            else if (ageVal <= 9) active = 1.60
            else if (ageVal <= 11) active = 1.65
            else if (ageVal <= 14) active = 1.65
            else if (ageVal <= 17) active = 1.75
            else if (ageVal <= 29) active = 1.75
            else if (ageVal <= 49) active = 1.75
            else if (ageVal <= 69) active = 1.75
            else active = 1.70
        }

        if (activeVal == 3) {
            if (ageVal >= 1 && ageVal <= 2) active = 1.35
            else if (ageVal <= 5) active = 1.45
            else if (ageVal <= 7) active = 1.75
            else if (ageVal <= 9) active = 1.80
            else if (ageVal <= 11) active = 1.85
            else if (ageVal <= 14) active = 1.85
            else if (ageVal <= 17) active = 1.95
            else if (ageVal <= 29) active = 2.00
            else if (ageVal <= 49) active = 2.00
            else if (ageVal <= 69) active = 2.00
            else active = 1.95
        }

        energyEstimator=metabo*weightVal*active

        if (ageVal==0) resultText.setText("求められません")
        else resultText.setText(energyEstimator.toInt().toString()+"kcal/日です！")

        top.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
