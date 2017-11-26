package com.example.tolga.githubmvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.tolga.githubmvvm.model.Repos;
import com.example.tolga.githubmvvm.model.User;
import com.example.tolga.githubmvvm.repositories.GitHubRepo;
import com.example.tolga.githubmvvm.repositories.Repo;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by tolga on 23.11.2017.
 */

public class MainFragmentViewModel extends ViewModel {

    private final GitHubRepo gitHubRepo;

    @Inject
    public MainFragmentViewModel(GitHubRepo gitHubRepo) {
        this.gitHubRepo = gitHubRepo;
    }

    public LiveData<User> getUser(String user){
        return gitHubRepo.getUser(user);
    }

    public LiveData<List<Repos>> getRepos (String user){
        return gitHubRepo.getRepos(user);
    }




}

