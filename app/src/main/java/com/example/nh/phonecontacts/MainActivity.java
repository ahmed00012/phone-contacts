package com.example.nh.phonecontacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ListView listView;
    DataBaseHelper db;
    ArrayList<contacts> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn1);

        listView=findViewById(R.id.list);
        db=new DataBaseHelper(this);
        contacts=new ArrayList<>();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            contacts contacts=(contacts) parent.getItemAtPosition(position);
            Intent i=new Intent(MainActivity.this,Main3Activity.class);
            i.putExtra("id",contacts.getId());
            startActivity(i);

        }
    });


    }


    @Override
    protected void onResume() {
        super.onResume();
        contacts=db.getAllContacts();
        contactsAdapter adapter=new contactsAdapter(this,contacts);
        listView.setAdapter(adapter);
    }
}
