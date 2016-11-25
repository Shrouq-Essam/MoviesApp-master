package com.example.eslam.movies;

import android.net.Uri;

/**
 * here.
 */
public class URL_builder {
    public String urlBuilder(String category)  {
        String APIKEY="e20080ab8b395f936423b819c9b6b689";
        final String base_url="https://api.themoviedb.org/3/discover/movie?";
        final String apiKey="api_key";
        final String sorting="sort_by";
        Uri uri=Uri.parse(base_url).buildUpon()
                .appendQueryParameter(sorting,category)
                .appendQueryParameter(apiKey,APIKEY)
                .build();

        return uri.toString();
    }
}
