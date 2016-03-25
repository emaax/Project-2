package com.example.emiliaaxen.stockholmguide1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by emiliaaxen on 16-03-17.
 */
public class NeighborhoodSQLiteOpenHelper extends SQLiteOpenHelper {

    //Class members:


    private static final String TAG = NeighborhoodSQLiteOpenHelper.class.getCanonicalName();

    // Defining the database name and version
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "NEIGHBORHOOD_DB";
    public static final String NEIGHBORHOOD_LIST_TABLE_NAME = "NEIGHBORHOOD_LIST";

    // Declaring the variable for the table columns
    public static final String COL_ID = "_id";
    public static final String COL_ITEM_TYPE = "TYPE";
    public static final String COL_ITEM_NAME = "ITEM_NAME";
    public static final String COL_ITEM_ADDRESS = "ADDRESS";
    public static final String COL_ITEM_NEIGHBORHOOD = "LOCATION";
    public static final String COL_ITEM_DESCRIPTION = "DESCRIPTION";
    public static final String COL_ITEM_IMAGE = "IMAGE";
    public static final String COL_ITEM_WEBSITE = "WEBSITE";
    public static final String COL_ITEM_FAV = "FAVORITE";


    private static NeighborhoodSQLiteOpenHelper mInstance;


    public static final String[] NEIGHBORHOOD_COLUMNS = {COL_ID, COL_ITEM_TYPE, COL_ITEM_NAME, COL_ITEM_ADDRESS, COL_ITEM_NEIGHBORHOOD, COL_ITEM_DESCRIPTION, COL_ITEM_IMAGE, COL_ITEM_WEBSITE, COL_ITEM_FAV};

    private static final String CREATE_NEIGHBORHOOD_LIST_TABLE = "CREATE TABLE " + NEIGHBORHOOD_LIST_TABLE_NAME +
            "(" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_ITEM_TYPE + " TEXT, " +
            COL_ITEM_NAME + " TEXT, " +
            COL_ITEM_ADDRESS + " TEXT, " +
            COL_ITEM_NEIGHBORHOOD + " TEXT, " +
            COL_ITEM_DESCRIPTION + " TEXT, " +
            COL_ITEM_IMAGE + " INTEGER, " +
            COL_ITEM_WEBSITE + " TEXT, " +
            COL_ITEM_FAV + " BOOLEAN )";

    /**
     * @param context The Context attached to the database
     */
    public NeighborhoodSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Invoked when the database is created
     * Creates the Neighborhood list table when the database is created
     * @param db Database
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_NEIGHBORHOOD_LIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NEIGHBORHOOD_LIST_TABLE_NAME);
        this.onCreate(db);
    }

    /**
     * @param name         String
     * @param type         String
     * @param address      String
     * @param neighborhood String
     * @param description  String
     * @param image        String
     * @return
     */
    //Add new itinerary list
    public long addItem(String name, String type, String address, String neighborhood, String description, int image, String webpage) {

        //insert values into the NEIGHBORHOOD_LIST table

        ContentValues values = new ContentValues();
        values.put(COL_ITEM_TYPE, type);
        values.put(COL_ITEM_NAME, name);
        values.put(COL_ITEM_ADDRESS, address);
        values.put(COL_ITEM_NEIGHBORHOOD, neighborhood);
        values.put(COL_ITEM_DESCRIPTION, description);
        values.put(COL_ITEM_IMAGE, image);
        values.put(COL_ITEM_WEBSITE, webpage);
        values.put(COL_ITEM_FAV, false);
        SQLiteDatabase db = this.getWritableDatabase();

        //inserts a row , which hold the values of the different keys, stated above. Each key is a different column
        long returnId = db.insert(NEIGHBORHOOD_LIST_TABLE_NAME, null, values);
        db.close();
        return returnId;
    }

    // gets the cursor to send the full list, i.e the complete table of the database to the activity that calls the cursor.
    public Cursor getNeighborhoodList() {

        SQLiteDatabase db = this.getReadableDatabase();
        //gets the cursor from the query. T

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME, // a. table
                NEIGHBORHOOD_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;
    }

    //gets the cursor to send the NBlist by type, i.e gets de data for all of the columns, based on types
    public Cursor searchNeighborhoodByType(String query) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME, // a. table
                NEIGHBORHOOD_COLUMNS, // b. column names //from  what columns do we want answer
                COL_ITEM_TYPE + " = ?", // c. selections //
                new String[]{query}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;
    }

    public Cursor searchingNeighborhoodByName(String query, String type) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME, // a. table
                NEIGHBORHOOD_COLUMNS, // b. column names //from  what columns do we want answer
                COL_ITEM_NAME + " LIKE  ? AND " + COL_ITEM_TYPE + " = ? ", // c. selections //
                new String[]{"%" + query + "%", type}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;
    }

    public Cursor searchByFavorites() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME, // a. table
                NEIGHBORHOOD_COLUMNS, // b. column names //from  what columns do we want answer
                COL_ITEM_FAV + " = ?", // c. selections //
                new String[]{1 + ""}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;
    }

    public String getTypeById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME,
                new String[]{COL_ITEM_TYPE},
                COL_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            return cursor.getString(cursor.getColumnIndex(COL_ITEM_TYPE));
        } else {
            return "No Type Found"; //or "No Description Found";
        }
    }

    public String getNameById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME,
                new String[]{COL_ITEM_NAME},
                COL_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            return cursor.getString(cursor.getColumnIndex(COL_ITEM_NAME));
        } else {
            return "No Name Found"; //or No Description Found?
        }
    }


    public String getAddressById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME,
                new String[]{COL_ITEM_ADDRESS},
                COL_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            return cursor.getString(cursor.getColumnIndex(COL_ITEM_ADDRESS));
        } else {
            return "No Address Found";//"No Description Found";
        }
    }

    public String getLocationById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME,
                new String[]{COL_ITEM_NEIGHBORHOOD},
                COL_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            return cursor.getString(cursor.getColumnIndex(COL_ITEM_NEIGHBORHOOD));
        } else {
            return "No Location Found"; // or "No Description Found";
        }
    }

    public String getDescriptionById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME,
                new String[]{COL_ITEM_DESCRIPTION},
                COL_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            return cursor.getString(cursor.getColumnIndex(COL_ITEM_DESCRIPTION));
        } else {
            return "No Description Found";
        }
    }

    public int getImageById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME,
                new String[]{COL_ITEM_IMAGE},
                COL_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            return cursor.getInt(cursor.getColumnIndex(COL_ITEM_IMAGE));
        } else {
            return 0;
        }
    }


public String getWebSiteById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME,
                new String[]{COL_ITEM_WEBSITE},
                COL_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            return cursor.getString(cursor.getColumnIndex(COL_ITEM_WEBSITE));
        } else {
            return "No Website Found";
        }
    }




    public void setFavoriteById(int id, boolean isFavorite) {
        ContentValues values = new ContentValues();
        values.put(COL_ITEM_FAV, isFavorite);
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(NEIGHBORHOOD_LIST_TABLE_NAME, values, COL_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public int getFavoriteById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME,
                new String[]{COL_ITEM_FAV},
                COL_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            return cursor.getInt(cursor.getColumnIndex(COL_ITEM_FAV));
        } else {
            return 0;
        }
    }

    public static NeighborhoodSQLiteOpenHelper getInstance(Context context) {
        // if it is the very first time we are running getInstance method, are m instance is going to be null, as er
        if (mInstance == null) {
            //setts our one true database
            mInstance = new NeighborhoodSQLiteOpenHelper(context);
        }
        return mInstance;
    }

    public int deleteItem(int id) {
        SQLiteDatabase db = getWritableDatabase();
        int deleteNum = db.delete(NEIGHBORHOOD_LIST_TABLE_NAME,
                COL_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
        return deleteNum;
    }

}


