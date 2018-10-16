package com.felcks.loja_star_wars.ui

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.felcks.loja_star_wars.BuildConfig
import com.felcks.loja_star_wars.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_image_zoom.*

/**
 * Created by hal on 16/10/18.
 */
class ImageZoomActivity : AppCompatActivity() {

    var imagem: Bitmap? = null

    companion object {
        val NomesExtras_Imagem: String = "${BuildConfig.APPLICATION_ID}.extra_image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_zoom)

        val intent = intent
        val imagem = intent.getStringExtra(NomesExtras_Imagem)
        Picasso.with(applicationContext).load(imagem).into(img_expand)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val actionBar : ActionBar? = supportActionBar

        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}