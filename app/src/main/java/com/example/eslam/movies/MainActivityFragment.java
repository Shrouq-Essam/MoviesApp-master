package com.example.eslam.movies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements DataParsed {
    public image_adapter imageAdapter;
    public JSON_parser parser;
    public GridView gridView;
    URL_builder url_builder;
    public String sort;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_main,container,false);
        setHasOptionsMenu(true);
        gridView=(GridView) rootView.findViewById(R.id.grid_view);
        url_builder=new URL_builder();
        sort="top_rated.desc";
        String url= url_builder.urlBuilder(sort);
        parser=new JSON_parser();
        parser.setListener(this);
        Connector  connector=new Connector();
        connector.setListener(parser);
        connector.execute(url);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),Detail_Activity.class);
                sample_model movie=imageAdapter.getItem(position);
                intent.putExtra("movie",movie);
                startActivity(intent);
            }
        });
        return rootView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.top_rated &&sort.equals("popularity.desc")){
            sort="top_rated.desc";
            updatelist();
        }else if(id==R.id.most_popular&&sort.equals("top_rated.desc")){
            sort="popularity.desc";
            updatelist();
        }

        return super.onOptionsItemSelected(item);
    }
    public void updatelist(){
        String url= url_builder.urlBuilder(sort);
        Connector  connector=new Connector();
        connector.setListener(parser);
        connector.execute(url);
    }

    @Override
    public void onDataparsed(sample_model[] data) {
        imageAdapter = new image_adapter(getActivity(),data);
        gridView.setAdapter(imageAdapter);
    }
}
