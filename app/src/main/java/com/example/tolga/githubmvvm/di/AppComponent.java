package com.example.tolga.githubmvvm.di;
import android.content.Context;
import android.support.annotation.NonNull;
import com.example.tolga.githubmvvm.MyApplication;
import com.example.tolga.githubmvvm.ui.RepoListFragment;
import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by tolga on 23.11.2017.
 */
@Component(modules = AppModule.class)
@Singleton
public abstract class AppComponent {

    public static AppComponent from(@NonNull Context context){
        return ((MyApplication) context.getApplicationContext()).getAppComponent();
    }

    public abstract void inject(RepoListFragment repoListFragment);



}
