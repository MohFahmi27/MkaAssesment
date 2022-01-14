package com.mohfahmi.mkaassesment.utils

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

object ViewUtils {
    fun ImageView.setRoundedGlide(urlPath: String) {
        Glide.with(context).load(urlPath)
            .apply(RequestOptions().transform(RoundedCorners(15)))
            .into(this)
    }

    fun ProgressBar.stateConfig(state: Boolean) {
        if (state) {
            this.visibility = View.VISIBLE
        } else {
            this.visibility = View.INVISIBLE
        }
    }
}