package com.viktorfonic.addressbook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.viktorfonic.addressbook.Contact;
import com.viktorfonic.addressbook.R;

/**
 * Created by Viktor Fonic on 31.07.2013
 */
public class AddContactActivity extends Activity {
    public static final int ADD_CONTACT = 632;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact_activity);
    }

    @SuppressWarnings("unused")
    public void closeActivity(View view) {
        finish();
    }

    @SuppressWarnings("unused")
    public void addContact(View view) {
        EditText fullName_et = (EditText) findViewById(R.id.full_name);
        EditText phone_et = (EditText) findViewById(R.id.phone);
        EditText email_et = (EditText) findViewById(R.id.email);
        String fullName = fullName_et.getText().toString();
        String phone = phone_et.getText().toString();
        String email = email_et.getText().toString();
        Intent result = new Intent();
        setResult(RESULT_OK, result);
        result.putExtra(Contact.NAME, fullName);
        result.putExtra(Contact.PHONE, phone);
        result.putExtra(Contact.EMAIL, email);
        finish();
    }
}
