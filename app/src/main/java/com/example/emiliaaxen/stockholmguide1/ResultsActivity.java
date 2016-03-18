package com.example.emiliaaxen.stockholmguide1;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;

public class ResultsActivity extends AppCompatActivity {

    private ListView mNeighborhoodListView;
    private CursorAdapter mCursorAdapter;
    private NeighborhoodSQLiteOpenHelper mHelper;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //Gets an instance of your database helper
        mNeighborhoodListView = (ListView)findViewById(R.id.neighborhood_list_view);
        mHelper = NeighborhoodSQLiteOpenHelper.getInstance(ResultsActivity.this);


        cursor = mHelper.getNeighborhoodList();

        // Gets the query from the database helper called getNeighborhoodList, which is a cursor of all of the data                         SHOULD IT BE NAME
        mCursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,cursor,new String[]{NeighborhoodSQLiteOpenHelper.COL_ITEM_TYPE},new int[]{android.R.id.text1},0);
        mNeighborhoodListView.setAdapter(mCursorAdapter);


        /*Gets the data for the individual item when it's being clicked on.
        This is done by passing the id column value into
        the intent in the ResultsActivity in the item click listener.*/
        mNeighborhoodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ResultsActivity.this, DetailActivity.class);
                cursor.moveToPosition(position);
                intent.putExtra("id", cursor.getInt(cursor.getColumnIndex(NeighborhoodSQLiteOpenHelper.COL_ID)));
                startActivity(intent);
            }
        });

       handleIntent(getIntent());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_results, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
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
            Cursor cursor = mHelper.searchNeighborhoodByType(query);
            mCursorAdapter.changeCursor(cursor);
            mCursorAdapter.notifyDataSetChanged();
        }




Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
