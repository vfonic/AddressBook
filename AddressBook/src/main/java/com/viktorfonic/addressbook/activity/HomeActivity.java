package com.viktorfonic.addressbook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.viktorfonic.addressbook.Contact;
import com.viktorfonic.addressbook.R;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeActivity extends Activity implements AdapterView.OnItemClickListener {

    private static ArrayList<HashMap<String, String>> contactsHash;
    private static ArrayList<Contact> contacts;
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        contactsHash = new ArrayList<HashMap<String, String>>();
        createDummyPeople();

        ListView listView_Contacts = (ListView) findViewById(R.id.listView_contacts);
        adapter = new SimpleAdapter(this, contactsHash, android.R.layout.two_line_list_item, new String[]{"full_name", "contact"}, new int[]{android.R.id.text1, android.R.id.text2});
        listView_Contacts.setAdapter(adapter);
        listView_Contacts.setOnItemClickListener(this);
    }

    private void createDummyPeople() {
        contacts = new ArrayList<Contact>();
        contacts.add(new Contact("Pero Perić", "098 181 24 33", "pero.peric@gmail.com"));
        contacts.add(new Contact("Ivo Ivić", "098 181 24 33", "ivo.peric@gmail.com"));
        contacts.add(new Contact("Marko Marković", "098 181 24 33", "marko.peric@gmail.com"));
        for (Contact c : contacts)
            contactsHash.add(createMapFromContact(c));
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
                    contactsHash.add(createMapFromContact(c));
                    contacts.add(c);
                    adapter.notifyDataSetChanged();
                    break;
            }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Contact c = contacts.get(position);
        Intent i = new Intent(this, ProfileActivity.class);
        i.putExtra(Contact.NAME, c.getName());
        i.putExtra(Contact.PHONE, c.getPhone());
        i.putExtra(Contact.EMAIL, c.getEmail());
        startActivity(i);
    }
}
