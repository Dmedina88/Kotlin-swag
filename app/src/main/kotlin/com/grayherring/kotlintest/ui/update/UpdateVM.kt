package com.grayherring.kotlintest.ui.update

import com.grayherring.kotlintest.dagger.PerActivity
import com.grayherring.kotlintest.data.modul.Book
import com.grayherring.kotlintest.data.networking.SwagApiClient
import com.grayherring.kotlintest.ui.base.BaseVM
import com.grayherring.kotlintest.util.applySchedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject


/**
 * Created by David Medina.
 */
@PerActivity
class UpdateVM @Inject constructor(val swagApiClient: SwagApiClient,
                                   var book: Book,
                                   val updateView: UpdateView) : BaseVM() {

  private val composite = CompositeSubscription()

  var loading = true
    private set

  fun updateBooks() {
    loading = true
    notifyChange()
    if (book.id != -1) {
      composite.add(
          swagApiClient.updateBook(book.url, book).applySchedulers().subscribe({ newBook ->
            book = newBook
            loading = false
            updateView.done()
            notifyChange()
          }, { error ->
            loading = false
            updateView.showError(error.toString())
            this.logError(error)
            notifyChange()
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
    updateBooks()
  }

  override fun onDestroy() {
    composite.unsubscribe()
  }

}



