package com.viktorfonic.addressbook;

import com.google.gson.annotations.SerializedName;

/**
 * Created by viktorfonic on 31.07.2013..
 */
@SuppressWarnings("unused")
public class Contact {
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String EMAIL = "email";
    private String name, phone, email, note, facebook_profile;
    @SerializedName("image") private String image_src;

    public Contact(String name, String phone, String email) {
        this(name, phone, email, null, null, null);
    }

    public Contact(String name, String phone, String email, String image_src, String note, String facebook_profile) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.image_src = image_src;
        this.note = note;
        this.facebook_profile = facebook_profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " (" + phone + ", " + email + ")";
    }
}
