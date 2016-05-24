package com.example.sandumihai.discovertheworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {

    DataBaseHelperLogin helperLogin=new DataBaseHelperLogin(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void confirmClick(View v) {

        EditText email = (EditText) findViewById(R.id.editTextEmailRegister);
        EditText username = (EditText) findViewById(R.id.editTextUsernameRegister);
        EditText password = (EditText) findViewById(R.id.editTextPasswordRegister);
        EditText retypePass = (EditText) findViewById(R.id.editTextRetypePasswordRegister);

        String emailstr = email.getText().toString();
        String usernamestr = username.getText().toString();
        String passstr = password.getText().toString();
        String retypepassstr = retypePass.getText().toString();

        if (!passstr.equals(retypepassstr)) {
            Toast pass = Toast.makeText(registerActivity.this, "Passwords don't match! Please retype.", Toast.LENGTH_SHORT);
            pass.show();
        } else if(passstr.length() <= 5) {
            Toast pass = Toast.makeText(registerActivity.this, "Password to short. Minimum length is 6 characters.", Toast.LENGTH_SHORT);
            pass.show();
        } else if (emailstr.length()<=3 || usernamestr.length() <= 2 ) {
            Toast pass = Toast.makeText(registerActivity.this, "User Name or email is invalid.", Toast.LENGTH_SHORT);
            pass.show();
        } else {
            Contact contact = new Contact();
            contact.setEmail(emailstr);
            contact.setUsername(usernamestr);
            contact.setPassword(passstr);
            helperLogin.insertUser(contact);

            Intent intent = new Intent(getApplicationContext(), homeActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void cancelClick(View view) {
        Intent intent = new Intent(getApplicationContext(), loginActivity.class);
        startActivity(intent);
        finish();
    }
}
