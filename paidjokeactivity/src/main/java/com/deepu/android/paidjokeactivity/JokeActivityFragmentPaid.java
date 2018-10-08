package com.deepu.android.paidjokeactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokeActivityFragmentPaid extends Fragment {

    private static String JOKE_FRAGMENT = "JOKE_FRAGMENT";

    public JokeActivityFragmentPaid() {
    }

    public static JokeActivityFragmentPaid newInstance(String data) {
        JokeActivityFragmentPaid fragment = new JokeActivityFragmentPaid();


        Bundle bundle = new Bundle();
        bundle.putString(JOKE_FRAGMENT, data);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_joke_paid, container, false);
       TextView jokeTextView = root.findViewById(R.id.jokeText);
        jokeTextView.setText(getArguments().getString(JOKE_FRAGMENT));
        return root;
    }
}
