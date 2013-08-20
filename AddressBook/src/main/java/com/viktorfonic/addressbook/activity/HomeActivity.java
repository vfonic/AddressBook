package com.viktorfonic.addressbook.activity;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.viktorfonic.addressbook.Contact;
import com.viktorfonic.addressbook.R;

public class HomeActivity extends Activity implements AdapterView.OnItemClickListener, LoaderManager.LoaderCallbacks<Cursor> {

    public static final String[] PROJECTION = {ContactsContract.Data._ID, ContactsContract.Data.DISPLAY_NAME,
            ContactsContract.Data.PHOTO_THUMBNAIL_URI};
    public static final String SELECTION = "((" + ContactsContract.Data.DISPLAY_NAME + " NOTNULL) AND ("
            + ContactsContract.Data.DISPLAY_NAME + " != ''))";
    private SimpleCursorAdapter mAdapter;
    private Loader<Object> loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        String[] fromColumns = {ContactsContract.Data.DISPLAY_NAME};
        int[] toViews = {android.R.id.text1};
        ListView listView = (ListView) findViewById(R.id.listView_contacts);
//        mAdapter = new SimpleCursorAdapter(this, contactsHash, android.R.layout.two_line_list_item, new String[]{"full_name", "contact"}, new int[]{android.R.id.text1, android.R.id.text2});
        mAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, null, fromColumns, toViews, 0);
        listView.setAdapter(mAdapter);
//        listView_Contacts.setOnItemClickListener(this);
        getLoaderManager().initLoader(0, null, this);
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
//                    contacts.add(c);
                    mAdapter.notifyDataSetChanged();
                    break;
            }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Contact c = contacts.get(position);
        Intent i = new Intent(this, ProfileActivity.class);
//        i.putExtra(Contact.NAME, c.getName());
//        i.putExtra(Contact.PHONE, c.getPhone());
//        i.putExtra(Contact.EMAIL, c.getEmail());
        startActivity(i);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, ContactsContract.Data.CONTENT_URI, PROJECTION, SELECTION, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }
}
