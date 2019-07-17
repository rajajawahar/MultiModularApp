package com.mobieadz.foodstories.di.module

import android.app.Application
import android.content.Context
import com.tarkalabs.core.app.AppPreference
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    private val application: Application

    constructor(application: Application) {
        this.application = application
    }

    @Provides
    fun providesApplication(): Application {
        return application
    }

    @Provides
    fun providesContext(): Context {
        return application
    }

    @Provides
    fun providesAppPreferences(context: Context): AppPreference {
        return AppPreference(context)
    }
}