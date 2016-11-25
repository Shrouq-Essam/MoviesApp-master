package com.example.eslam.movies;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 */
public class JSON_parser implements AsyncDatafetched  {
    private MainActivityFragment mainActivityFragment;
    private DataParsed listener;
    private image_adapter image_adapter;
    private String[] posters;
    sample_model[] moviesdata;
    public String[] getImage(String Jsonmovies) throws JSONException {
        JSONObject jsonObject = new JSONObject(Jsonmovies);
        JSONArray jsonArray = (JSONArray) jsonObject.getJSONArray("results");
        posters = new String[jsonArray.length()];
        moviesdata=new sample_model[jsonArray.length()];
        Log.v("Movies: ",jsonArray.toString());
        int sz=jsonArray.length();
        for (int i = 0; i < sz ; i++) {
               JSONObject movie=jsonArray.getJSONObject(i);
               Log.v("Movie title : ",movie.toString());
//            posters[i]=("http://image.tmdb.org/t/p/w185"+movie.getString("poster_path"));
                moviesdata[i]=new sample_model();
                moviesdata[i].setTitle(movie.getString("title"));
                moviesdata[i].setPoster("http://image.tmdb.org/t/p/w185"+movie.getString("poster_path"));
                moviesdata[i].setDescription(movie.getString("overview"));
                moviesdata[i].setRelease_date(movie.getString("release_date"));
//            Log.d("pos path : ",posters[i]);
        }
        return posters;
    }
    public void setMainActivityFragment(MainActivityFragment mainActivityFragment){
        this.mainActivityFragment=mainActivityFragment;
    }
    @Override
    public void onDatafetched(String JsonStr) {
        try {
            getImage(JsonStr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        listener.onDataparsed(moviesdata);
    }

    public DataParsed getListener() {
        return listener;
    }

    public void setListener(DataParsed listener) {
        this.listener = listener;
    }
}
