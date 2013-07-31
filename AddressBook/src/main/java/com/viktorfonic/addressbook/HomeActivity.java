package com.viktorfonic.addressbook;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        
        ArrayList<Person> people = createDummyPeople();
        
        ListView listView_Contacts = (ListView) findViewById(R.id.listView_contacts);
        listView_Contacts.setAdapter(new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, people));
    }

    private ArrayList<Person> createDummyPeople() {
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("Pero", "098 181 24 33", "pero.peric@gmail.com"));
        people.add(new Person("Ivo", "091 161 24 33", "ivo.ivic@gmail.com"));
        people.add(new Person("Mate", "095 171 24 33", "mate.matic@hotmail.com"));
        return people;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

}
