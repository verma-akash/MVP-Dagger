package com.example.kuliza332.daggertut.components;

import com.bumptech.glide.RequestManager;
import com.example.kuliza332.daggertut.DaggerApplication;
import com.example.kuliza332.daggertut.modules.ActivityModule;
import com.example.kuliza332.daggertut.modules.ApiHelperServiceModule;
import com.example.kuliza332.daggertut.modules.GlideModule;
import com.example.kuliza332.daggertut.network.ApiHelperService;
import com.example.kuliza332.daggertut.scopes.ApplicationScope;

import dagger.Component;

/**
 * Created by kuliza332 on 07/01/18.
 */

@ApplicationScope
@Component(modules = {ApiHelperServiceModule.class, GlideModule.class, ActivityModule.class})
public interface ApplicationComponent {

    ApiHelperService getApiHelperService();

    RequestManager getGlide();

    void inject(DaggerApplication daggerApplication);

}
