package com.example.emiliaaxen.stockholmguide1.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.emiliaaxen.stockholmguide1.Database.NeighborhoodSQLiteOpenHelper;
import com.example.emiliaaxen.stockholmguide1.R;

public class FavoriteActivity extends AppCompatActivity {

    Cursor favoriteCursor;
    CursorAdapter favoriteCursorAdapter;
    ListView favoriteList;
    NeighborhoodSQLiteOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        Log.d("Favorite activity", "where is it");

        favoriteList = (ListView) findViewById(R.id.list_favorites);
        favoriteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent favoriteToDetailIntent = new Intent(FavoriteActivity.this, DetailActivity.class);

                favoriteCursor.moveToPosition(position);
                favoriteToDetailIntent.putExtra("id", favoriteCursor.getInt(favoriteCursor.getColumnIndex(NeighborhoodSQLiteOpenHelper.COL_ID)));
                startActivity(favoriteToDetailIntent);
            }
        });
    }

    @Override
    protected void onResume() {

        favoriteCursor = NeighborhoodSQLiteOpenHelper.getInstance(FavoriteActivity.this).searchByFavorites();

        helper = NeighborhoodSQLiteOpenHelper.getInstance(FavoriteActivity.this);
        favoriteCursor.moveToFirst();

        favoriteCursorAdapter = new SimpleCursorAdapter(FavoriteActivity.this, android.R.layout.simple_list_item_activated_1, favoriteCursor, new String[]{NeighborhoodSQLiteOpenHelper.COL_ITEM_NAME}, new int[]{android.R.id.text1}, 0);
        favoriteList.setAdapter(favoriteCursorAdapter);
        super.onResume();
    }
}
