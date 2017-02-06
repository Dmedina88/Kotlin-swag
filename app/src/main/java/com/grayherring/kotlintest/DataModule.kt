package com.grayherring.kotlintest

import android.app.Application
import com.grayherring.kotlintest.dagger.PerApp
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import timber.log.Timber

@Module
class DataModule {

    @Provides @PerApp fun providePicasso(app: Application, client: OkHttpClient): Picasso {
        return Picasso.Builder(app)
                .downloader(OkHttp3Downloader(client))
                .listener { picasso, uri, e -> Timber.e(e, "Failed to load image: %s", uri) }
                .build()
    }

}