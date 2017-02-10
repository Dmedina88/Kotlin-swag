package com.grayherring.kotlintest.ui.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.grayherring.kotlintest.R
import com.grayherring.kotlintest.dagger.Injector
import com.grayherring.kotlintest.data.modul.Book
import com.grayherring.kotlintest.databinding.ActivityHomeBinding
import com.grayherring.kotlintest.ui.base.BaseActivity
import com.grayherring.kotlintest.ui.base.toast
import com.grayherring.kotlintest.ui.update.UpdateActivity
import timber.log.Timber
import javax.inject.Inject


class HomeActivity : BaseActivity(), HomeView {

  private lateinit var component: HomeComponent
  private lateinit var binding: ActivityHomeBinding
  @Inject lateinit var homeVM: HomeVM
  @Inject lateinit var bookAdapter: BookAdapter

  override fun initializeDependencyInjector() {
    component = getAppComponent().plus(HomeModule(this))
    component.inject(this)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
    binding.vm = homeVM
    binding.recyclerView.layoutManager = LinearLayoutManager(this)
    binding.recyclerView.adapter = bookAdapter
    homeVM.onCreate()
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
    binding.recyclerView.adapter.notifyDataSetChanged()
  }

  override fun startEdit(book: Book) {
    Timber.i("### start edit %s", book.toString())
    UpdateActivity.start(this,book)
  }

}

