package com.tarkalabs.core.di.component;

import com.tarkalabs.core.app.AppPreference;
import com.tarkalabs.core.di.module.AppPreferencesModule;
import dagger.Component;

@Component(modules = AppPreferencesModule.class, dependencies = ApplicationComponent.class)
public interface AppPreferencesComponent {

    AppPreference getAppPreference();
}
