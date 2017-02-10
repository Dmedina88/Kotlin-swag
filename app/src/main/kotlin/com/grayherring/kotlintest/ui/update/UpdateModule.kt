package com.grayherring.kotlintest.ui.update

import android.app.Activity
import android.content.Context
import com.grayherring.kotlintest.dagger.PerActivity
import com.grayherring.kotlintest.data.modul.Book
import dagger.Module
import dagger.Provides

@Module
class UpdateModule(private val activity: UpdateActivity) {
  companion object {
    val EXTRA_BOOK = "EXTRA_BOOK"
  }

  @Provides @PerActivity internal fun provideContext(): Context {
    return activity
  }

  @Provides @PerActivity internal fun provideActivity(): Activity {
    return activity
  }

  @Provides @PerActivity internal fun provideUpdatView(): UpdateView {
    return activity
  }

  @Provides @PerActivity internal fun provideBook(): Book {
    return activity.intent.getSerializableExtra(EXTRA_BOOK) as Book
  }

}