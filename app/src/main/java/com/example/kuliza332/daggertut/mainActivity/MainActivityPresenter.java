package com.example.kuliza332.daggertut.mainActivity;

import android.util.Log;

import com.example.kuliza332.daggertut.BaseMvpView;
import com.example.kuliza332.daggertut.model.FollowersProfile;
import com.example.kuliza332.daggertut.network.ApiHelperService;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kuliza332 on 08/01/18.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;

    ApiHelperService apiHelper;

    @Inject
    public MainActivityPresenter(ApiHelperService apiHelper) {
        this.apiHelper = apiHelper;
    }

    @Override
    public void onAttach(BaseMvpView v) {
        if (v != null)
            this.view = (MainActivityContract.View) v;
    }

    @Override
    public void onDetach() {
        if (apiHelper != null) {
            apiHelper.getFollowers().cancel();
        }

        this.view = null;
    }

    @Override
    public void onSetUp() {
        view.showLoading();
        apiHelper.getFollowers().enqueue(new Callback<ArrayList<FollowersProfile>>() {
            @Override
            public void onResponse(Call<ArrayList<FollowersProfile>> call, Response<ArrayList<FollowersProfile>> response) {
                view.hideLoading();
                view.initializeData(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<FollowersProfile>> call, Throwable t) {
                Log.e("Retro Error", t.toString());
            }
        });
    }
}
