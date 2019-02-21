package com.example.user.internalstorage38;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Context;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    EditText name;
    EditText email;
    Switch mySwitch;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    public static final Boolean switchKey = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.etName);
        email = (EditText) findViewById(R.id.etEmail);
        mySwitch = (Switch)findViewById(R.id.switch1);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));
        }
        if (sharedpreferences.contains("switchKey")) {
            mySwitch.setChecked(sharedpreferences.getBoolean("switchKey",true));
        }

    }

    public void Save(View view) {
        String n = name.getText().toString();
        String e = email.getText().toString();
        Boolean s = mySwitch.isChecked();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.putString(Email, e);
        editor.putBoolean("switchKey", s);
        editor.commit();
    }

    public void clear(View view) {
        name = (EditText) findViewById(R.id.etName);
        email = (EditText) findViewById(R.id.etEmail);
        mySwitch = (Switch) findViewById(R.id.switch1);
        name.setText("");
        email.setText("");
        mySwitch.setChecked(true);
    }

    public void Get(View view) {
        name = (EditText) findViewById(R.id.etName);
        email = (EditText) findViewById(R.id.etEmail);
        mySwitch = (Switch) findViewById(R.id.switch1);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));

        }
        if (sharedpreferences.contains("switchKey")) {
            mySwitch.setChecked(sharedpreferences.getBoolean("switchKey", true));
        }
    }


}
