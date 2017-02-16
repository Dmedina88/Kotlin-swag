package com.grayherring.kotlintest.data.networking

import android.content.Context
import com.grayherring.kotlintest.data.modul.Book
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import retrofit2.Response
import rx.Observable


/**
 * Created by davidmedina on 2/15/17 =).
 */
class MockSwag(val moshi: Moshi, val context: Context) : SwagApi {

  val mockGetBooksData: List<Book> by lazy {
    val input = context.assets.open("books.json")
    val size = input.available()
    val buffer = ByteArray(size)
    input.read(buffer)
    input.close()
    val json = String(buffer)
    moshi.adapter<List<Book>>(Types.newParameterizedType(List::class.java,
                                                         Book::class.java))
        .fromJson(json)
  }

  override fun getBooks(): Observable<List<Book>> {
    return Observable.just(mockGetBooksData)
  }

  override fun deleteAllBooks(): Observable<Response<String>> {
    return Observable.just(Response.success("success"))
  }

  override fun deleteBook(url: String): Observable<Response<String>> {
    return Observable.just(Response.success("success"))
  }

  override fun getBook(url: String): Observable<Book> {
    return Observable.just(mockGetBooksData[1])
  }

  override fun postBook(book: Book): Observable<Book> {
    return Observable.just(book)
  }

  override fun checkOutBook(url: String, lastCheckedOutBy: String): Observable<Book> {
    return Observable.just(mockGetBooksData[1])
  }

  override fun updateBook(url: String, book: Book): Observable<Book> {
    return Observable.just(book)
  }
}