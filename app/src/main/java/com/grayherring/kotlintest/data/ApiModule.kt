package com.grayherring.kotlintest.data

import com.grayherring.kotlintest.BuildConfig
import com.grayherring.kotlintest.SwagExceptionInterceptor
import com.grayherring.kotlintest.dagger.PerApp
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class ApiModule {
    @Provides @PerApp internal fun provideApiClient(
            client: OkHttpClient,
            swagApiExceptionInterceptor: SwagExceptionInterceptor,
            swagApiInterceptor: SwagApiInterceptor): OkHttpClient {
        val clientBuilder = client.newBuilder()
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(httpLoggingInterceptor)
        }
//        clientBuilder.addNetworkInterceptor(swagApiInterceptor)
//        clientBuilder.addInterceptor(motelSixApiExceptionInterceptor)
        return clientBuilder.build()
    }

    @Provides @PerApp internal fun provideHttpUrl(): HttpUrl {
        return HttpUrl.parse("http://prolific-interview.herokuapp.com/56609f690c33f80009dde7e5/")
    }

    @Provides @PerApp internal fun provideSwagApi(retrofit: Retrofit): SwagApi {
        return retrofit.create(SwagApi::class.java)
    }

    @Provides @PerApp internal fun provideMotelSixApiClient(swagApi: SwagApi): SwagApiClient {
        return SwagApiClient(swagApi)
    }

    @Provides @PerApp internal fun provideRetrofit(
            baseUrl: HttpUrl,
            client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

}

