package com.example.nh.phonecontacts;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    EditText name , phone ;
    Button btn;
    DataBaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name=findViewById(R.id.edt1);
        phone=findViewById(R.id.edt2);
        btn=findViewById(R.id.add);
        db=new DataBaseHelper(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1= name.getText().toString();
                String phone1=phone.getText().toString();
                contacts contacts=new contacts( name1,phone1 );
                db.addContact(contacts);
                finish();
            }
        });




    }
}
