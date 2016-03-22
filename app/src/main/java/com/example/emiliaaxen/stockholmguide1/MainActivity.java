package com.example.emiliaaxen.stockholmguide1;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SearchView;


public class MainActivity extends AppCompatActivity {

    private static final String TYPE_RESTAURANTS = "Restaurants";
    private static final String TYPE_ATTRACTIONS = "Attractions";
    private static final String TYPE_SHOPPING = "Shopping";
    private static final String TYPE_HOTELS = "Hotels";
    public static final String KEY_TYPE = "Type";



    Button restaurantsButton;
    Button attractionsButton;
    Button shoppingButton;
    Button hotelsButton;
    Intent intentMainToResultsActivity;

    NeighborhoodSQLiteOpenHelper helper = NeighborhoodSQLiteOpenHelper.getInstance(MainActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
*/

        helper.addItem("Saturnus", TYPE_RESTAURANTS, "Eriksbergsgatan 6, Stockholm", "Norrmalm/Vasastan", getString(R.string.saturnus), R.drawable.saturnus);
        helper.addItem("Sally och Systrar", TYPE_RESTAURANTS, "Klarabergsgatan 50 Stockholm", "Norrmalm/Vasastan", getString(R.string.sallyochsystrar), R.drawable.sally);
        helper.addItem("Flying Elk", TYPE_RESTAURANTS, "Malartorget 15, Stockholm", "Sodermalm", getString(R.string.flyingelk),R.drawable.flying);
        helper.addItem("Snickarbacken", TYPE_RESTAURANTS, "Snickarbacken 7, Stockholm", "Ostermalm", getString(R.string.snickarbacken),R.drawable.snickarbacken);
        helper.addItem("Urban Deli",TYPE_RESTAURANTS,"Nytorget 4 Stockholm","Sodermalm", getString(R.string.urbandeli),R.drawable.urbandeli);
        helper.addItem("Meatballs for the people",TYPE_RESTAURANTS,"Nytorgsgatan 30, Stockholm", "Sodermalm", getString(R.string.meatball),R.drawable.meatballs_for_the_people);
        helper.addItem("Sturehof", TYPE_RESTAURANTS, "Stureplan 2, Stockholm", "Ostermalm", getString(R.string.sturehof),R.drawable.sturehof);
        helper.addItem("Flipping Burger", TYPE_RESTAURANTS,"Observatoriegatan 8, Stockholm", "Norrmalm/Vasastan", getString(R.string.flippinburgers),R.drawable.flippinburgers);
        helper.addItem("Bla Porten", TYPE_RESTAURANTS,"Djurgardsvagen 64, Stockholm","Djurgarden", getString(R.string.blaporten),R.drawable.bla_porten);

        helper.addItem("Nordic Museum", TYPE_ATTRACTIONS,"Djurgardsvagen 6-16, Stockholm","Djurgarden", getString(R.string.nordic_museum),R.drawable.nordiskamuseumet);
        helper.addItem("Old Town", TYPE_ATTRACTIONS,"Old Town", "Old Town", getString(R.string.old_town),R.drawable.old_town);
        helper.addItem("Rosendal Palace ", TYPE_ATTRACTIONS,"Rosendalsvagen 38, Stockholm", "Djurgarden", getString(R.string.rosendal),R.drawable.rosendal);
        helper.addItem("Djurgarden", TYPE_ATTRACTIONS,"Djurgarden, Stockholm", "Djurgarden", getString(R.string.djurgarden),R.drawable.djurgarden);
        helper.addItem("Stockholm Consert Hall", TYPE_ATTRACTIONS,"Hotorget, Stockholm","Hamngatan 18-20, Stockholm", getString(R.string.sthlm_concet_hall),R.drawable.sthlm_concert_hall);


        helper.addItem("Mood", TYPE_SHOPPING,"Regeringsgatan 48, Stockholm", "Norrmalm/Vasastan", getString(R.string.mood),R.drawable.mood_gallerian);
        helper.addItem("Ahlens", TYPE_SHOPPING,"Klarabergsgatan 50, Stockholm","Norrmalm/Vasastan", getString(R.string.ahlens),R.drawable.ahlens);
        helper.addItem("NK", TYPE_SHOPPING,"Hamngatan 18-20, Stockholm", "Norrmalm/Vasastan", getString(R.string.nk),R.drawable.nk);


        helper.addItem("Hotel Diplomat", TYPE_HOTELS,"Strandvagen 7C, Stockholm","Ostermalm", getString(R.string.diplomat),R.drawable.diplomat);
        helper.addItem("Grand Hôtel", TYPE_HOTELS, "Sodra Blasieholmshamnen 8, Stockholm", "Ostermalm", getString(R.string.grand),R.drawable.grandhotel);
        helper.addItem("Berns", TYPE_HOTELS,"Näckstramsgatan 8, Stockholm", "Ostermalm", getString(R.string.berns),R.drawable.berns);


        helper.searchNeighborhoodByType(TYPE_RESTAURANTS);
        helper.searchNeighborhoodByType(TYPE_ATTRACTIONS);
        helper.searchNeighborhoodByType(TYPE_SHOPPING);
        helper.searchNeighborhoodByType(TYPE_HOTELS);

        restaurantsButton = (Button) findViewById(R.id.button_restaurants);
        attractionsButton = (Button) findViewById(R.id.button_attractions);
        shoppingButton = (Button) findViewById(R.id.button_shopping);
        hotelsButton = (Button) findViewById(R.id.button_hotels);

        restaurantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIntents(TYPE_RESTAURANTS);
            }
        });

        attractionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIntents(TYPE_ATTRACTIONS);
            }
        });
        shoppingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIntents(TYPE_SHOPPING);
            }
        });

        hotelsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIntents(TYPE_HOTELS);
            }
        });


       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Welcome to Stockholm", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }


            private void setIntents(String type) {

                //pas
                Intent intentMainToResultsActivity= new Intent(MainActivity.this, ResultsActivity.class);
                intentMainToResultsActivity.putExtra(KEY_TYPE, type);

                startActivity(intentMainToResultsActivity);
            }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_results, menu);

        // Associates the  searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        android.support.v7.widget.SearchView searchView =
                (android.support.v7.widget.SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

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

                return false;
                //return super.onOptionsItemSelected(item);
            }
        }

