package com.example.kuliza332.daggertut;

import android.app.Activity;
import android.app.Application;

import com.example.kuliza332.daggertut.components.ApplicationComponent;
import com.example.kuliza332.daggertut.components.DaggerApplicationComponent;
import com.example.kuliza332.daggertut.modules.ContextModule;

/**
 * Created by kuliza332 on 05/01/18.
 */

public class DaggerApplication extends Application {

    private ApplicationComponent applicationComponent;

    public static DaggerApplication get(Activity activity) {
        return (DaggerApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
