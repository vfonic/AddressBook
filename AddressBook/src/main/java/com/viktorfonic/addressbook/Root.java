package com.viktorfonic.addressbook;

import java.util.ArrayList;

/**
 * Created by viktorfonic on 05.08.2013.
 */
public class Root {
    private ArrayList<People> people;

    public Root(ArrayList<People> people) {
        this.people = people;
    }

    public ArrayList<People> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<People> people) {
        this.people = people;
    }
}
