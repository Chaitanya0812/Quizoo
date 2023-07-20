package com.example.quizoo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private String[] questions={"Does Java supports OOPS?","Java was intoduced in 2002?","Was Java created using python?","Does Java has abstract classes?"
        ,"Does Java supports interface?"};
    private boolean[] answers = {false,false,false,true,true};
    private int score = 0;
    Button yes;
    Button no;
    TextView question;
    private int index =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question = findViewById(R.id.question);
        question.setText(questions[0]);
        Toast.makeText(MainActivity.this, "Get ready for quiz!!!!",Toast.LENGTH_SHORT).show();
        yes.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                if(index<=questions.length-1)
                {
                    if(answers[index]==true)
                    {
                        score++;
                    }
                    index++;
                    if(index<=questions.length-1)
                    {
                        question.setText(questions[index]);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Your score is:"+" "+score,Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(MainActivity.this,"Restart the app to play again",Toast.LENGTH_SHORT).show();
                }

            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(index<=questions.length-1)
                {
                    if(!answers[index])
                    {
                        score++;
                    }
                    index++;
                    if(index<=questions.length-1)
                    {
                        question.setText(questions[index]);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Your score is:"+" "+score+"/"+questions.length,Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(MainActivity.this,"Restart the app to play again",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}