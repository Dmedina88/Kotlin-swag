package com.grayherring.kotlintest.ui.home

import com.grayherring.kotlintest.dagger.PerActivity
import com.grayherring.kotlintest.data.modul.Book
import com.grayherring.kotlintest.data.networking.SwagApiClient
import com.grayherring.kotlintest.ui.base.BaseVM
import rx.subscriptions.CompositeSubscription
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by David Medina.
 */
@PerActivity
class HomeVM @Inject constructor(val swagApiClient: SwagApiClient) : BaseVM() {

  val composite = CompositeSubscription()

  val books = arrayListOf<Book>()
    get

  var loading = true
    private set

  fun refreshBooks() {
    composite.add(
        swagApiClient.getBooks().subscribe({ books ->
          loading = false
          this.books.clear()
          this.books.addAll(books)
          Timber.i("###  all %s", this.books.toString())
          notifyChange()
        }, { error ->
          loading = false
          this.logError(error)
          notifyChange()
        })
    )
  }

  override fun onDestroy() {
    composite.unsubscribe()
  }

  override fun onCreate() {
    refreshBooks()
  }

}



