package com.example.sql_lite_crud;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class list_name extends AppCompatActivity {
//    TextView name, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_name);
//        name = findViewById(R.id.nameTextView);
//        phone = findViewById(R.id.phoneTextView);
//        DBHelper dbHelper = new DBHelper(this);
//        ArrayList<ContactModel> arrContacts = dbHelper.getContacts();
//        ArrayAdapter<ContactModel> adapter = new ArrayAdapter<ContactModel>(this, R.layout.activity_list_name, arrContacts) {
//
//            public View getView(int position, View convertView, ViewGroup parent) {
//                if (convertView == null) {
//                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_name, parent, false);
//                }
//
//                // Get the current ContactModel object
//                ContactModel contact = getItem(position);
//
//                // Retrieve the TextView elements from the custom layout
//                name.setText(contact.name);
//                phone.setText(contact.phone_no);
//                // Set the values of the TextView elements
//                return convertView;
//            }
//        };
//        MainActivity mainActivity = new MainActivity(adapter);
    }

}