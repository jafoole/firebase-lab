package com.example.jafoole.firebaselab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    EditText mEditText;
    Button mButton;

    ArrayList<String> mMessagesList;

    Firebase mFirebaseRootRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);
        mEditText = (EditText)findViewById(R.id.chatEditText);
        mButton = (Button) findViewById(R.id.sendButton);

        mMessagesList = new ArrayList<>();

        mFirebaseRootRef = new Firebase("https://tax-on-fire.firebaseio.com");

//        final Firebase firebaseCurrentTextRef = mFirebaseRootRef.child("current-text");
        final Firebase firebaseMessageRef = mFirebaseRootRef.child("message");

        FirebaseListAdapter<String> adapter = new FirebaseListAdapter<String>(this, String.class, android.R.layout.simple_list_item_1, firebaseMessageRef) {
            @Override
            protected void populateView(View view, String s, int i) {
                TextView textView = (TextView)view.findViewById(android.R.id.text1);
                textView.setText(s);
            }
        };

        mListView.setAdapter(adapter);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseMessageRef.push().setValue(mEditText.getText().toString());

            }
        });




    }
}
