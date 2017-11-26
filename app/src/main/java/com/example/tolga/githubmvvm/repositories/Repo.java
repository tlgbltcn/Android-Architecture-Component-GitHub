package com.example.tolga.githubmvvm.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import com.example.tolga.githubmvvm.GitHubApi;
import com.example.tolga.githubmvvm.model.Repos;
import com.example.tolga.githubmvvm.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tolga on 23.11.2017.
 */

public class Repo implements GitHubRepo {

    private final GitHubApi gitHubApi;

    public Repo(GitHubApi gitHubApi) {
        this.gitHubApi = gitHubApi;
    }

    @Override
    public LiveData<User> getUser(String userName) {

        final MutableLiveData<User> mutableLiveData = new MutableLiveData<>();

        gitHubApi.user(userName).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    mutableLiveData.setValue(response.body());
            }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
            }
        });

        return mutableLiveData;

        }

    @Override
    public LiveData<List<Repos>> getRepos(String username) {
        final MutableLiveData<List<Repos>> mutableLiveData = new MutableLiveData<>();

        gitHubApi.repos(username).enqueue(new Callback<List<Repos>>() {
            @Override
            public void onResponse(Call<List<Repos>> call, Response<List<Repos>> response) {
                if(response.isSuccessful()){
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Repos>> call, Throwable t) {
            }
        });

        return mutableLiveData;
    }
}

