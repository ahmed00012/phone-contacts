package com.example.nh.phonecontacts;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {

    EditText edt1,edt2;
    Button btn1;
    int id;
    DataBaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        edt1=findViewById(R.id.edt12);
        edt2=findViewById(R.id.edt13);
        btn1=findViewById(R.id.btn12);

        id=getIntent().getIntExtra("id",0);

            db=new DataBaseHelper(this);
            contacts contacts=db.getContactById(id);
            edt1.setText(contacts.getName());
            edt2.setText(contacts.getPhone());


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edt1.getText().toString();
                String phone = edt2.getText().toString();
                contacts contacts1 = new contacts(id, name, phone);
                db.updateContact(contacts1);
                finish();

            }

            });




    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.custom_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete:
                db.deleteContact(id);
                finish();


        }
        return super.onOptionsItemSelected(item);
    }







}
