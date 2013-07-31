package com.viktorfonic.addressbook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.viktorfonic.addressbook.Contact;
import com.viktorfonic.addressbook.R;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeActivity extends Activity {

    private static ArrayList<HashMap<String, String>> contacts;
    private SimpleAdapter adapter;
    private ListView listView_Contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        contacts = createDummyPeople();

        listView_Contacts = (ListView) findViewById(R.id.listView_contacts);
        adapter = new SimpleAdapter(this, contacts, android.R.layout.two_line_list_item, new String[]{"full_name", "contact"}, new int[]{android.R.id.text1, android.R.id.text2});
        listView_Contacts.setAdapter(adapter);
    }

    private ArrayList<HashMap<String, String>> createDummyPeople() {
        ArrayList<HashMap<String, String>> contacts = new ArrayList<HashMap<String, String>>();
        contacts.add(createMapFromContact(new Contact("Pero Perić", "098 181 24 33", "pero.peric@gmail.com")));
        contacts.add(createMapFromContact(new Contact("Ivo Ivić", "098 181 24 33", "ivo.peric@gmail.com")));
        contacts.add(createMapFromContact(new Contact("Marko Marković", "098 181 24 33", "marko.peric@gmail.com")));
        return contacts;
    }

    private HashMap<String, String> createMapFromContact(Contact p) {
        HashMap<String, String> person = new HashMap<String, String>();
        person.put("full_name", p.getName());
        person.put("contact", p.getPhone() + ", " + p.getEmail());
        return person;
    }

    @SuppressWarnings("unused")
    public void startAddNewContactActivity(View view) {
        Intent i = new Intent(this, AddContactActivity.class);
        startActivityForResult(i, AddContactActivity.ADD_CONTACT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK)
            switch (requestCode) {
                case AddContactActivity.ADD_CONTACT:
                    String name = data.getStringExtra(Contact.NAME);
                    String phone = data.getStringExtra(Contact.PHONE);
                    String email = data.getStringExtra(Contact.EMAIL);
                    Contact c = new Contact(name, phone, email);
                    contacts.add(createMapFromContact(c));
                    adapter = new SimpleAdapter(this, contacts, android.R.layout.two_line_list_item, new String[]{"full_name", "contact"}, new int[]{android.R.id.text1, android.R.id.text2});
                    listView_Contacts.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    break;
            }
    }
}
