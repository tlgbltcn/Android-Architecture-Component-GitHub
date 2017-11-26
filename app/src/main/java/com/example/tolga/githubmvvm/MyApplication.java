package com.example.tolga.githubmvvm;
import android.app.Application;
import com.example.tolga.githubmvvm.di.AppComponent;
import com.example.tolga.githubmvvm.di.AppModule;
import com.example.tolga.githubmvvm.di.DaggerAppComponent;

/**
 * Created by tolga on 23.11.2017.
 */

public class MyApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
