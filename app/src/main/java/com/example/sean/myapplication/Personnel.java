package com.example.sean.myapplication;

import android.widget.PopupWindow;

public class Personnel {
    private int _id;
    private String _name;

    public Personnel(){
    }

    public Personnel(String _name) {
        this._name = _name;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }
}
