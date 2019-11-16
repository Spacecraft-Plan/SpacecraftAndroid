package com.hawksjamesf.uicomponent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_text_style.*

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawks.jamesf
 * @since: Nov/16/2019  Sat
 */
class TextStyleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        layoutInflater.factory2 = MyLayoutInflaterFactoryV2()
//        layoutInflater.factory = MyLayoutInflaterFactory()
        super.onCreate(savedInstanceState)
//        val field = LayoutInflater::class.java.getDeclaredField("mFactorySet")
//        field.isAccessible = true
//        field.setBoolean(layoutInflater, false)
        setContentView(R.layout.activity_text_style)
        tv_font.setOnClickListener{
//            val request = FontRequest(
//                    "com.google.android.gms.fonts",
//                    "com.google.android.gms",
//                    "Alfa Slab One",
//                    R.array.com_google_android_gms_fonts_certs
//            )
//            val callback = object : FontsContract.FontRequestCallback() {
//
//                override fun onTypefaceRetrieved(typeface: Typeface) {
//                    // Your code to use the font goes here
//                }
//
//                override fun onTypefaceRequestFailed(reason: Int) {
//                    // Your code to deal with the failure goes here
//                }
//            }
//            FontsContractCompat.requestFonts(this@TextStyleActivity, request, callback,handler)
            val font = ResourcesCompat.getFont(this@TextStyleActivity,R.font.alfa_slab_one)
            tv_font.typeface =font
        }

    }

}