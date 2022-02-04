package com.feiyu.ganged

import android.content.Context
import android.util.Log
import com.feiyu.rv.SortBean
import com.google.gson.Gson
import java.io.IOException

/**
 * Created by wustor
 * 日期  2/4/22.
 */
object DataUtil {
  private const val TAG = "DataUtil"

  fun getData(context: Context, path: String): SortBean {
    val assetsData = getAssetsData(context, path)
    val gson = Gson()
    return gson.fromJson(assetsData, SortBean::class.java)
  }

  //从资源文件中获取分类json
  private fun getAssetsData(context: Context, path: String): String {
    var result = ""
    return try {
      //获取输入流
      val mAssets = context.assets.open(path)
      //获取文件的字节数
      val lenght = mAssets.available()
      //创建byte数组
      val buffer = ByteArray(lenght)
      //将文件中的数据写入到字节数组中
      mAssets.read(buffer)
      mAssets.close()
      result = String(buffer)
      result
    } catch (e: IOException) {
      e.printStackTrace()
      Log.e(TAG, e.message!!)
      result
    }
  }
}