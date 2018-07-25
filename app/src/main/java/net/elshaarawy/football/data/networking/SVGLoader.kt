package net.elshaarawy.football.data.networking

import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.pixplicity.sharp.Sharp
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.InputStream

/**
 * Created by elshaarawy on 7/25/18.
 */
private class SVGLoader constructor(private val url: String) : Single<InputStream>() {
    override fun subscribeActual(observer: SingleObserver<in InputStream>) {
        val clint = OkHttpClient()
        val request = Request.Builder()
                .url(url)
                .build()
        val stream = clint.newCall(request).execute().body()?.byteStream()
        when (stream) {
            null -> observer.onError(Throwable("Null Value"))
            else -> observer.onSuccess(stream)
        }
    }

}

fun ImageView.loadSVG(url: String, @DrawableRes placeholder: Int? = null, @DrawableRes error: Int? = null) {

    if (placeholder != null) {
        Glide.with(this)
                .asGif()
                .load(placeholder)
                .into(this)
    }

    val onLoadFinished = fun(stream: InputStream) {
        Sharp.loadInputStream(stream)
                .into(this)
    }

    val onLoadFailure = fun(throwable: Throwable) {
        if (error != null) {
            Glide.with(this)
                    .asGif()
                    .load(error)
                    .into(this)
        }
    }

    SVGLoader(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onLoadFinished, onLoadFailure)
}

