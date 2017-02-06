package com.grayherring.kotlintest.ui.home

import android.os.Bundle
import com.grayherring.kotlintest.R
import com.grayherring.kotlintest.SwagApp
import com.grayherring.kotlintest.dagger.Injector
import com.grayherring.kotlintest.dagger.PerApp
import com.grayherring.kotlintest.data.SwagApiClient
import com.grayherring.kotlintest.ui.base.BaseActivity
import timber.log.Timber
import javax.inject.Inject

class HomeActivity : BaseActivity() {
    private lateinit var component: HomeComponent

    @Inject @PerApp
    lateinit var swagApiClient: SwagApiClient

    override fun initializeDependencyInjector() {
        component = (this.application as SwagApp)
                .getComponent()
                .plus(HomeModule(this))
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        swagApiClient.getBooks().subscribe({ books -> Timber.i(books.toString()) },
                { error -> this.logError(error) })

    }

    override fun getSystemService(name: String): Any {
        if (Injector.matchesService(name, HomeComponent::class.java)) {
            return component
        }
        return super.getSystemService(name)
    }

}

