package com.grayherring.kotlintest.ui.update

import com.grayherring.kotlintest.dagger.PerActivity
import com.grayherring.kotlintest.data.modul.Book
import com.grayherring.kotlintest.data.networking.SwagApiClient
import com.grayherring.kotlintest.ui.base.BaseVM
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
          swagApiClient.updateBook(book.url, book).subscribe({ newBook ->
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
          swagApiClient.postBook(book).subscribe({ newBook ->
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

  override fun onDestroy() {
    composite.unsubscribe()
  }

}



