package com.example.sakshiquiz.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1,mButtonChoice2,mButtonChoice3,mButtonChoice4,quit;

    TextView t1;
    String value;
    private int mScore= 0;
    private int mQuestionNumber= 1;
    private  String mAnswer;
    private Firebase mQuestionRef,mchoice1Ref,mchoice2Ref,mchoice3Ref,mchoice4Ref,mAnswerRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScoreView=(TextView) findViewById(R.id.score);
        mQuestionView=(TextView) findViewById(R.id.question);
        mButtonChoice1=(Button) findViewById(R.id.choice1);
        mButtonChoice2=(Button) findViewById(R.id.choice2);
        mButtonChoice3=(Button) findViewById(R.id.choice3);
        mButtonChoice4=(Button) findViewById(R.id.choice4);
        quit=(Button) findViewById(R.id.quit);


        updateQuestion();
        //Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice1.getText().equals(mAnswer)){
                    //Toast.makeText(MainActivity.this,"Ur answer is right"  +"  ",Toast.LENGTH_SHORT).show();
                    mScore=mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                }else{
                  //  Toast.makeText(MainActivity.this,"Ur answer is wrong" ,Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        //Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice2.getText().equals(mAnswer)){
                    mScore=mScore + 1;
                   // Toast.makeText(MainActivity.this,"Ur answer is right"  +"  ",Toast.LENGTH_SHORT).show();
                    updateScore(mScore);
                    updateQuestion();
                }else{
                   // Toast.makeText(MainActivity.this,"Your answer is wrong"  +"  ",Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        //Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice3.getText().equals(mAnswer)){
                   // Toast.makeText(MainActivity.this,"Ur answer is right"  +"  ",Toast.LENGTH_SHORT).show();
                    mScore=mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                }else{
                    //Toast.makeText(MainActivity.this,"Ur answer is wrong"  +"  ",Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        //Button4
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice4.getText().equals(mAnswer)){
                   // Toast.makeText(MainActivity.this,"Ur answer is right"  +"  ",Toast.LENGTH_SHORT).show();
                    mScore=mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                }else{
                   // Toast.makeText(MainActivity.this,"Ur answer is wrong"  +"  ",Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void updateScore(int score){

        mScoreView.setText(""+mScore);
        Toast.makeText(MainActivity.this,"Ur Score  is"  +mScore ,Toast.LENGTH_SHORT).show();

    }

    private void updateQuestion(){
        mAnswerRef=new Firebase("https://quizapp-1763f.firebaseio.com/user /"+ mQuestionNumber+"/Answer");
        mAnswerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mAnswer=dataSnapshot.getValue(String.class);
               // Toast.makeText(MainActivity.this,"Ur answer is"  +mAnswer ,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mchoice1Ref=new Firebase("https://quizapp-1763f.firebaseio.com/user /"+ mQuestionNumber+"/Choice1");

        mchoice1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice=dataSnapshot.getValue(String.class);
                mButtonChoice1.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mchoice2Ref=new Firebase("https://quizapp-1763f.firebaseio.com/user /"+ mQuestionNumber+"/Choice2");

        mchoice2Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice=dataSnapshot.getValue(String.class);
                mButtonChoice2.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mchoice3Ref=new Firebase("https://quizapp-1763f.firebaseio.com/user /"+ mQuestionNumber+"/Choice3");
        mchoice3Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice=dataSnapshot.getValue(String.class);
                mButtonChoice3.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mchoice4Ref=new Firebase("https://quizapp-1763f.firebaseio.com/user /"+ mQuestionNumber+"/Choice4");
        mchoice4Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice=dataSnapshot.getValue(String.class);
                mButtonChoice4.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mQuestionRef= new Firebase("https://quizapp-1763f.firebaseio.com/user /"+ mQuestionNumber+"/Question");
        mQuestionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String question=dataSnapshot.getValue(String.class);
                mQuestionView.setText(question);
            }


            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
           mQuestionNumber++;

    }

}
