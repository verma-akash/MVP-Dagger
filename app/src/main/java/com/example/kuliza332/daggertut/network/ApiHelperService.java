package com.example.kuliza332.daggertut.network;

import com.example.kuliza332.daggertut.model.FollowersProfile;
import com.example.kuliza332.daggertut.model.GitProfile;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by kuliza332 on 05/01/18.
 */

public interface ApiHelperService {

    @GET("{userId}")
    Call<GitProfile> getGitUserProfile(@Path("userId") String userId);

    @GET("followers")
    Call<ArrayList<FollowersProfile>> getFollowers();
}
