package com.example.sakshiquiz.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;

public class AddActivity extends AppCompatActivity {

    private EditText editquestion, editmChoice1, mChoice2, mChoice3, mChoice4, answerofquestion,question;
    private Button mClear;
    private Button saveQuestions;
    private Firebase savereferences;
    private DatabaseReference dbref;
    String que;
    int number=0;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        question = (EditText) findViewById(R.id.question);
        editquestion = (EditText) findViewById(R.id.questionadd);
        editmChoice1 = (EditText) findViewById(R.id.choice11);
        mChoice2 = (EditText) findViewById(R.id.choice21);
        mChoice3 = (EditText) findViewById(R.id.choice31);
        mChoice4 = (EditText) findViewById(R.id.choice41);
        answerofquestion = (EditText) findViewById(R.id.answerofquestion);
       mClear = (Button) findViewById(R.id.clear_btn);
        saveQuestions = (Button) findViewById(R.id.savemyquestions);
        Firebase.setAndroidContext(this);
        saveQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savereferences = new Firebase("https://quizapp-1763f.firebaseio.com/user ");

                //    FirebaseDatabase database= FirebaseDatabase.getInstance();
                //  DatabaseReference root=database.getReference("https://quiz-77f0b.firebaseio.com/");

                Questions ques = new Questions();
                String que = question.getText().toString().trim();
                String myques = editquestion.getText().toString().trim();
                String choice1 = editmChoice1.getText().toString().trim();
                String choice2 = mChoice2.getText().toString();
                String choice3 = mChoice3.getText().toString();
                String choice4 = mChoice4.getText().toString();
                String myans = answerofquestion.getText().toString();
                //Adding values
                if(choice1!=choice2 && choice2!=choice3 && choice3!=choice4)

                ques.setQuestion(myques);
                ques.setChoice1(choice1);
                ques.setChoice2(choice2);
                ques.setChoice3(choice3);
                ques.setChoice4(choice4);
                ques.setAnswer(myans);
                Firebase User1 = savereferences.child(que);

                //  String myques=question.getText().toString();
                //String myoption1=mChoice1.getText().toString();

                User1.child("Question").setValue(myques);
                User1.child("Choice1").setValue(choice1);
                User1.child("Choice2").setValue(choice2);
                User1.child("Choice3").setValue(choice3);
                User1.child("Choice4").setValue(choice4);
                User1.child("Answer").setValue(myans);
                finish();
            }
        });
        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.clear_btn);
                question.setText("");
                editquestion.setText("");
                editmChoice1.setText("");
                mChoice2.setText("");
                mChoice3.setText("");
                mChoice4.setText("");
                answerofquestion.setText("");
            }
        });

    }

}
