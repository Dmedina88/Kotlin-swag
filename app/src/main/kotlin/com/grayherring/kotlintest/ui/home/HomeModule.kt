package com.grayherring.kotlintest.ui.home

import android.app.Activity
import android.content.Context
import com.grayherring.kotlintest.dagger.PerActivity
import com.grayherring.kotlintest.data.modul.Book
import com.grayherring.kotlintest.data.networking.SwagApiClient
import com.jakewharton.rxrelay2.BehaviorRelay
import dagger.Module
import dagger.Provides

@Module
class HomeModule(private val activity: HomeActivity) {


  @Provides @PerActivity internal fun provideContext(): Context = activity

  @Provides @PerActivity internal fun provideActivity(): Activity = activity

  @Provides @PerActivity internal fun provideHomeView(): HomeView = activity

//  @Provides @PerActivity internal fun provideHomeVM(swagApiClient: SwagApiClient,
//                                                    bookRelay: BehaviorRelay<Book>,
//                                                    homeView: HomeView): HomeVM {
//    return HomeVM(swagApiClient, bookRelay, homeView)
//  }

  @Provides @PerActivity internal fun provideAdapter(homeView: HomeVM): BookAdapter {
    return BookAdapter(homeView)
  }

}