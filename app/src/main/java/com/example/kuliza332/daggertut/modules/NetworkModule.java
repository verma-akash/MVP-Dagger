package com.example.kuliza332.daggertut.modules;

import com.example.kuliza332.daggertut.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by kuliza332 on 07/01/18.
 */

@Module
public class NetworkModule {

    @Provides
    @ApplicationScope
    public OkHttpClient getOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    @ApplicationScope
    public HttpLoggingInterceptor getHttpLogginfInterceptor(){
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {

            }
        });
    }
}
