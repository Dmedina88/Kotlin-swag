package com.grayherring.kotlintest

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.grayherring.kotlintest.dagger.PerApp
import com.grayherring.kotlintest.data.modul.Book
import com.jakewharton.rxrelay2.BehaviorRelay
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import timber.log.Timber

@Module
class DataModule {
  companion object {
    val PREF_NAME = "XzyPref"
  }

  @Provides @PerApp fun providePicasso(app: Application): Picasso {
    return Picasso.Builder(app)
        .listener { picasso, uri, e -> Timber.e(e, "Failed to load image: %s", uri) }
        .build()
  }

  @Provides @PerApp fun provideSharedPreferences(app: Application): SharedPreferences
      = app.getSharedPreferences(PREF_NAME, MODE_PRIVATE)

//    @Provides @PerApp @MockPref fun provideMockPref(pref: SharedPreferences): BoolPreferences
//            = BoolPreferences(pref, "MockPref")


  @Provides @PerApp fun provideSBookRelay(): BehaviorRelay<Book>
      = BehaviorRelay.create()
}
//todo not sure if it should be here or in the class
//  val PREF_NAME = "XzyPref"
