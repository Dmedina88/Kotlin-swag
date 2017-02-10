package com.grayherring.kotlintest.ui.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.grayherring.kotlintest.R
import com.grayherring.kotlintest.dagger.Injector
import com.grayherring.kotlintest.databinding.ActivityHomeBinding
import com.grayherring.kotlintest.ui.base.BaseActivity
import javax.inject.Inject


class HomeActivity : BaseActivity() {
  private lateinit var component: HomeComponent
  private lateinit var binding: ActivityHomeBinding
  @Inject lateinit var homeVM: HomeVM

  override fun initializeDependencyInjector() {
    component = getAppComponent().plus(HomeModule(this))
    component.inject(this)
    component.inject(homeVM)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)

    homeVM.onCreate()
    this.addBindable(homeVM)
  }

  override fun getSystemService(name: String): Any {
    if (Injector.matchesService(name, HomeComponent::class.java)) {
      return component
    }
    return super.getSystemService(name)
  }

}

