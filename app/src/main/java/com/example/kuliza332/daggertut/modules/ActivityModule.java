package com.example.kuliza332.daggertut.modules;

import android.app.Activity;
import android.content.Context;

import com.example.kuliza332.daggertut.scopes.ApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kuliza332 on 07/01/18.
 */

@Module
public class ActivityModule {

    private final Context context;

    public ActivityModule(Activity context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @Named("activity_context")
    public Context getActivityContext(){
        return context;
    }
}
