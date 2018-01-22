package com.example.kuliza332.daggertut.model;

import com.example.kuliza332.daggertut.mainActivity.MainActivity;
import com.example.kuliza332.daggertut.scopes.MainActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kuliza332 on 07/01/18.
 */

@Module
public class MainActivityModule {

    private final MainActivity context;

    public MainActivityModule(MainActivity context) {
        this.context = context;
    }

    @Provides
    @MainActivityScope
    public MainActivity mainActivity() {
        return context;
    }
}
