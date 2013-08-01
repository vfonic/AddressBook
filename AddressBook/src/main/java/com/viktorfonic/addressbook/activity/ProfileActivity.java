package com.viktorfonic.addressbook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.viktorfonic.addressbook.Contact;
import com.viktorfonic.addressbook.R;

/**
 * Created by viktorfonic on 01.08.2013.
 */
public class ProfileActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_contact_activity);

        Intent intent = getIntent();
        TextView fullName_tv = (TextView) findViewById(R.id.full_name);
        TextView phone_tv = (TextView) findViewById(R.id.phone);
        TextView email_tv = (TextView) findViewById(R.id.email);
        fullName_tv.setText(intent.getStringExtra(Contact.NAME));
        phone_tv.setText(intent.getStringExtra(Contact.PHONE));
        email_tv.setText(intent.getStringExtra(Contact.EMAIL));
    }
}
