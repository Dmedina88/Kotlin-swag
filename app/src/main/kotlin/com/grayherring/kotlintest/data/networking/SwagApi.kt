package com.grayherring.kotlintest.data.networking

import com.grayherring.kotlintest.data.modul.Book
import retrofit2.Response
import retrofit2.http.*
import rx.Observable


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

  @POST("books")
  fun postBook(@Body book: Book): Observable<Book>

  @FormUrlEncoded
  @PUT("{url}")
  fun checkOutBook(@Path(value = "url") url: String, @Field("lastCheckedOutBy") lastCheckedOutBy: String): Observable<Book>

  @PUT("{url}")
  fun updateBook(@Path(value = "url") url: String, @Body book: Book): Observable<Book>

}




