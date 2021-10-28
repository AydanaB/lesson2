package com.example.firstapp;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ServiceConnection;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView0,textView1, textView2, textView3;
    private EditText user, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button_show_toast);
        textView0 = findViewById(R.id.text0);
        textView1 = findViewById(R.id.text);
        textView2 = findViewById(R.id.text1);
        textView3 = findViewById(R.id.text2);
        user = findViewById(R.id.edit_user);
        password = findViewById(R.id.edit_password);

        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String userS = user.getText().toString();
                    if (TextUtils.isEmpty(userS)){
                        button.setBackgroundColor(Color.parseColor("#9C9797"));
                    }else{
                        button.setBackgroundColor(Color.parseColor("#FF9800"));
                    }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String passwordS = password.getText().toString();
                if (TextUtils.isEmpty(passwordS)){
                    button.setBackgroundColor(Color.parseColor("#9C9797"));
                }else{
                    button.setBackgroundColor(Color.parseColor("#FF9800"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (user.getText().toString().equals("admin@gmail.com") && password.getText().toString().equals("admin")){
                Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                if (button.getVisibility() == View.VISIBLE){
                    button.setVisibility(View.GONE);
                }else {
                    button.setVisibility(View.VISIBLE);
                }
                setAlfa(textView0);
                setAlfa(textView2);
                setAlfa(textView3);
                setAlfa(user);
                setAlfa(password);
            }else {
                Toast.makeText(MainActivity.this, "Неправельный логин или пароль", Toast.LENGTH_SHORT).show();
            }
        }
    });
    }

    private void setAlfa(TextView textView){
        if (textView.getVisibility() == View.VISIBLE){
            textView.setVisibility(View.GONE);
        }else {
            textView.setVisibility(View.VISIBLE);
        }
    }

    private void setAlfa(EditText editText){
        if (editText.getVisibility() == View.VISIBLE){
            editText.setVisibility(View.GONE);
        }else {
            editText.setVisibility(View.VISIBLE);
        }
    }

}