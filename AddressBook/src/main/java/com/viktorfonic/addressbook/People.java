package com.viktorfonic.addressbook;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viktorfonic on 05.08.2013.
 */
public class People {
    public Contact getPerson() {
        return person;
    }

    public void setPerson(Contact person) {
        this.person = person;
    }

    public People(Contact person) {

        this.person = person;
    }

    private Contact person;
}
