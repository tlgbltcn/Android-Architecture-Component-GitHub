package com.example.tolga.githubmvvm;

import com.example.tolga.githubmvvm.model.Repos;
import com.example.tolga.githubmvvm.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by tolga on 23.11.2017.
 */

public interface GitHubApi {

    @GET("/users/{user}")
    Call<User> user(@Path("user") String user);

    @GET("/users/{user}/repos")
    Call<List<Repos>> repos(@Path("user") String user);

}
