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

    //tag for debugging purposes
//getting the truest
    private static final String TAG = NeighborhoodSQLiteOpenHelper.class.getCanonicalName();


    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "NEIGHBORHOOD_DB";
    public static final String NEIGHBORHOOD_LIST_TABLE_NAME = "NEIGHBORHOOD_LIST";

    // Declaring the variable for the table columns
    public static final String COL_ID = "_id";
    public static final String COL_ITEM_TYPE = "TYPE";
    public static final String COL_ITEM_NAME = "ITEM_NAME";
    public static final String COL_ITEM_ADDRESS = "ADDRESS";
    public static final String COL_ITEM_LOCATION = "LOCATION";
    public static final String COL_ITEM_DESCRIPTION = "DESCRIPTION";
    public static final String COL_ITEM_IMAGE = "IMAGE";
    public static final String COL_ITEM_FAV = "FAVORITE";


//declaring the one instance, the one object, of NeighborhoodSQLiteOpenHelper. This is the one thing that all other classes will access with getInstance

    private static NeighborhoodSQLiteOpenHelper mInstance;


    //Declaring (dgiving the array a name and  deciding  varaibles and)  an array of the Neighborhood column names.. It only  holds the column names
    public static final String[] NEIGHBORHOOD_COLUMNS = {COL_ID, COL_ITEM_TYPE, COL_ITEM_NAME, COL_ITEM_ADDRESS, COL_ITEM_LOCATION, COL_ITEM_DESCRIPTION, COL_ITEM_IMAGE, COL_ITEM_FAV};
    // Declaring the string the holds the Sql call that will create our table
    private static final String CREATE_NEIGHBORHOOD_LIST_TABLE = "CREATE TABLE " + NEIGHBORHOOD_LIST_TABLE_NAME +
            "(" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_ITEM_TYPE + " TEXT, " +
            COL_ITEM_NAME + " TEXT, " +
            COL_ITEM_ADDRESS + " TEXT, " +
            COL_ITEM_LOCATION + " TEXT, " +
            COL_ITEM_DESCRIPTION + " TEXT, " +
            COL_ITEM_IMAGE + " INTEGER, " +
            COL_ITEM_FAV + "BOOLEAN )";

    // this is our constructur for SQLiteOpenHelper
    public NeighborhoodSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // method that runs the first time you open up the database //exec= execute
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_NEIGHBORHOOD_LIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NEIGHBORHOOD_LIST_TABLE_NAME);
        this.onCreate(db);
    }

    //Add new itinerary list
    public long addItem(String name, String type, String address, String location, String description, int image) {

        // Our table has five columns,COL_ITEM_NAME, COL_ITEM_TYPE, ... these are all Keys for the values map. We will give the the arguments as values, in other words
        // We're taking the argument "name", and giving it the value name.. and putting it in the key called key col_item_name,

        //insert values into the NEIGHBORHOOD_LIST table

        ContentValues values = new ContentValues();
        values.put(COL_ITEM_TYPE, type);
        values.put(COL_ITEM_NAME, name);
        values.put(COL_ITEM_ADDRESS, address);
        values.put(COL_ITEM_LOCATION, location);
        values.put(COL_ITEM_LOCATION, location);
        values.put(COL_ITEM_DESCRIPTION, description);
        values.put(COL_ITEM_IMAGE, image);
        values.put(COL_ITEM_FAV, false);
        SQLiteDatabase db = this.getWritableDatabase();

        //inserts a row , which hold the values of the different keys, stated above. Eaches key is a different column
        long returnId = db.insert(NEIGHBORHOOD_LIST_TABLE_NAME, null, values);
        db.close();
        return returnId;
    }


    // gets the cursor to send the full NBlist, i.e the complete table of the database to the activity that calls the cursor.
    public Cursor getNeighborhoodList() {

        SQLiteDatabase db = this.getReadableDatabase();
        //gets the cursor from the query. The only thing that will changes is the "things" that we put in

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

    public Cursor searchingNeighborhoodByName(String query) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME, // a. table
                NEIGHBORHOOD_COLUMNS, // b. column names //from  what columns do we want answer
                COL_ITEM_NAME + " LIKE  ?", // c. selections //
                new String[]{"%" + query + "%"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;
    }


   public String getTypeById(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME,
                new String[]{COL_ITEM_TYPE},
                COL_ID+" = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if(cursor.moveToFirst()){
            return cursor.getString(cursor.getColumnIndex(COL_ITEM_TYPE));
        } else {
            return "No Type Found"; //or "No Description Found";
        }
    }


    public String getNameById(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME,
                new String[]{COL_ITEM_NAME},
                COL_ID+" = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if(cursor.moveToFirst()){
            return cursor.getString(cursor.getColumnIndex(COL_ITEM_NAME));
        } else {
            return "No Name Found"; //or No Description Found?
        }
    }



    public String getAddressById(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME,
                new String[]{COL_ITEM_ADDRESS},
                COL_ID+" = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if(cursor.moveToFirst()){
            return cursor.getString(cursor.getColumnIndex(COL_ITEM_ADDRESS));
        } else {
            return "No Address Found";//"No Description Found";
        }
    }

    public String getLocationById(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME,
                new String[]{COL_ITEM_LOCATION},
                COL_ID+" = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if(cursor.moveToFirst()){
            return cursor.getString(cursor.getColumnIndex(COL_ITEM_LOCATION));
        } else {
            return "No Location Found"; // or "No Description Found";
        }
    }
    public String getDescriptionById(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME,
                new String[]{COL_ITEM_DESCRIPTION},
                COL_ID+" = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if(cursor.moveToFirst()){
            return cursor.getString(cursor.getColumnIndex(COL_ITEM_DESCRIPTION));
        } else {
            return "No Description Found";
        }
    }
    public int getImageById(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME,
                new String[]{COL_ITEM_IMAGE},
                COL_ID+" = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if(cursor.moveToFirst()){
            return cursor.getInt(cursor.getColumnIndex(COL_ITEM_IMAGE));
        } else {
            return 0;
        }
    }
    public int getFavoriteById(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME,
                new String[]{COL_ITEM_FAV},
                COL_ID+" = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if(cursor.moveToFirst()){
            return cursor.getInt(cursor.getColumnIndex(COL_ITEM_FAV));
        } else {
            return 0;
        }
    }
    public void setFavoriteById(int id, boolean isFavorite){
        ContentValues values = new ContentValues();
        values.put(COL_ITEM_FAV, isFavorite);
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(NEIGHBORHOOD_LIST_TABLE_NAME, values, COL_ID+" = ?", new String[]{String.valueOf(id)});
    }



    public static NeighborhoodSQLiteOpenHelper getInstance(Context context) {
        // if it is the very first time we are running getInstance method, are m instance is going to be null, as er
        if (mInstance == null){
            //setts our one true database
            mInstance = new NeighborhoodSQLiteOpenHelper(context);
        }
        return mInstance;
    }

    public int deleteItem(int id){
        SQLiteDatabase db = getWritableDatabase();
        int deleteNum = db.delete(NEIGHBORHOOD_LIST_TABLE_NAME,
                COL_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
        return deleteNum;
    }

}


