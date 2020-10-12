package com.example.te_project_prototype1;
//login page starts
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class MainActivity extends AppCompatActivity {

    TwitterLoginButton loginButton;

    @Override
        protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_suggestions);
        TextView text1 = (TextView) findViewById(R.id.link1);
        text1.setMovementMethod(LinkMovementMethod.getInstance());
        TextView text2 = (TextView) findViewById(R.id.link2);
        text2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView text3 = (TextView) findViewById(R.id.link3);
        text3.setMovementMethod(LinkMovementMethod.getInstance());
        TextView text4 = (TextView) findViewById(R.id.link4);
        text4.setMovementMethod(LinkMovementMethod.getInstance());
        TextView text5 = (TextView) findViewById(R.id.link5);
        text5.setMovementMethod(LinkMovementMethod.getInstance());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Twitter.initialize(this);
        setContentView(R.layout.activity_main);
        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
                TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
                TwitterAuthToken authToken = session.getAuthToken();
                String token = authToken.token;
                String secret = authToken.secret;
                //textnew = token+secret;
                loginMethod(session);
            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
                Toast.makeText(getApplicationContext(),"Login fail "+exception,Toast.LENGTH_LONG).show();
            }
        });
    }
    public void loginMethod(TwitterSession twitterSession){
        String userName=twitterSession.getUserName();
        Intent intent= new Intent(MainActivity.this,MainActivity.class);
        intent.putExtra("username",userName);
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }
}
