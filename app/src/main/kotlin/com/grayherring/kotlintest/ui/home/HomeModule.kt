package com.grayherring.kotlintest.ui.home

import android.app.Activity
import android.content.Context
import com.grayherring.kotlintest.dagger.PerActivity
import dagger.Module
import dagger.Provides

@Module
class HomeModule(private val activity: HomeActivity) {


  @Provides @PerActivity internal fun provideContext(): Context = activity

  @Provides @PerActivity internal fun provideActivity(): Activity = activity

  @Provides @PerActivity internal fun provideHomeView(): HomeView = activity

  //  @Provides @PerActivity internal fun provideHomeVM(swagApiClient: SwagApiClient,
  //                                                    bookRelay: BehaviorRelay<Book>,
  //                                                    homeUIView: HomeView): HomeVM {
  //    return HomeVM(swagApiClient, bookRelay, homeUIView)
  //  }

  @Provides @PerActivity internal fun provideAdapter(homeView: HomeVM): BookAdapter {
    return BookAdapter(homeView)
  }

}