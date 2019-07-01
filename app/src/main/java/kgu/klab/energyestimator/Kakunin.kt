package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_kakunin.*
import kotlinx.android.synthetic.main.activity_result.*

class Kakunin : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kakunin)

        val intent=getIntent()
        val kcalval:Double = intent.getDoubleExtra("kcal",0.0)


        kcal.text = kcalval.toString()


    }

    fun onbackButtonTapped(view: View?){

        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)

    }

}
