package com.grayherring.kotlintest.ui.home

import com.grayherring.kotlintest.dagger.PerActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = arrayOf(HomeModule::class))
interface HomeComponent {
  fun inject(activity: HomeActivity)
  fun inject(homeVM: HomeVM)

}

