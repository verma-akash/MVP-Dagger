package com.example.kuliza332.daggertut.modules;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.kuliza332.daggertut.qualifiers.ApplicationContextQualifier;
import com.example.kuliza332.daggertut.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kuliza332 on 07/01/18.
 */

@Module(includes = ContextModule.class)
public class GlideModule {

    @Provides
    @ApplicationScope
    public RequestManager getGlideRequestManager(@ApplicationContextQualifier Context context){
        return Glide.with(context);
    }
}
