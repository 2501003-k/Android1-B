package com.example.projectweek04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        setTitle("View");

        CheckBox checkRead = findViewById(R.id.checkRead);
        CheckBox checkTravel = findViewById(R.id.checkTravel);
        CheckBox checkGame = findViewById(R.id.checkGame);
        Button btnSelect = findViewById(R.id.btnSelect);
        TextView txtResult = findViewById(R.id.txtResult);

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hobby = "";

                // 체크된 것만 차례대로 이어 붙이기
                if (checkRead.isChecked()) {
                    hobby += "독서";
                }
                if (checkTravel.isChecked()) {
                    if (!hobby.isEmpty()) hobby += ", ";
                    hobby += "여행";
                }
                if (checkGame.isChecked()) {
                    if (!hobby.isEmpty()) hobby += ", ";
                    hobby += "게임";
                }

                // 하나도 선택 안 했으면 Toast
                if (hobby.isEmpty()) {
                    Toast.makeText(getBaseContext(), "취미를 선택해주세요.", Toast.LENGTH_SHORT).show();
                    txtResult.setText("");
                } else {
                    txtResult.setText("선택한 취미 : " + hobby);
                }
            }
        });
    }
}