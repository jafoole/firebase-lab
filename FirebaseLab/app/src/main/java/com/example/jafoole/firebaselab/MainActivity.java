package com.example.jafoole.firebaselab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.ui.FirebaseListAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    EditText mEditText;
    Button mButton;

    ArrayList<String> mMessagesList;

    Firebase mFirebaseRootRef;

    String mUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);
        mEditText = (EditText)findViewById(R.id.chatEditText);
        mButton = (Button) findViewById(R.id.sendButton);



        mMessagesList = new ArrayList<>();

        mFirebaseRootRef = new Firebase("https://tax-on-fire.firebaseio.com");

//        final Firebase username = mFirebaseRootRef.child("username");
        final Firebase firebaseMessageRef = mFirebaseRootRef.child("messages");
        final Firebase username = firebaseMessageRef.child("username");
        final Firebase message = username.child("message");

        final FirebaseListAdapter<String> adapter = new FirebaseListAdapter<String>(this, String.class, android.R.layout.simple_list_item_1, firebaseMessageRef) {
            @Override
            protected void populateView(View view, String s, int i) {
                String user="User:";g
                TextView textView = (TextView)view.findViewById(android.R.id.text1);
                textView.setText(user + new Random(10).nextInt() + " \n" + s);

            }
        };


        mListView.setAdapter(adapter);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseMessageRef.push().setValue(mEditText.getText().toString());

            }
        });

//        firebaseMessageRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                String userName = dataSnapshot.getValue(String.class);
//                mMessagesList.add(userName);
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });




    }
}
