package com.grayherring.kotlintest.data

import com.grayherring.kotlintest.BuildConfig
import com.grayherring.kotlintest.dagger.PerApp
import com.grayherring.kotlintest.dagger.Qualifiers.API
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

    //todo inject later
//            swagApiExceptionInterceptor: SwagExceptionInterceptor,
//           swagApiInterceptor: SwagApiInterceptor
    @Provides @PerApp fun provideOkHttpClient()
            : OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(httpLoggingInterceptor)
        }
//        clientBuilder.addNetworkInterceptor(swagApiInterceptor)
//        clientBuilder.addInterceptor(motelSixApiExceptionInterceptor)
        return clientBuilder.build()
    }

    @Provides @PerApp fun provideHttpUrl(): HttpUrl
            = HttpUrl.parse("http://prolific-interview.herokuapp.com/56609f690c33f80009dde7e5/")

    @Provides @PerApp @API fun provideSwagApi(retrofit: Retrofit): SwagApi
            = retrofit.create(SwagApi::class.java)

    @Provides @PerApp fun provideSwagApiClient(@API swagApi: SwagApi) = SwagApiClient(swagApi)

    @Provides @PerApp fun provideRetrofit(
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

