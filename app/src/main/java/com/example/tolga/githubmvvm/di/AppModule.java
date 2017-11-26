package com.example.tolga.githubmvvm.di;

import android.app.Application;

import com.example.tolga.githubmvvm.GitHubApi;
import com.example.tolga.githubmvvm.repositories.GitHubRepo;
import com.example.tolga.githubmvvm.repositories.Repo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tolga on 23.11.2017.
 */
@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public GitHubApi provideGitHubApi(){

        return new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GitHubApi.class);
    }

    @Provides
    @Singleton
    public GitHubRepo providesGitHubRepository(GitHubApi githubAPI){
        return new Repo(githubAPI);
    }

}
