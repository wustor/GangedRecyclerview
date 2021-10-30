package com.feiyu.ganged

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.feiyu.rv.GangedRvActivity

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    findViewById<Button>(R.id.tv_jump).setOnClickListener {
      startActivity(Intent(this,GangedRvActivity::class.java))
    }
  }
}