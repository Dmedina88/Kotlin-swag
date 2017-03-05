package com.grayherring.kotlintest.ui.home

import android.os.Bundle
import com.grayherring.kotlintest.dagger.Injector
import com.grayherring.kotlintest.data.modul.Book
import com.grayherring.kotlintest.ui.base.BaseActivity
import com.grayherring.kotlintest.ui.base.toast
import com.grayherring.kotlintest.ui.update.UpdateActivity
import org.jetbrains.anko.setContentView
import timber.log.Timber
import javax.inject.Inject


class HomeActivity : BaseActivity(), HomeView {

  private lateinit var component: HomeComponent
  lateinit var homeUIView: HomeUI
  @Inject lateinit var homeVM: HomeVM

  override fun initializeDependencyInjector() {
    component = getAppComponent().plus(HomeModule(this))
    component.inject(this)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    homeVM.onCreate()
    homeUIView = HomeUI(homeVM)
    homeUIView.setContentView(this)
    this.addBindable(homeVM)
    this.toast("TOASTY!")
  }

  override fun getSystemService(name: String): Any {
    if (Injector.matchesService(name, HomeComponent::class.java)) {
      return component
    }
    return super.getSystemService(name)
  }

  override fun showError(error: String) {
    this.toast(error)
  }

  override fun showUpdates() {
    homeUIView.recyclerView.adapter.notifyDataSetChanged()
  }

  override fun startEdit(book: Book) {
    Timber.i("### start edit %s", book.toString())
    UpdateActivity.start(this, book)
  }

}

