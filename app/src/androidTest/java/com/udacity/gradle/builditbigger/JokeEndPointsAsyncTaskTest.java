package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class JokeEndPointsAsyncTaskTest {

    @Test
    public void testNonEmptyString() {
        JokeEndPointsAsyncTask endpointsAsyncTask = new JokeEndPointsAsyncTask();

        endpointsAsyncTask.execute(new Pair<>(InstrumentationRegistry.getTargetContext(), "test"));

        String result = "";
        try {
            result = endpointsAsyncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        assertTrue(result.length() > 0);
    }

}