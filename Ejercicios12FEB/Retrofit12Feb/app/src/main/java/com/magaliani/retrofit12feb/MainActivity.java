package com.magaliani.retrofit12feb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText title = (EditText) findViewById(R.id.title);
        final EditText body = (EditText) findViewById(R.id.body);

        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener((view) -> {

            Post post = new Post(
                title.getText().toString(),
                body.getText().toString()
            );

            sendNetworkRequest(post);
        });
    }
}
