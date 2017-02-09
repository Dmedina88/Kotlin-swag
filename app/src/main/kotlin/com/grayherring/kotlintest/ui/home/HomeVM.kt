package com.grayherring.kotlintest.ui.home

import com.grayherring.kotlintest.dagger.PerActivity
import com.grayherring.kotlintest.data.modul.Book
import com.grayherring.kotlintest.data.networking.SwagApiClient
import com.grayherring.kotlintest.ui.base.BaseVM
import rx.subscriptions.CompositeSubscription
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by davidmedina on 2/8/17 =).
 */
@PerActivity
class HomeVM @Inject constructor(val swagApiClient: SwagApiClient) : BaseVM() {

    var composite = CompositeSubscription()

    val books = arrayListOf<Book>()
        get



    fun refreshBooks() {
        composite.add(
                swagApiClient.getBooks().subscribe({ books ->
                    this.books.clear()
                    this.books.addAll(books)
                    Timber.i("###  all %s", this.books.toString())
                }, { error -> this.logError(error) })
        )
    }

    override fun onDestroy() {
        composite.unsubscribe()
    }

    override fun onCreate() {
        refreshBooks()
    }


}



