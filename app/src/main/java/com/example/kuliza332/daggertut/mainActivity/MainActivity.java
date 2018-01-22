package com.example.kuliza332.daggertut.mainActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.kuliza332.daggertut.DaggerApplication;
import com.example.kuliza332.daggertut.R;
import com.example.kuliza332.daggertut.components.DaggerMainActivityComponent;
import com.example.kuliza332.daggertut.components.MainActivityComponent;
import com.example.kuliza332.daggertut.model.FollowersProfile;
import com.example.kuliza332.daggertut.model.MainActivityModule;
import com.example.kuliza332.daggertut.network.ApiHelperService;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    @Inject
    ProfileAdapter profileAdapter;

    private ArrayList<FollowersProfile> followersProfileArrayList = new ArrayList<>();

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;

    @BindView(R.id.progressBar)
    public ProgressBar progressBar;

    @BindView(R.id.mainContainer)
    LinearLayout mainContainer;

    @Inject
    MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MainActivityComponent mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .applicationComponent(DaggerApplication.get(this).getComponent())
                .build();
        mainActivityComponent.inject(this);

        profileAdapter.setFollowersProfileArrayList(followersProfileArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(profileAdapter);

        mainActivityPresenter.onAttach(this);
        mainActivityPresenter.onSetUp();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainActivityPresenter.onDetach();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        mainContainer.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        mainContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void initializeData(ArrayList<FollowersProfile> followersProfileArrayList) {
        this.followersProfileArrayList.addAll(followersProfileArrayList);
        profileAdapter.notifyDataSetChanged();
    }
}
