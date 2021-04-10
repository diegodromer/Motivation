package com.diegolima.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.diegolima.motivation.R
import com.diegolima.motivation.infra.MotivationConstants
import com.diegolima.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

   private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurityPreferences = SecurityPreferences(this)

        button_save.setOnClickListener (this)



    }

    override fun onClick(v: View?) {
        val id = v?.id
        if(id == R.id.button_save){
            handleSave()
        }
    }

    private fun handleSave() {
        val name = editName.text.toString()
        if(name != ""){
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
        }else{
            Toast.makeText(this, "Informe seu nome", Toast.LENGTH_SHORT).show()
        }
    }


}