package com.example.kuliza332.daggertut.mainActivity;

import com.example.kuliza332.daggertut.BaseMvpView;
import com.example.kuliza332.daggertut.BasePresenter;
import com.example.kuliza332.daggertut.model.FollowersProfile;

import java.util.ArrayList;

/**
 * Created by kuliza332 on 08/01/18.
 */

public interface MainActivityContract {

    interface View extends BaseMvpView{
        void initializeData(ArrayList<FollowersProfile> followersProfileArrayList);
    }

    interface Presenter extends BasePresenter {
        void onSetUp();
    }
}
