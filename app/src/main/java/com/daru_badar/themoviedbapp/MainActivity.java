package com.daru_badar.themoviedbapp;

import android.app.appsearch.PutDocumentsRequest;
import android.content.Context;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
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
import com.google.gson.JsonObject;

import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import controller.MovieViewModel;
import model.MovieModel;
import view.ListAdapterView;

public class MainActivity extends AppCompatActivity {



    //https://api.themoviedb.org/3/movie/343611?api_key=d78c7fd437d75f91e7d40f40647d053d

    private static String JSON_URL = "https://api.themoviedb.org/3/discover/movie?api_key=d78c7fd437d75f91e7d40f40647d053d";

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    List<MovieModel> modelList;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modelList = new ArrayList<>();
        recyclerView = findViewById(R.id.listRecyclerViewId);


        /*
        GetData getData = new GetData();
        getData.execute();
         */


        fetchDataFromApi();


    }

    private void fetchDataFromApi() {
        new GetData(this).execute(JSON_URL);

    }


        /*

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
         */


    //configurar la orientacion VERTICAL y HORIZONTAL
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Orientación horizontal
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Orientación vertical
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }






    public class GetData extends AsyncTask<String, Void , String>{

            private WeakReference<MainActivity> activityReference;

            GetData(MainActivity context) {
                activityReference = new WeakReference<>(context);
            }


            @Override
            protected String doInBackground(String... strings) {
                String current = "";

                try{
                    URL url;
                    HttpURLConnection urlConnection = null;

                    try {
                        url = new URL(JSON_URL);
                        urlConnection = (HttpURLConnection) url.openConnection();

                        InputStream is = urlConnection.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is);

                        int data = isr.read();
                        while(data != -1){
                            current += (char) data;
                            data = isr.read();

                        }
                        return current;

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if(urlConnection != null){
                            urlConnection.disconnect();
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return current;
            }
            @Override
            protected void onPostExecute(String s){

                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray jsonArray =jsonObject.getJSONArray("results");

                    for(int i = 0; i < jsonArray.length(); i++){

                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                        MovieModel model = new MovieModel();
                        model.setId(jsonObject1.getString("id"));
                        model.setTitle(jsonObject1.getString("name"));
                        model.setImage(jsonObject1.getString("image"));

                        modelList.add(model);
                    }




                } catch (JSONException e) {
                    e.printStackTrace();
                }
                PutDataIntoRecyclerView(modelList);
            }


        }
        private void PutDataIntoRecyclerView(List<MovieModel> modelList){
            ListAdapterView adapterView = new ListAdapterView(modelList, this);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapterView);

        }

    }






    /*

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

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

}


     */



