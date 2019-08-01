package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUpActivity extends AppCompatActivity {


    private EditText etUsername1, etUsername2, etPassword1, etPassword2;
    //private Button btSignup, btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUsername1 = (EditText) findViewById(R.id.etUsername1);
        etUsername2 = (EditText) findViewById(R.id.etUsername2);
        etPassword1 = (EditText) findViewById(R.id.etPassword1);
        etPassword2 = (EditText) findViewById(R.id.etPassword2);
//        btSignup = (Button) findViewById(R.id.btSignup);
//        btLogin = (Button) findViewById(R.id.btLogin);

    }


    public void clickSignup(View view){
        final ParseUser user = new ParseUser();

        String username = etUsername1.getText().toString();
        String password = etPassword1.getText().toString();

        user.setUsername(username);
        user.setPassword(password);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e!=null){
                    FancyToast.makeText(SignUpActivity.this,e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                }else{
                    FancyToast.makeText(SignUpActivity.this,user.getUsername() + " created!",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                }
            }
        });
    }

    public void clickLogin(View view){

        String username = etUsername2.getText().toString();
        String password = etPassword2.getText().toString();

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e!=null){
                    FancyToast.makeText(SignUpActivity.this,e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                }else{
                    FancyToast.makeText(SignUpActivity.this,user.getUsername() + " login succesfull!",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                }
            }
        });
    }
}

