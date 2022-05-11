package com.lab.librarytracker.models.entities;

import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Users implements Serializable {

    @PrimaryKey(autoGenerate = true)
        private int id = 0;

    @ColumnInfo(name = "username")
    private String username = "";

    @ColumnInfo(name = "email")
    private String email = "";

    @ColumnInfo(name = "password")
    private String password = "";

    @ColumnInfo(name = "address")
    private String address = "";

    @ColumnInfo(name = "phoneNumber")
    private String phoneNumber = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
