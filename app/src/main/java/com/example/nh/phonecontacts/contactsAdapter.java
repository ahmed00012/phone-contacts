package com.example.nh.phonecontacts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class contactsAdapter extends ArrayAdapter<contacts> {
    public contactsAdapter( Context context, ArrayList<contacts> contacts) {
        super(context, 0, contacts);
    }


    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        convertView=LayoutInflater.from(getContext()).inflate(R.layout.custom_contact,parent,false);

        TextView name=convertView.findViewById(R.id.name);
        TextView phone=convertView.findViewById(R.id.phone);


        contacts cont1=getItem(position);


        name.setText(cont1.getName() );
        phone.setText(cont1.getPhone());





        return convertView;
    }
}
