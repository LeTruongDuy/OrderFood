package me.missyou.orderfood;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by LTDuy on 9/28/2017.
 */

public class DangNhapActivity extends AppCompatActivity {
    Button btnDongY, btnDangKy;
    EditText edTenDN, edMatKhau;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dang_nhap);

        btnDangKy = (Button) findViewById(R.id.btnDangKy);
        btnDongY = (Button) findViewById(R.id.btnDongY);

        edMatKhau = (EditText) findViewById(R.id.edMatKhau);
        edTenDN = (EditText) findViewById(R.id.edTenDN);

        btnDangKy.setVisibility(View.GONE);
    }
}
