package com.example.tolga.githubmvvm.repositories;

import android.arch.lifecycle.LiveData;

import com.example.tolga.githubmvvm.model.Repos;
import com.example.tolga.githubmvvm.model.User;

import java.util.List;

/**
 * Created by tolga on 23.11.2017.
 */

public interface GitHubRepo {

    LiveData<User> getUser(String userName);

    LiveData<List<Repos>> getRepos(String username);

}
