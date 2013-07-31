package com.viktorfonic.addressbook.activity;

import android.app.Activity;
import android.os.Bundle;

import com.viktorfonic.addressbook.R;

/**
 * Created by Viktor Fonic on 31.07.2013
 */
public class AddContactActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact_activity);
    }
}
