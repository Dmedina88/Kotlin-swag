package com.grayherring.kotlintest.ui.home

import com.grayherring.kotlintest.dagger.PerActivity
import com.grayherring.kotlintest.data.modul.Book
import com.grayherring.kotlintest.data.networking.SwagApiClient
import com.grayherring.kotlintest.ui.base.BaseVM
import com.grayherring.kotlintest.util.ErrorHandler
import com.grayherring.kotlintest.util.applySchedulers
import com.jakewharton.rxrelay2.BehaviorRelay
import rx.subscriptions.CompositeSubscription
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by David Medina.
 */
@PerActivity
class HomeVM @Inject constructor(val swagApiClient: SwagApiClient,
                                 val bookRelay: BehaviorRelay<Book>,
                                 val homeView: HomeView,
                                 errorHandler: ErrorHandler) : BaseVM(errorHandler) {

  val composite = CompositeSubscription()

  val books = arrayListOf<Book>()
    get

  var loading = false
    private set

  fun refreshBooks() {
    loading = true
    notifyChange()
    composite.add(
        swagApiClient.getBooks()
            .applySchedulers()
            .subscribe({ books ->
                         loading = false
                         this.books.clear()
                         this.books.addAll(books)
                         Timber.i("###  all %s",
                                  this.books.toString())
                         homeView.showUpdates()
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

  override fun onResume() {
    refreshBooks()
  }

  fun update(book: Book) {
    //  bookRelay.accept(book)
    homeView.startEdit(book)
  }

  fun newBook() {
    //  bookRelay.accept(book)
    homeView.startEdit(Book())
  }

}



