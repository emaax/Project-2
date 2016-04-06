package com.example.emiliaaxen.stockholmguide1.Activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.emiliaaxen.stockholmguide1.Database.NeighborhoodSQLiteOpenHelper;
import com.example.emiliaaxen.stockholmguide1.R;

public class ResultsActivity extends AppCompatActivity {

    private ListView mNeighborhoodListView;
    private CursorAdapter mCursorAdapter;
    private NeighborhoodSQLiteOpenHelper mHelper;
    private Cursor cursor;
    private String type;
    private String favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Gets an instance of your database helper
        mNeighborhoodListView = (ListView) findViewById(R.id.neighborhood_list_view);



        mHelper = NeighborhoodSQLiteOpenHelper.getInstance(ResultsActivity.this);



        handleIntent(getIntent());
        type = getIntent().getStringExtra(MainActivity.KEY_TYPE);


        if (type.equals(MainActivity.KEY_FAVORITES)) {
            cursor = mHelper.searchNeighborhoodByType(favorite);
        } else {
            cursor = mHelper.searchNeighborhoodByType(type);
        }
        cursor = mHelper.searchNeighborhoodByType(type);
        // Gets the query from the database helper called getNeighborhoodList, which is a cursor of all of the data
        mCursorAdapter = new SimpleCursorAdapter(this, R.layout.activity_results_cardview, cursor, new String[]{NeighborhoodSQLiteOpenHelper.COL_ITEM_NAME}, new int[]{R.id.list_info_text}, 0);
        mNeighborhoodListView.setAdapter(mCursorAdapter);

        /*Gets the data for the individual item when it's being clicked on.This is done by passing the id column value into
        the intent in the ResultsActivity in the item click listener.*/

/**
 *
 */
        mNeighborhoodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ResultsActivity.this, DetailActivity.class);
                cursor.moveToPosition(position);
                intent.putExtra("id", cursor.getInt(cursor.getColumnIndex(NeighborhoodSQLiteOpenHelper.COL_ID)));
                startActivity(intent);
            }
        });

        //
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
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //Creates a new search function


            cursor = mHelper.searchingNeighborhoodByName(query, type);
            mCursorAdapter.changeCursor(cursor);
            mCursorAdapter.notifyDataSetChanged();
        }

    }

}

