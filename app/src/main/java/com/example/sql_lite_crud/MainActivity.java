package com.example.sql_lite_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper dbHelper = new DBHelper(this);
//        dbHelper.addContact("Hammad", "03350033351" );
//        dbHelper.addContact("Ahsan", "03350033352" );
//        dbHelper.addContact("Asad", "03350033353" );

//        ContactModel model = new ContactModel();
//        model.id = 10;
//        model.name = "Hammad";
//        model.phone_no = "03099881123";
//        dbHelper.updateContact(model);
        dbHelper.deleteContact("Asad");
        ArrayList<ContactModel> arrContacts = dbHelper.getContacts();
        for (int i=0;i<arrContacts.size();i++) {
            Log.d("Contact-Info", "Name: "+ arrContacts.get(i).name + ", Phone Number: " + arrContacts.get(i).phone_no);
        }
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        String newColumnName = "phone_no";
//        String alterTableQuery = "ALTER TABLE contacts RENAME COLUMN phone_noText TO " + newColumnName;
//        db.execSQL(alterTableQuery);
    }
}