package com.example.kuliza332.daggertut.components;

import com.example.kuliza332.daggertut.mainActivity.MainActivity;
import com.example.kuliza332.daggertut.model.MainActivityModule;
import com.example.kuliza332.daggertut.scopes.MainActivityScope;

import dagger.Component;

/**
 * Created by kuliza332 on 07/01/18.
 */

@MainActivityScope
@Component(dependencies = ApplicationComponent.class, modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}
