package com.tarkalabs.core.di.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tarkalabs.core.app.ApiConstants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    private val TAG = RepositoryModule::class.java.simpleName

    @Provides
    @Singleton
    @Named("Gson")
    fun providesGson(): Gson {
        return GsonBuilder()
            .setDateFormat(ApiConstants.API_DATE_FORMAT)
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .serializeNulls()
            .create()
    }

    @Provides
    @Singleton
    internal fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Provides
    @Singleton
    @Named("BaseOkHttp")
    fun providesBaseOkHttpClient(logger: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(logger)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }


    @Provides
    @Singleton
    @Named("MaxOkHttp")
    fun providesMaxOkHttpClient(
        @Named("BaseOkHttp") okHttpClient: OkHttpClient,
        logger: HttpLoggingInterceptor
    ): OkHttpClient {
        return okHttpClient.newBuilder()
            .addInterceptor(logger)
            .build()
    }

}