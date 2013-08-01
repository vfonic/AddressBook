package com.viktorfonic.addressbook.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.viktorfonic.addressbook.Contact;
import com.viktorfonic.addressbook.R;

/**
 * Created by viktorfonic on 01.08.2013.
 */
public class ProfileActivity extends Activity {

    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_contact_activity);

        Intent intent = getIntent();
        TextView fullName_tv = (TextView) findViewById(R.id.full_name);
        TextView phone_tv = (TextView) findViewById(R.id.phone);
        TextView email_tv = (TextView) findViewById(R.id.email);
        fullName_tv.setText(intent.getStringExtra(Contact.NAME));
        phone = intent.getStringExtra(Contact.PHONE);
        phone_tv.setText(phone);
        email_tv.setText(intent.getStringExtra(Contact.EMAIL));
    }

    @SuppressWarnings("unused")
    public void openFacebook(View view) {
        String url = "http://facebook.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @SuppressWarnings("unused")
    public void callContact(View view) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + phone));
        startActivity(callIntent);
    }
}
