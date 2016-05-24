package com.example.sandumihai.discovertheworld;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends Activity {

    DataBaseHelperLogin helper = new DataBaseHelperLogin(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void registerFunction(View view) {

        Intent intent = new Intent(getApplicationContext(), registerActivity.class);
        startActivity(intent);
        finish();
    }

    public void loginFunction(View view) {

        EditText user = (EditText) findViewById(R.id.editUsername);
        String strUn = user.getText().toString();
        EditText passwd = (EditText) findViewById(R.id.editPassword);
        String strPass = passwd.getText().toString();

        String password = helper.searchPassword(strUn);

        if (strPass.equals(password)) {
            Intent i = new Intent(loginActivity.this, homeActivity.class);
            startActivity(i);
            finish();
        } else {
            Toast.makeText(loginActivity.this, "Username and Password don't match", Toast.LENGTH_SHORT).show();
        }
    }
}
