package com.feiyu.ganged

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.feiyu.rv.GangedRvActivity
import com.feiyu.rv.IIntent

class MainActivity : AppCompatActivity() {
  private var path = "sort.json"
  private lateinit var btnJump: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    initView()
    btnJump.setOnClickListener {
      val intent = Intent(this, GangedRvActivity::class.java)
      val data = DataUtil.getData(this, path)
      val bundle = Bundle()
      bundle.putSerializable(IIntent.DATA_TAG, data)
      intent.putExtras(bundle)
      startActivity(intent)
    }
  }

  private fun initView() {
    btnJump = findViewById(R.id.tv_jump);
  }
}