package com.example.kuliza332.daggertut.modules;

import android.content.Context;

import com.example.kuliza332.daggertut.qualifiers.ApplicationContextQualifier;
import com.example.kuliza332.daggertut.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kuliza332 on 07/01/18.
 */

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    @ApplicationScope
    @ApplicationContextQualifier
    public Context context() {
        return context;
    }
}
