package com.example.emiliaaxen.stockholmguide1;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.emiliaaxen.stockholmguide1.model.StockholmItem;
import com.example.emiliaaxen.stockholmguide1.model.StockholmItemsManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String PREF_KEY_FIRST_APP_RUN = "prefKeyFirstAppRun";
    //region private Variables
    private Button restaurantsButton;
    private Button attractionsButton;
    private Button shoppingButton;
    private Button hotelsButton;

    private SharedPreferences sharedPref;
    private NeighborhoodSQLiteOpenHelper helper;
    //endregion private Variables

    //region Public Variables
    public static final String KEY_FAVORITES = "Favorites";
    public static final String KEY_TYPE = "Type";
    //endregion Public Variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = NeighborhoodSQLiteOpenHelper.getInstance(MainActivity.this);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
        if (checkIfFirstTimeRunningApp()) {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean(PREF_KEY_FIRST_APP_RUN, false);
            editor.apply();

            initializeDB();
        }

        initializeViews();
        initializeClickListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_results, menu);

        // Associates the  searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView)
                menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    private void initializeDB() {
        ArrayList<StockholmItem> stockholmItems = StockholmItemsManager.getStockholmItems(this);

        for (StockholmItem item : stockholmItems) {
            helper.addItem(item.getName(), item.getType(), item.getAddress(), item.getNeighborhood(),
                    item.getDescription(), item.getImageResourceId(), item.getWebsite());

        }
    }

    /**
     * Returns an intent with the value set as an extra.
     * The intent will launch the class being passed in
     * @param value String value for the key
     * @param classToLaunch The activity that will launch
     * @return Intent to launch the activity with the extra value
     */
    private Intent getIntentForType(String key, String value, Class classToLaunch) {

        Intent intentMainToResultsActivity = new Intent(MainActivity.this, classToLaunch);
        intentMainToResultsActivity.putExtra(key, value);

        return intentMainToResultsActivity;
    }

    /**
     * This method will initialize all the views which are used by the activity
     */
    private void initializeViews() {
        restaurantsButton = (Button) findViewById(R.id.button_restaurants);
        attractionsButton = (Button) findViewById(R.id.button_attractions);
        shoppingButton = (Button) findViewById(R.id.button_shopping);
        hotelsButton = (Button) findViewById(R.id.button_hotels);


    }

    /**
     * This method sets the clickListeners for all views in the activity
     */
    private void initializeClickListeners() {
        setButtonClickListener(restaurantsButton, StockholmItemsManager.TYPE_RESTAURANTS);
        setButtonClickListener(attractionsButton, StockholmItemsManager.TYPE_ATTRACTIONS);
        setButtonClickListener(shoppingButton, StockholmItemsManager.TYPE_SHOPPING);
        setButtonClickListener(hotelsButton, StockholmItemsManager.TYPE_HOTELS);
        setFabClickListener();
    }

    /**
     * Sets Click Listener for the Buttons that opens the #ResultsActivity.class
     * for the specific type
     * @param button Button
     * @param type   String,
     */
    private void setButtonClickListener(Button button, final String type) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntentForType(KEY_TYPE, type, ResultsActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Click Listener for the fab Button ( favorites) that opens the #FavoriteActivity.class,
     * i.e takes the user to Favorites screen.
     */
    private void setFabClickListener() {

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Go to favorites", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
                Intent intent = getIntentForType(KEY_FAVORITES, KEY_FAVORITES, FavoriteActivity.class);
                startActivity(intent);
            }
        });
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

    private boolean checkIfFirstTimeRunningApp() {
        boolean isFirstRun = sharedPref.getBoolean(PREF_KEY_FIRST_APP_RUN, true);
        return isFirstRun;
    }
}