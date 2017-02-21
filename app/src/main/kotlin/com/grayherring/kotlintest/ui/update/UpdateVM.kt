package com.grayherring.kotlintest.ui.update

import com.grayherring.kotlintest.dagger.PerActivity
import com.grayherring.kotlintest.data.modul.Book
import com.grayherring.kotlintest.data.networking.SwagApiClient
import com.grayherring.kotlintest.ui.base.BaseVM
import com.grayherring.kotlintest.util.ErrorHandler
import com.grayherring.kotlintest.util.applySchedulers
import com.jakewharton.rxbinding.widget.textChanges
import rx.Observable
import rx.lang.kotlin.combineLatest
import rx.lang.kotlin.onError
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject
import kotlin.properties.Delegates
import kotlin.reflect.KProperty


/**
 * Created by David Medina.
 */
@PerActivity
class UpdateVM @Inject constructor(val swagApiClient: SwagApiClient,
                                   var book: Book,
                                   val updateView: UpdateView,
                                   errorHandler: ErrorHandler) : BaseVM(errorHandler) {

  private val composite = CompositeSubscription()
  private var updateUI: UpdateUI? = null

  var loading = false
    private set

  var lock by Delegates.observable(false) { kProperty: KProperty<*>,
                                            oldVale: Boolean,
                                            newVale: Boolean ->
    if (oldVale != newVale) {
      updateUI?.notifyLock()
    }
  }

  fun updateBooks() {
    loading = true
    updateUI?.notifyChanges()
    if (book.id != -1) {
      composite.add(
          swagApiClient.updateBook(book.url, book)
              .applySchedulers()
              .subscribe({
                           book = it
                           loading = false
                           updateUI?.notifyChanges()
                           updateView.done()
                         }, {
                           loading = false
                           updateView.showError(
                               it.toString())
                           this.logError(it)
                           updateUI?.notifyChanges()
                           logError(it)
                         })
      )
    } else {
      composite.add(
          swagApiClient
              .postBook(book)
              .applySchedulers()
              .subscribe({ newBook ->
                           book = newBook
                           updateView.done()
                           loading = false
                           updateUI?.notifyChanges()
                         }, { error ->
                           error?.message
                           loading = false
                           updateView.showError(error.toString())
                           this.logError(error)
                           updateUI?.notifyChanges()
                         })

      )
    }

  }

  fun copyBook() {
    // book = book.copy(id = -1)

    book = book.copy(
        id = -1,
        lastCheckedOut = "",
        lastCheckedOutBy = ""
    )

    updateBooks()
  }

  override fun onDestroy() {
    composite.unsubscribe()
  }

  fun addLockScreenObservables(vararg observables: Observable<CharSequence>) {
    val isEmptyObservable = observables
        .asList()
        .combineLatest({ it })
    isEmptyObservable
        .map { notEmpty(it) }
        .onError { this.logError(it) }
        .subscribe {
          lock = !it
        }
  }

  fun notEmpty(values: List<CharSequence>): Boolean {
    return values.all { it.isNotEmpty() }
  }

  fun setBindings(binding: UpdateUI) {
    this.updateUI = binding
    with(binding) {
      addLockScreenObservables(auther.textChanges(),
                               title.textChanges(),
                               categories.textChanges(),
                               publisher.textChanges())
    }
  }

}



