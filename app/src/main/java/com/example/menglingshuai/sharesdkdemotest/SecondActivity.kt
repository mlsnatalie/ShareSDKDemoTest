package com.example.menglingshuai.sharesdkdemotest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import cn.sharesdk.framework.Platform
import cn.sharesdk.framework.PlatformActionListener
import cn.sharesdk.framework.ShareSDK
import cn.sharesdk.sina.weibo.SinaWeibo
import com.mob.MobSDK
import kotlinx.android.synthetic.main.activity_main.*
import java.util.HashMap

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        button.setOnClickListener {
            val platform = ShareSDK.getPlatform(SinaWeibo.NAME)
            val shareParams = Platform.ShareParams()
//        shareParams.filePath = ResourcesManager.getInstace(MobSDK.getContext()).filePath
            shareParams.filePath = "/storage/emulated/0/cn.com.spero.elderwand/video/7a98af17e63a0ac09ce2e96d03992fbc.mp4"
            Log.e("aaaddd", "1111111111" + shareParams.filePath)
            shareParams.text = "aaaddd"
            platform.platformActionListener = MyPlatformActionListener()
            platform.share(shareParams)
        }
    }

    internal inner class MyPlatformActionListener : PlatformActionListener {
        override fun onComplete(platform: Platform, i: Int, hashMap: HashMap<String, Any>) {
            Log.e("aaaddd", "11111111111111111111")
        }

        override fun onError(platform: Platform, i: Int, throwable: Throwable) {
            throwable.printStackTrace()
            val error = throwable.toString()
        }

        override fun onCancel(platform: Platform, i: Int) {
            Log.e("aaaddd", "22222222222222222222222")
            Toast.makeText(MobSDK.getContext(), "Cancel Share", Toast.LENGTH_SHORT).show()
        }
    }
}