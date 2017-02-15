package com.grayherring.kotlintest.ui.update

import com.grayherring.kotlintest.dagger.PerActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = arrayOf(UpdateModule::class))
interface UpdateComponent {
  fun inject(activity: UpdateActivity)
  fun inject(updateVM: UpdateVM)

}

