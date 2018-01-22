package com.example.kuliza332.daggertut.modules;

import com.example.kuliza332.daggertut.network.ApiHelperService;
import com.example.kuliza332.daggertut.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kuliza332 on 07/01/18.
 */

@Module(includes = NetworkModule.class)
public class ApiHelperServiceModule {

    @Provides
    @ApplicationScope
    public ApiHelperService getApiHelperService(Retrofit retrofit){
        return retrofit.create(ApiHelperService.class);
    }

    @Provides
    @ApplicationScope
    public Retrofit getRetroFit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/users/verma-akash/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
