package com.udacity.gradle.builditbigger.backend;

import com.deepu.android.lib.Jokes;

public class JokeBean {
    private Jokes jokes;

    public JokeBean(){
        this.jokes = new Jokes();
    }

    public String getJoke(){
        return jokes.getNewJoke();
    }
}
