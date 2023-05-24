package com.example.sql_lite_crud;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText input,input2,input3;
    ListView list;
    Button add, delete, update, show;
    SearchView search;

//    public MainActivity(ArrayAdapter<ContactModel> adapter) {
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.idtext01);
        input2 = findViewById(R.id.idtext02);
        input3 = findViewById(R.id.idtext03);
        add = findViewById(R.id.idBtnAdd);
        delete = findViewById(R.id.idBtnDelete);
        update = findViewById(R.id.idBtnupdate);
        search = findViewById(R.id.searchView);
        list = findViewById(R.id.list_view);
        show = findViewById(R.id.idBtnShow);
        DBHelper dbHelper = new DBHelper(this);
        ArrayList<ContactModel> arrContacts = dbHelper.getContacts();
        ArrayList<String> contactNames = new ArrayList<>();
        for (ContactModel contact : arrContacts) {
            contactNames.add(contact.id+"       "+contact.name+"          "+contact.phone_no);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactNames);

        list.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = input.getText().toString();
                String phone = input2.getText().toString();
                dbHelper.addContact(name, phone );
                adapter.notifyDataSetChanged();
                restartActivity();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = input.getText().toString();
                dbHelper.deleteContact(name);
                restartActivity();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = input.getText().toString();
                int id = Integer.parseInt(input3.getText().toString());
                ContactModel model = new ContactModel();
                model.id = id;
                model.name = name;
                dbHelper.updateContact(model);
                restartActivity();
            }
        });
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                adapter.getFilter().filter(s);

                return false;
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.notifyDataSetChanged();
                list.invalidateViews();
                list.refreshDrawableState();
            }
        });

//        for (int i=0;i<arrContacts.size();i++) {
//            Log.d("Contact-Info", "Name: "+ arrContacts.get(i).name + ", Phone Number: " + arrContacts.get(i).phone_no);
//        }
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        String newColumnName = "phone_no";
//        String alterTableQuery = "ALTER TABLE contacts RENAME COLUMN phone_noText TO " + newColumnName;
//        db.execSQL(alterTableQuery);
    }

    private void restartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

}