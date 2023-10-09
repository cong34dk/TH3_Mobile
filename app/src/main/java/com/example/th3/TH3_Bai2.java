package com.example.th3;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class TH3_Bai2 extends AppCompatActivity {

    private CheckBox checkBoxRed, checkBoxBlue, checkBoxYellow;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_th3_bai2);

        //Ánh xạ
        checkBoxRed = findViewById(R.id.checkBoxRed);
        checkBoxBlue = findViewById(R.id.checkBoxBlue);
        checkBoxYellow = findViewById(R.id.checkBoxYellow);
        textView = findViewById(R.id.textView);

        // Thiết lập sự kiện cho các CheckBox
        checkBoxRed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTextViewColor();
            }
        });

        checkBoxBlue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTextViewColor();
            }
        });

        checkBoxYellow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTextViewColor();
            }
        });
    }

    // Phương thức để cập nhật màu chữ của TextView dựa trên trạng thái của các CheckBox
    private void updateTextViewColor() {
        int textColor = Color.WHITE; // Màu mặc định

        if (checkBoxRed.isChecked()) {
            textColor = Color.RED;
        } else if (checkBoxBlue.isChecked()) {
            textColor = Color.BLUE;
        } else if (checkBoxYellow.isChecked()) {
            textColor = Color.YELLOW;
        }

        textView.setTextColor(textColor);
    }
}
