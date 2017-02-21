package com.grayherring.kotlintest.ui.update

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.grayherring.kotlintest.dagger.Injector
import com.grayherring.kotlintest.data.modul.Book
import com.grayherring.kotlintest.ui.base.BaseActivity
import com.grayherring.kotlintest.ui.base.toast
import com.grayherring.kotlintest.ui.update.UpdateModule.Companion.EXTRA_BOOK
import com.grayherring.kotlintest.util.applySchedulers
import com.jakewharton.rxbinding.widget.textChanges
import org.jetbrains.anko.setContentView
import rx.Observable
import rx.lang.kotlin.onError
import rx.subscriptions.CompositeSubscription
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class UpdateActivity : BaseActivity(), UpdateView {

  private val composite = CompositeSubscription()
  private lateinit var component: UpdateComponent
  @Inject lateinit var vm: UpdateVM

  override fun initializeDependencyInjector() {
    component = getAppComponent().plus(UpdateModule(this))
    component.inject(this)
    component.inject(vm)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = UpdateUI(vm)
    binding.setContentView(this)
    vm.setBindings(binding)
    vm.onCreate()

    this.addBindable(vm)
  }

  override fun getSystemService(name: String): Any {
    if (Injector.matchesService(name, UpdateComponent::class.java)) {
      return component
    }
    return super.getSystemService(name)
  }

  companion object {
    fun start(context: Context, book: Book) {
      val i = Intent(context, UpdateActivity::class.java)
      i.putExtra(EXTRA_BOOK, book)
      context.startActivity(i)
    }
  }

  override fun done() {
    this.toast("O yeaaaaaaa")
    composite.add(
        Observable.timer(500, TimeUnit.MILLISECONDS)
            .applySchedulers()
            .onError { error -> this.logError(error) }
            .subscribe { this.finish() }
    )
  }

  override fun showError(error: String) {
    this.toast(error)
  }

  override fun onDestroy() {
    composite.unsubscribe()
    super.onDestroy()
  }

}

