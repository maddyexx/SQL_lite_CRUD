package com.example.sql_lite_crud;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.telephony.CarrierConfigManager;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "Students_db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CONTACT = "contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE_NUMBER = "phone_no";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+ TABLE_CONTACT +
                "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT," +
                KEY_PHONE_NUMBER + " TEXT)");
//        SQLiteDatabase database = this.getWritableDatabase();
//        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
        onCreate(db);
    }
    public void addContact(String name, String phone_no){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_PHONE_NUMBER, phone_no);
        db.insert(TABLE_CONTACT, null, values);
    }
    public ArrayList<ContactModel> getContacts(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_CONTACT,  null);
        ArrayList<ContactModel> ArrayContacts = new ArrayList<>();
        while (cursor.moveToNext()){
            ContactModel model = new ContactModel();
            model.id = cursor.getInt(0);
            model.name = cursor.getString(1);
            model.phone_no = cursor.getString(2);
            ArrayContacts.add(model);
        }
        return ArrayContacts;
    }
    public void updateContact(ContactModel contactModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, contactModel.name);
        db.update(TABLE_CONTACT, cv, KEY_ID+" = "+contactModel.id, null);

    }
    public void deleteContact(String name){
        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_CONTACT, KEY_NAME+ " = "+contactModel.name,null);
        db.delete(TABLE_CONTACT, KEY_NAME+ " = ?", new String[]{String.valueOf(name)});
    }
}
