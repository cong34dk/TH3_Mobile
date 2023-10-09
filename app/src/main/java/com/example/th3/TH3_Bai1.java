package com.example.th3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TH3_Bai1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_th3_bai1);

    }

    //Phương thức tính tổng
    public void TongTien(View v) {
        int Tong = 0;
        // Khai báo điều khiển
        RadioGroup radioGroup = findViewById(R.id.radioGroup1);
        TextView tv = findViewById(R.id.tvTong);

        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

        if (selectedRadioButtonId == R.id.rbCanhGaRan) {
            Tong = 89000;
        } else if (selectedRadioButtonId == R.id.rbDuiGaRan) {
            Tong = 92000;
        } else if (selectedRadioButtonId == R.id.rbCombo) {
            Tong = 156000;
        } else if (selectedRadioButtonId == R.id.rbThucAnPhu) {
            Tong = 34000;
        }

        tv.setText(Tong + "");

    }
}