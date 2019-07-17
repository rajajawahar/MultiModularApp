package com.tarkalabs.core.di.module;

import android.content.Context;
import com.tarkalabs.core.app.AppPreference;
import dagger.Module;
import dagger.Provides;

@Module
public class AppPreferencesModule {

    @Provides
    AppPreference providesAppPreferences(Context context) {
        return new AppPreference(context);
    }
}
