package com.example.te_project_prototype1;
//kirti
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class SuggestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);
        TextView text = (TextView) findViewById(R.id.link1);
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
