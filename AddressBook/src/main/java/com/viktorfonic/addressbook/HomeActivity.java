package com.viktorfonic.addressbook;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        ArrayList<HashMap<String, String>> people = createDummyPeople();

        ListView listView_Contacts = (ListView) findViewById(R.id.listView_contacts);
        SimpleAdapter adapter = new SimpleAdapter(this, people, android.R.layout.two_line_list_item, new String[]{"full_name", "contact"}, new int[]{android.R.id.text1, android.R.id.text2});
        listView_Contacts.setAdapter(adapter);
//        listView_Contacts.setAdapter(new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1, people));
    }

    private ArrayList<HashMap<String, String>> createDummyPeople() {
        ArrayList<HashMap<String, String>> people = new ArrayList<HashMap<String, String>>();
        people.add(createMapFromPerson(new Contact("Pero Perić", "098 181 24 33", "pero.peric@gmail.com")));
        people.add(createMapFromPerson(new Contact("Ivo Ivić", "098 181 24 33", "ivo.peric@gmail.com")));
        people.add(createMapFromPerson(new Contact("Marko Marković", "098 181 24 33", "marko.peric@gmail.com")));
        return people;
    }

    private HashMap<String, String> createMapFromPerson(Contact p) {
        HashMap<String, String> person = new HashMap<String, String>();
        person.put("full_name", p.getName());
        person.put("contact", p.getPhone() + ", " + p.getEmail());
        return person;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

}
