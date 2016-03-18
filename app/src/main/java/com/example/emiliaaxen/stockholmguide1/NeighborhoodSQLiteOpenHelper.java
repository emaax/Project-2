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

    private static final String TAG = NeighborhoodSQLiteOpenHelper.class.getCanonicalName();

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "NEIGHBORHOOD_DB";
    public static final String NEIGHBORHOOD_LIST_TABLE_NAME = "NEIGHBORHOOD_LIST";

    public static final String COL_ID = "_id";
    public static final String COL_ITEM_NAME = "ITEM_NAME";
    public static final String COL_ITEM_TYPE = "TYPE";
    public static final String COL_ITEM_ADDRESS = "ADDRESS";
    public static final String COL_ITEM_LOCATION= "LOCATION";
    public static final String COL_ITEM_DESCRIPTION = "DESCRIPTION";



    private static NeighborhoodSQLiteOpenHelper mInstance;

    public static final String[] NEIGHBORHOOD_COLUMNS = {COL_ID,COL_ITEM_NAME, COL_ITEM_TYPE, COL_ITEM_ADDRESS, COL_ITEM_LOCATION, COL_ITEM_DESCRIPTION};

    private static final String CREATE_NEIGHBORHOOD_LIST_TABLE =
            "CREATE TABLE " + NEIGHBORHOOD_LIST_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_ITEM_NAME + " TEXT, " +
                    COL_ITEM_TYPE + " TEXT, " +
                    COL_ITEM_ADDRESS + " TEXT, " +
                    COL_ITEM_LOCATION + " TEXT, " +
                    COL_ITEM_DESCRIPTION + " TEXT)";

    public NeighborhoodSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

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
    public long addItem(String name, String type, String address, String location, String description){
        ContentValues values = new ContentValues();
        values.put(COL_ITEM_NAME, name);
        values.put(COL_ITEM_TYPE, type);
        values.put(COL_ITEM_ADDRESS, address);
        values.put(COL_ITEM_LOCATION, location);
        values.put(COL_ITEM_DESCRIPTION, description);
        SQLiteDatabase db = this.getWritableDatabase();
        long returnId = db.insert(NEIGHBORHOOD_LIST_TABLE_NAME, null, values);
        db.close();
        return returnId;
    }

    public Cursor getNeighborhoodList(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME, // a. table
                NEIGHBORHOOD_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
//By putting null, we are saying we don't care about the properties of a query. We COULD query and get results that are ordered, get a limited number
        //of results, but because we just want all results, we put null for those values.
        return cursor;
    }

    public int deleteItem(int id){
        SQLiteDatabase db = getWritableDatabase();
        int deleteNum = db.delete(NEIGHBORHOOD_LIST_TABLE_NAME,
                COL_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
        return deleteNum;
    }

    public Cursor searchNeighborhoodList(String query){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NEIGHBORHOOD_LIST_TABLE_NAME, // a. table
                NEIGHBORHOOD_COLUMNS, // b. column names
                COL_ITEM_NAME + " LIKE ?", // c. selections
                new String[]{"%" + query + "%"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;
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

    public static NeighborhoodSQLiteOpenHelper getInstance(Context context) {
        if (mInstance == null){
            mInstance = new NeighborhoodSQLiteOpenHelper(context.getApplicationContext());
        }
        return mInstance;
    }
}


