package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;

import com.deepu.android.jokeactivity.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;

import java.io.IOException;

public class JokeEndPointsAsyncTask extends AsyncTask<Pair<Context,String>, Void, String> {

    private JokeApi jokeApi;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(jokeApi == null){
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),new AndroidJsonFactory(),null).setRootUrl("http://10.0.2.2:8080/_ah/api/").setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                @Override
                public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                    request.setDisableGZipContent(true);
                }
            });

            jokeApi = builder.build();
        }

        context = params[0].first;

        try {
            return jokeApi.sayJoke().execute().getJoke();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String s) {
        if(s==null || s.trim().isEmpty()){
            s = "Error while retrieving joke";
        }
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(context.getResources().getString(R.string.joke), s);
        context.startActivity(intent);
    }
}
