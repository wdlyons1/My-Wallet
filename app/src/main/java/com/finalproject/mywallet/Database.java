package com.finalproject.mywallet;

import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Database extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "myWallet.db";

    // First Table
    /*
     * This table will store every transaction
     * of the type Owe. That means, everything
     * transaction that people must pay to the user
     * of the app.
     */
    public static final String TABLE_NAME = "Transaction_Owe";
    public static final String COL_ID ="ID";
    public static final String COL_FIRST_NAME = "Fname";
    public static final String COL_LAST_NAME = "Lname";
    public static final String COL_AMOUNT = "Amount";
    public static final String COL_TRANSACTION_TYPE = "Type";

    // Second Table
    /*
     * This table will store every transaction
     * of the type Due. That means, everything
     * that the user must pay to other people.
     */
    public static final String TABLE_NAME_2 = "Transaction_Due";
    public static final String COL_ID_2 = "ID";
    public static final String COL_FIRST_NAME_2 = "Fname";
    public static final String COL_LAST_NAME_2 = "Lname";
    public static final String COL_AMOUNT_2 = "Amount";
    public static final String COL_TRANSACTION_TYPE_2 = "Type";

    //Third Table
    /*
     * This table will be used to store any complete
     * transaction of either type (Due or Own).
     */
    public static final String TABLE_NAME_3 = "Past_Transaction";
    public static final String COL_ID_3 = "ID";
    public static final String COL_TRANSACTION_TYPE_3 = "Type";
    public static final String COL_AMOUNT_3 = "Amount";

    public Database(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, FNAME TEXT, LNAME TEXT, AMOUNT TEXT, TYPE TEXT )");
        db.execSQL("CREATE TABLE " + TABLE_NAME_2 + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, FNAME TEXT, LNAME TEXT, AMOUNT TEXT, TYPE TEXT )");
        db.execSQL(" CREATE TABLE " + TABLE_NAME_3 + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, TYPE TEXT, AMOUNT TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_3);
    }


        // Method to insert a new transaaction of type Due (The user has to pay)

    public boolean addTransactionDue(String fname, String lname, String amount, String type)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_FIRST_NAME, fname);
        contentValues.put(COL_LAST_NAME, lname);
        contentValues.put(COL_AMOUNT, amount);
        contentValues.put(COL_TRANSACTION_TYPE, type);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

        // Method to insert a new transaction of type Owe (Other must pay the user)

    public boolean addTransactionOwe(String fname, String lname, String amount, String type)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_FIRST_NAME_2, fname);
        contentValues.put(COL_LAST_NAME_2, lname);
        contentValues.put(COL_AMOUNT_2, amount);
        contentValues.put(COL_TRANSACTION_TYPE_2, type);

        long result = db.insert(TABLE_NAME_2, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

        // Method to insert a transaction in the past table as soon as it is completed

    public boolean addTransactionPast(String type, String amount)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TRANSACTION_TYPE_3, type);
        contentValues.put(COL_AMOUNT_3, amount);

        long result = db.insert(TABLE_NAME_3, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllRecipesOwe()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return cursor;
    }

    public Cursor getAllRecipesDue()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME_2, null);
        return cursor;
    }

    public Cursor getAllRecipesPast()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME_3, null);
        return cursor;
    }

    public boolean updateTransactionOwe()
    {
        //TODO: Update function for transaction of type OWE
        return false;
    }

    public boolean updateTransactionDue()
    {
        //TODO: Update function for transaction of type DUE
        return false;
    }

    public Integer deleteTransactionOwe(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});
    }

    public Integer deleteTransactionDue(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_2, "ID = ?", new String[] {id});
    }

    public Integer deleteTransactionPast(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_3, "ID = ?", new String[] {id});
    }


}
