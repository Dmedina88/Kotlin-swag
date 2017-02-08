package com.grayherring.kotlintest.data.networking

import com.grayherring.kotlintest.data.modul.Book
import retrofit2.Response
import retrofit2.http.*
import rx.Observable


/**
 * Created by davidmedina on 2/5/17 =).
 */
//http://prolific-interview.herokuapp.com/56609f690c33f80009dde7e5/
interface SwagApi {


    @GET("books")
    fun getBooks(): Observable<Array<Book>>

    @DELETE("clean/")
    fun deleteAllBooks(): Observable<Response<String>>

    @DELETE("{url}")
    fun deleteBook(@Path("url") url: String): Observable<Response<String>>

    @FormUrlEncoded
    @GET("{url}")
    fun getBook(@Path("url") url: String): Observable<Book>

    @FormUrlEncoded
    @POST("books")
    fun postBook(@FieldMap params: Map<String, String>): Observable<Book>

    @FormUrlEncoded
    @PUT("{url}")
    fun checkOutBook(@Path(value = "url") url: String, @Field("lastCheckedOutBy") lastCheckedOutBy: String): Observable<Book>

    @FormUrlEncoded
    @PUT("{url}")
    fun updateBook(@Path(value = "url") url: String, @Body book: Book): Observable<Book>

}




