package com.example.tolga.githubmvvm.ui;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.tolga.githubmvvm.R;
import com.example.tolga.githubmvvm.databinding.FragmentRepolistBinding;
import com.example.tolga.githubmvvm.di.AppComponent;
import com.example.tolga.githubmvvm.model.Repos;
import com.example.tolga.githubmvvm.model.User;
import com.example.tolga.githubmvvm.viewmodel.MainFragmentViewModel;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by tolga on 23.11.2017.
 */

public class RepoListFragment extends Fragment{

    public static  Fragment newInstance(){return new RepoListFragment();}

    private ReposAdapter adapter;

    private FragmentRepolistBinding fragmentRepolistBinding;

    @Inject
    MainFragmentViewModel mainFragmentViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentRepolistBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_repolist,container,false);
        return fragmentRepolistBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        adapter = new ReposAdapter();
        fragmentRepolistBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentRepolistBinding.recyclerView.setAdapter(adapter);


        AppComponent.from(getContext()).inject(this);

        mainFragmentViewModel.getUser("GorkemKarayel")
                .observe(this, new Observer<User>() {
                    @Override
                    public void onChanged(@Nullable User user) {
                        fragmentRepolistBinding.setUser(user);

                    }

                });

        mainFragmentViewModel.getRepos("GorkemKarayel")
                .observe(this, new Observer<List<Repos>>() {
                    @Override
                    public void onChanged(@Nullable List<Repos> repos) {
                        adapter.setReposList(repos);
                    }
                });




    }
}
