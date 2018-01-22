package com.example.kuliza332.daggertut.mainActivity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.example.kuliza332.daggertut.R;
import com.example.kuliza332.daggertut.model.FollowersProfile;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kuliza332 on 07/01/18.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileHolder>{

    private Context context;
    private ArrayList<FollowersProfile> followersProfileArrayList;
    private RequestManager glide;

    @Inject
    public ProfileAdapter(MainActivity context, RequestManager glide) {
        this.context = context;
        this.glide = glide;
    }

    public void setFollowersProfileArrayList(ArrayList<FollowersProfile> followersProfileArrayList) {
        this.followersProfileArrayList = followersProfileArrayList;
    }

    @Override
    public ProfileHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_profile_holder, parent, false);
        return new ProfileHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileHolder holder, int position) {
        glide.load(followersProfileArrayList.get(position).getAvatarUrl())
                .into(holder.profilePic);
        holder.profileId.setText(followersProfileArrayList.get(position).getLogin());
    }

    @Override
    public int getItemCount() {
        return followersProfileArrayList.size();
    }

    public class ProfileHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.profilePic)
        public ImageView profilePic;
        @BindView(R.id.profileId)
        public TextView profileId;

        public ProfileHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
