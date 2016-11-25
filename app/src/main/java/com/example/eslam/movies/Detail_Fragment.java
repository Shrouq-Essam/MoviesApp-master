package com.example.eslam.movies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class Detail_Fragment extends Fragment {

    public Detail_Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent intent=getActivity().getIntent();
        View rootView=inflater.inflate(R.layout.fragment_detail,container,false);
        sample_model movie= (sample_model) intent.getSerializableExtra("movie");
        TextView title= (TextView) rootView.findViewById(R.id.movie_title);
        title.setText(movie.getTitle());
        TextView release_date=(TextView)rootView.findViewById(R.id.release_date);
        release_date.setText(movie.getRelease_date());
        TextView description=(TextView) rootView.findViewById(R.id.description);
        description.setText(movie.getDescription());
        ImageView poster=(ImageView)rootView.findViewById(R.id.poster);
        Picasso.with(getContext()).load( movie.getPoster()).into(poster);
        return rootView;
    }
}
