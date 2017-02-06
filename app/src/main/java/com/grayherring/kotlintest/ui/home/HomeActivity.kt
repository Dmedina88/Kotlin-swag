package com.grayherring.kotlintest.ui.home

import android.os.Bundle
import com.grayherring.kotlintest.R
import com.grayherring.kotlintest.SwagApp
import com.grayherring.kotlintest.dagger.Injector
import com.grayherring.kotlintest.ui.base.BaseActivity

class HomeActivity : BaseActivity() {
    private var component: HomeComponent? = null

    override fun initializeDependencyInjector() {
        component = (this.application as SwagApp)
                .getComponent()
                .plus(HomeModule(this))
        component?.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    }

   override fun getSystemService(name: String): Any {
        if (Injector.matchesService(name, HomeComponent::class.java)) {
            return component!!
        }
        return super.getSystemService(name)
    }

}

