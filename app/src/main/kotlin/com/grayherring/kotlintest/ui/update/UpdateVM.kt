package com.grayherring.kotlintest.ui.update

import com.grayherring.kotlintest.dagger.PerActivity
import com.grayherring.kotlintest.data.modul.Book
import com.grayherring.kotlintest.data.networking.SwagApiClient
import com.grayherring.kotlintest.ui.base.BaseVM
import com.grayherring.kotlintest.util.ErrorHandler
import com.grayherring.kotlintest.util.applySchedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject


/**
 * Created by David Medina.
 */
@PerActivity
class UpdateVM @Inject constructor(val swagApiClient: SwagApiClient,
                                   var book: Book,
                                   val updateView: UpdateView,
                                   errorHandler: ErrorHandler) : BaseVM(errorHandler) {

  private val composite = CompositeSubscription()

  var loading = true
    private set

  fun updateBooks() {
    loading = true
    notifyChange()
    if (book.id != -1) {
      composite.add(
          swagApiClient.updateBook(book.url, book).applySchedulers().subscribe({
            book = it
            loading = false
            updateView.done()
            notifyChange()
          }, {
            loading = false
            updateView.showError(it.toString())
            this.logError(it)
            notifyChange()
            logError(it)
          })
      )
    } else {
      composite.add(
          swagApiClient.postBook(book).applySchedulers().subscribe({ newBook ->
            book = newBook
            updateView.done()
            loading = false
            notifyChange()
          }, { error ->
            error?.message
            loading = false
            updateView.showError(error.toString())
            this.logError(error)
            notifyChange()
          })

      )
    }

  }

  fun copyBook() {
    // book = book.copy(id = -1)
    book = book.copy(id = -1, lastCheckedOut = "", lastCheckedOutBy = "")

    val book2 = Book( "text", " test", "test", publisher = "david" )

    var book3 = book2 + book

    var book4 = book2 xx book

    updateBooks()
  }

  override fun onDestroy() {
    composite.unsubscribe()
  }

}



