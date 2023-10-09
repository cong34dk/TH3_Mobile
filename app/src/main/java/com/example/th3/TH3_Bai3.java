package com.example.th3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class TH3_Bai3 extends AppCompatActivity {

    private int score = 0;
    private RadioButton rdo1, rdo2, rdo3;
    private CheckBox cboWorker, cboFarmer, cboTeacher;
    private RadioButton rdoMale, rdoFemale;
    private RadioButton rdoPlay, rdoWorking, rdoSleeping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_th3_bai3);

        // Ánh xạ
        rdo1 = findViewById(R.id.rdo1);
        rdo2 = findViewById(R.id.rdo2);
        rdo3 = findViewById(R.id.rdo3);
        cboWorker = findViewById(R.id.cboWorker);
        cboFarmer = findViewById(R.id.cboFarmer);
        cboTeacher = findViewById(R.id.cboTeacher);
        rdoMale = findViewById(R.id.rdoMale);
        rdoFemale = findViewById(R.id.rdoFemale);
        rdoPlay = findViewById(R.id.rdoPlay);
        rdoWorking = findViewById(R.id.rdoWorking);
        rdoSleeping = findViewById(R.id.rdoSleeping);

        // Xử lý khi nút "Next" được bấm
        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Kiểm tra câu trả lời và cộng điểm
                if (cboTeacher.isChecked() && !cboWorker.isChecked() && !cboFarmer.isChecked()) {
                    score += 10;
                }
                if (rdo1.isChecked()) {
                    score += 10;
                }
                if (rdoMale.isChecked()) {
                    score += 10;
                }
                if (rdoWorking.isChecked()) {
                    score += 10;
                }

                // Hiển thị điểm bằng AlertDialog
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TH3_Bai3.this);
                alertDialogBuilder.setTitle("Kết quả kiểm tra");
                alertDialogBuilder.setMessage("Điểm của bạn là: " + score + " điểm");
                alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Đặt lại điểm và làm mới các câu hỏi
                        score = 0;
                        resetQuestions();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }

    // Đặt lại các câu hỏi và câu trả lời
    private void resetQuestions() {
        rdo1.setChecked(false);
        rdo2.setChecked(false);
        rdo3.setChecked(false);
        cboWorker.setChecked(false);
        cboFarmer.setChecked(false);
        cboTeacher.setChecked(false);
        rdoMale.setChecked(false);
        rdoFemale.setChecked(false);
        rdoPlay.setChecked(false);
        rdoWorking.setChecked(false);
        rdoSleeping.setChecked(false);
    }
}
