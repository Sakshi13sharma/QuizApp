package com.example.sakshiquiz.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

public class DeleteActivity extends AppCompatActivity {
    private Firebase mQuestionRef;
    private int mQuestionNumber;
    EditText number;
    String checknum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        Button del = (Button) findViewById(R.id.deleteme);
        number = (EditText) findViewById(R.id.num);
        checknum = number.getText().toString();
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = number.getText().toString().trim();
                mQuestionRef = new Firebase("https://quizapp-1763f.firebaseio.com/user /");
                Toast.makeText(DeleteActivity.this, "Ur ref is" + mQuestionRef, Toast.LENGTH_LONG).show();
                Query delQuery = mQuestionRef.child(num);

                delQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot appleSnapshot : dataSnapshot.getChildren()) {
                            appleSnapshot.getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });


            }
        }); }


    }

















