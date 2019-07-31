package com.finalproject.mywallet;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper
{
    public static final String databaseName = "myWallet.db";

//variable for the customer table
    public static final String table1 = "Customer";
    public static final String col1 = "Cid";
    public static final String col2 = "first_name";
    public static final String col3 = "last_name";



// variables for the address
    public final String table2 = "Email";
    public final String coll0 = "Eid";
    public final static String coll1 = "email";


// variable for the debt table
    public final String table3 = "debt";
    public final String colll0 = "Did";
    public final String colll1 = "name";
    public final String colll2 = "owedTo";
    public static final String colll3 = "amount";

    public Database( Context context) {
        super(context, databaseName, null, 4);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
            db.execSQL(" create table "  + table1 + "(Cid integer primary key autoincrement, name text)");
            db.execSQL(" create table "  + table2 + "(Aid integer primary key, address text, foreign key(Aid) references Customer(Cid) )");
            db.execSQL(" create table "  + table3 + "(Did integer primary key,name text, owedTo text, amount text, foreign key(id) references Customer(Cid) )");
}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists " + table1 );
        db.execSQL("drop table if exists " + table2 );
        db.execSQL("drop table if exists " + table3 );
        onCreate(db);
    }

                    /*
                     * methods fo the first table
                     */

    public boolean insertCustomer(String id, String first_name, String lastName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =  new ContentValues();
        values.put(col1, id);
        values.put(col2, first_name);
        values.put(col3, lastName);
        long result =  db.insert(table1,null, values);
        if( result ==  -1)
            return false;
        else
            return true;
    }

    public Integer delete(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(table1, " name = ?", new String[] {name});

    }

            /*
             * methods for the address table
             */

    public boolean insertAddress(String address)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values  =  new ContentValues();
        values.put(coll1, address);
        long result =  db.insert(table2, null, values);
        if(result == -1)
            return true;
        else
            return false;

    }
    public boolean changeAddress (String address)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(coll1, address);
        db.update(table2, values, "address = ?", new String[] {address});
        return true;

    }



                                    /*
                                     * methods for the debt table
                                     */

   public boolean insertDebt(String name, String owedTo, String amount)
   {
       SQLiteDatabase db = this.getWritableDatabase();
       ContentValues values = new ContentValues();
       values.put(colll1, name);
       values.put(colll2, owedTo);
       values.put(colll3, amount);
       long result = db.insert(table3, null, values);
        if(result == -1)
            return false;
        else
            return true;


   }

   public Integer deleteDebt(String name)
   {
       SQLiteDatabase db = this.getWritableDatabase();
       return db.delete(table2, "name = ?", new String[] {name});
   }
}
