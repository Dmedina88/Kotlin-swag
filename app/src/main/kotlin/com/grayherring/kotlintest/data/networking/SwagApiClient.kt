package com.grayherring.kotlintest.data.networking

import com.grayherring.kotlintest.data.modul.Book
import com.grayherring.kotlintest.util.applySchedulers
import rx.Observable


/**
 * Created by David Medina.
 */
class SwagApiClient(private var swagApi: SwagApi) : SwagApi by swagApi {

  override fun updateBook(url: String, book: Book): Observable<Book> {
    return swagApi.updateBook(url.replaceFirst("/", ""), book).applySchedulers()
  }

}