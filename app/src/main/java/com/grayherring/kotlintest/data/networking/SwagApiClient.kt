package com.grayherring.kotlintest.data

import com.grayherring.kotlintest.data.modul.Book
import com.grayherring.kotlintest.util.applySchedulers
import retrofit2.Response
import rx.Observable


/**
 * Created by davidmedina on 2/5/17 =).
 */
class SwagApiClient(val swagApi: SwagApi) : SwagApi {

    override fun getBooks(): Observable<Array<Book>> {
        return swagApi.getBooks().applySchedulers()
    }

    override fun deleteAllBooks(): Observable<Response<String>> {
        return swagApi.deleteAllBooks().applySchedulers()
    }

    override fun deleteBook(url: String): Observable<Response<String>> {
        return swagApi.deleteBook(url).applySchedulers()
    }

    override fun getBook(url: String): Observable<Book> {
        return swagApi.getBook(url).applySchedulers()
    }

    override fun postBook(params: Map<String, String>): Observable<Book> {
        return swagApi.postBook(params).applySchedulers()
    }

    override fun checkOutBook(url: String, lastCheckedOutBy: String): Observable<Book> {
        return swagApi.checkOutBook(url, lastCheckedOutBy).applySchedulers()
    }

    override fun updateBook(url: String, params: Map<String, String>): Observable<Book> {
        return swagApi.updateBook(url, params).applySchedulers()
    }

}