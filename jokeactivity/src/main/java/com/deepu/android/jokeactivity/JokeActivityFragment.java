package com.deepu.android.jokeactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class JokeActivityFragment extends Fragment {

    private static String JOKE_FRAGMENT = "JOKE_FRAGMENT";

    public JokeActivityFragment() {
    }

    public static JokeActivityFragment newInstance(String data) {
        JokeActivityFragment fragment = new JokeActivityFragment();


        Bundle bundle = new Bundle();
        bundle.putString(JOKE_FRAGMENT, data);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_joke, container, false);
       TextView jokeTextView = root.findViewById(R.id.jokeText);
        jokeTextView.setText(getArguments().getString(JOKE_FRAGMENT));

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }
}
