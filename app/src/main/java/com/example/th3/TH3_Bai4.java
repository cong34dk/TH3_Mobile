package com.example.th3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TH3_Bai4 extends AppCompatActivity {
    //Khai báo các thành phần giao diện
    CheckBox chkCoffe, chkChe, chkKem, chkBim, chkSua;
    EditText txtCoffe, txtChe, txtKem, txtBim, txtSua;
    Button btnBack, btnNext, btnDatHang;

    TextView tvTong;

    List<MenuItem> selectedItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_th3_bai4);
        // ánh xạ các thành phần giao diện
        chkCoffe = (CheckBox) findViewById(R.id.chkCoffe);
        chkChe = (CheckBox) findViewById(R.id.chkChe);
        chkKem = (CheckBox) findViewById(R.id.chkKem);
        chkBim = (CheckBox) findViewById(R.id.chkBim);
        chkSua = (CheckBox) findViewById(R.id.chkSua);

        txtCoffe = findViewById(R.id.txtCoffe);
        txtChe = findViewById(R.id.txtChe);
        txtKem = findViewById(R.id.txtKem);
        txtBim = findViewById(R.id.txtBim);
        txtSua = findViewById(R.id.txtSua);

        btnDatHang = (Button) findViewById(R.id.btnDatHang);
        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);

        tvTong = findViewById(R.id.tvTong);

        // Ẩn nút Back và Next ban đầu
        btnBack.setEnabled(false);
        btnNext.setEnabled(false);

        //Đăt sự kiện cho nút Đặt hàng
        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xử lý người dùng khi đặt hàng
                calculateTotal();
                showOrderSummary();
            }
        });

    }

    // Tính tổng tiền dựa trên món được chọn và số lượng
    private void calculateTotal() {
        selectedItems.clear();
        calculateItemTotal(chkCoffe, txtCoffe, 1800);
        calculateItemTotal(chkChe, txtChe, 12000);
        calculateItemTotal(chkKem, txtKem, 10000);
        calculateItemTotal(chkBim, txtBim, 5000);
        calculateItemTotal(chkSua, txtSua, 6000);
    }

    // Tính tổng tiền cho một món và hiển thị thông báo nếu người dùng không nhập số lượng
    private void calculateItemTotal(CheckBox checkBox, EditText editText, int pricePerItem) {
        if (checkBox.isChecked()) {
            String quantityStr = editText.getText().toString().trim();
            if (!quantityStr.isEmpty()) {
                int quantity = Integer.parseInt(quantityStr);
                int total = quantity * pricePerItem;
                selectedItems.add(new MenuItem(checkBox.getText().toString(), quantity, total));
            } else {
                // Hiển thị cảnh báo nếu số lượng không được nhập
                AlertDialog.Builder builder = new AlertDialog.Builder(TH3_Bai4.this);

                builder.setMessage("Bạn chưa nhập số lượng cho \n" + checkBox.getText().toString());

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        }
    }

    // Hiển thị thông tin đơn hàng và tổng tiền
    private void showOrderSummary() {
        StringBuilder orderSummary = new StringBuilder();
        int totalAmount = 0;

        for (MenuItem item : selectedItems) {
            orderSummary.append(item.getName()).append(": ").append(item.getQuantity()).append(" x ").append(item.getPrice()).append(" VNĐ\n");
            totalAmount += item.getTotal();
        }

        orderSummary.append("\nTổng tiền: ").append(totalAmount).append(" VNĐ");
        tvTong.setText("Tổng tiền: " + totalAmount + " VND");

        // Hiển thị thông tin đơn hàng và tổng tiền trong AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin đơn hàng")
                .setMessage(orderSummary.toString())
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }

    // Lớp MenuItem để lưu thông tin món đã chọn
    private class MenuItem {
        private String name;
        private int quantity;
        private int total;

        public MenuItem(String name, int quantity, int total) {
            this.name = name;
            this.quantity = quantity;
            this.total = total;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public int getTotal() {
            return total;
        }

        public int getPrice() {
            return total / quantity;
        }
    }
}