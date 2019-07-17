package com.tarkalabs.core.di.component;

import android.app.Application;
import android.content.Context;
import com.mobieadz.foodstories.di.module.ApplicationModule;
import dagger.Component;

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Application getApplication();

    Context getContext();

}
