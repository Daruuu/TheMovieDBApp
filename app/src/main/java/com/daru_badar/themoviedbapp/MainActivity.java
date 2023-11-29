package com.daru_badar.themoviedbapp;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daru_badar.themoviedbapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import model.MovieModel;
import view.ListAdapterView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private List<MovieModel> elementMovieList;
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    public void init()
    {

        elementMovieList = new ArrayList<>();
        elementMovieList.add( new MovieModel( "01","abcd", "title01", "4.6", "20/08/23"));
        elementMovieList.add(new MovieModel("02", "efgh", "title02", "3.8", "20/09/15"));
        elementMovieList.add(new MovieModel("03", "#873e23", "title03", "4.2", "21/01/07"));
        elementMovieList.add(new MovieModel("04", "mnop", "title04", "3.5", "21/03/22"));
        elementMovieList.add(new MovieModel("05", "qrst", "title05", "4.0", "21/06/10"));
        elementMovieList.add(new MovieModel("06", "uvwxyz", "title06", "4.8", "21/08/30"));
        elementMovieList.add(new MovieModel("07", "12345", "title07", "3.2", "21/11/12"));
        elementMovieList.add(new MovieModel("08", "67890", "title08", "4.1", "22/02/01"));
        elementMovieList.add(new MovieModel("09", "abcdef", "title09", "3.9", "22/04/18"));
        elementMovieList.add(new MovieModel("10", "ghijkl", "title10", "4.5", "22/07/05"));
        elementMovieList.add(new MovieModel("11", "mnopqr", "title11", "3.7", "22/09/20"));
        elementMovieList.add(new MovieModel("12", "stuvwx", "title12", "4.2", "22/12/08"));
        elementMovieList.add(new MovieModel("13", "yzabcd", "title13", "3.4", "23/03/03"));
        elementMovieList.add(new MovieModel("14", "efghij", "title14", "4.0", "23/05/21"));
        elementMovieList.add(new MovieModel("15", "klmnop", "title15", "3.6", "23/08/12"));
        elementMovieList.add(new MovieModel("16", "qrstuv", "title16", "4.3", "23/10/29"));
        elementMovieList.add(new MovieModel("17", "wxyzab", "title17", "3.8", "23/01/14"));
        elementMovieList.add(new MovieModel("18", "123456", "title18", "4.5", "23/04/02"));
        elementMovieList.add(new MovieModel("19", "789012", "title19", "3.9", "23/06/20"));
        elementMovieList.add(new MovieModel("20", "abcde1", "title20", "4.1", "23/09/07"));

        ListAdapterView listAdapterView = new ListAdapterView(elementMovieList, this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapterView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
*/
}