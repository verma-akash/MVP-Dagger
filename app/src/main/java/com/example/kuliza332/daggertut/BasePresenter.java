package com.example.kuliza332.daggertut;

import android.view.View;

/**
 * Created by kuliza332 on 17/01/18.
 */

public interface BasePresenter{

    void onAttach(BaseMvpView v);

    void onDetach();
}
