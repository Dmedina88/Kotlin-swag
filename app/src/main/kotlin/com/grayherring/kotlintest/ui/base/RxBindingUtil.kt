package com.grayherring.kotlintest.ui.base

import android.net.Uri
import android.view.View
import android.widget.ImageView
import com.grayherring.kotlintest.util.applyThrottle
import com.jakewharton.rxbinding.view.clicks
import com.squareup.picasso.Picasso
import java.io.File

fun View.throttleClick() = clicks().applyThrottle()

fun ImageView.loudImage(string: String) =
    Picasso.with(context).load(string).fit().centerInside().into(this)

fun ImageView.loudImage(id: Int) = Picasso.with(context).load(id).fit().centerInside().into(this)

fun ImageView.loudImage(uri: Uri) = Picasso.with(context).load(uri).fit().centerInside().into(this)

fun ImageView.loudImage(file: File) =
    Picasso.with(context).load(file).fit().centerInside().into(this)
