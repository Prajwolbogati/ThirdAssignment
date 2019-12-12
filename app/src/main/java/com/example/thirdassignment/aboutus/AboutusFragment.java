package com.example.thirdassignment.aboutus;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.thirdassignment.R;

public class AboutusFragment extends Fragment {

    private AboutusViewModel mViewModel;

    public static AboutusFragment newInstance() {
        return new AboutusFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel =
                ViewModelProviders.of(this).get(AboutusViewModel.class);
        View root = inflater.inflate(R.layout.aboutus_fragment, container, false);

        WebView webview = root.findViewById(R.id.softwarica);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl("https://softwarica.edu.np/");


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AboutusViewModel.class);
        // TODO: Use the ViewModel
    }

}
