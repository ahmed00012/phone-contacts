package com.example.nh.phonecontacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseHelper  extends SQLiteOpenHelper {

    private static final String DB_NAME="MyDatabase";
    private  static final int DB_Version=1;
    private static final String Table_name="contacts";
    private static final String Key_id="id";
    private static final String Name="name";
    private static final String Phone="phone";





    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Create_table="CREATE TABLE "+Table_name+" ( "+Key_id+" INTEGER PRIMARY KEY , "+Name+" VARCHAR(20),"+Phone+" VARCHAR(20) )";
        db.execSQL(Create_table);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }




    public void addContact(contacts contact){

        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Name,contact.getName());
        contentValues.put(Phone,contact.getPhone());
        db.insert(Table_name,null,contentValues);

    }

    public ArrayList<contacts> getAllContacts() {
        ArrayList<contacts> contacts= new ArrayList<>();
        String SELECT="SELECT * FROM "+ Table_name+"";
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor=db.rawQuery(SELECT,null);

        if (cursor.moveToFirst()) {


            do {
                String name = cursor.getString(cursor.getColumnIndex(Name));
                String phone = cursor.getString(cursor.getColumnIndex(Phone));
                int id = cursor.getInt(cursor.getColumnIndex(Key_id));

                contacts contacts1 = new contacts(id, name, phone);
                contacts.add(contacts1);

            }while (cursor.moveToNext());

        }
        cursor.close();
        return contacts;

        }


    public contacts getContactById( int id) {

        String SELECT="SELECT * FROM "+Table_name+" WHERE id=" +id;
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor=db.rawQuery(SELECT,null);
        contacts contacts1=null;

        if (cursor.moveToFirst()) {



                String name = cursor.getString(cursor.getColumnIndex(Name));
                String phone = cursor.getString(cursor.getColumnIndex(Phone));
                int contact_id= cursor.getInt(cursor.getColumnIndex(Key_id));

                contacts1 = new contacts(contact_id, name, phone);


            }


        cursor.close();
        return contacts1;

    }

    public void updateContact(contacts contacts){

        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Name,contacts.getName());
        contentValues.put(Phone,contacts.getPhone());
        db.update(Table_name,contentValues,"id=?",new String[]{String.valueOf(  contacts.getId())});




    }


    public void deleteContact(int id){

        SQLiteDatabase db=getWritableDatabase();
        db.delete(Table_name,"id=?" ,new String[] {String.valueOf(id)});
    }



}


