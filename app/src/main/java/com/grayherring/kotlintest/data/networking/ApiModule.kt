package com.grayherring.kotlintest.data.networking

import com.grayherring.kotlintest.BuildConfig
import com.grayherring.kotlintest.ExceptionInterceptor
import com.grayherring.kotlintest.dagger.PerApp
import com.grayherring.kotlintest.dagger.Qualifiers.API
import com.grayherring.kotlintest.data.SwagApi
import com.grayherring.kotlintest.data.SwagApiClient
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class ApiModule {

    @Provides @PerApp fun provideOkHttpClient(swagApiInterceptor: ExceptionInterceptor): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(httpLoggingInterceptor)
        }
        clientBuilder.addInterceptor(swagApiInterceptor)
        return clientBuilder.build()
    }

    @Provides @PerApp fun provideExceptionInterceptor(): ExceptionInterceptor = ExceptionInterceptor()

    @Provides @PerApp fun provideHttpUrl(): HttpUrl
            = HttpUrl.parse("http://prolific-interview.herokuapp.com/56609f690c33f80009dde7e5/")

    @Provides @PerApp @API fun provideSwagApi(retrofit: Retrofit): SwagApi
            = retrofit.create(SwagApi::class.java)

    @Provides @PerApp fun provideSwagApiClient(@API swagApi: SwagApi) = SwagApiClient(swagApi)

    @Provides @PerApp fun provideRetrofit(baseUrl: HttpUrl, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }

}
