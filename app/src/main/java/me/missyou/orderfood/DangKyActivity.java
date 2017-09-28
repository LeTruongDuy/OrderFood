package me.missyou.orderfood;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import me.missyou.orderfood.DAO.NHANVIENDAO;
import me.missyou.orderfood.DTO.NHANVIENDTO;
import me.missyou.orderfood.Database.CreateDatabase;
import me.missyou.orderfood.Fragment.DatePickerFragment;

public class DangKyActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener{
    EditText edTenDN, edCMND, edMatKhau, edNgaySinh;
    Button btnDongY, btnThoat;
    RadioGroup rgGioiTinh;
    String sGioiTinh;
    NHANVIENDAO nhanviendao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangky);

        edTenDN = (EditText) findViewById(R.id.edTenDN);
        edCMND = (EditText) findViewById(R.id.edCMND);
        edNgaySinh = (EditText) findViewById(R.id.edNgaySinh);
        edMatKhau = (EditText) findViewById(R.id.edMatKhau);

        btnDongY = (Button) findViewById(R.id.btnDongY);
        btnThoat = (Button) findViewById(R.id.btnThoat);

        rgGioiTinh = (RadioGroup) findViewById(R.id.rgGioiTinh);

        btnDongY.setOnClickListener(this);
        btnThoat.setOnClickListener(this);

        edNgaySinh.setOnFocusChangeListener(this);

        nhanviendao = new NHANVIENDAO(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnDongY:
                String tenDN = edTenDN.getText().toString();
                String matKhau = edMatKhau.getText().toString();

                switch (rgGioiTinh.getCheckedRadioButtonId()){
                    case R.id.rNam:
                        sGioiTinh = "Nam";
                        break;
                    case R.id.rNu:
                        sGioiTinh = "Nữ";
                        break;
                }

                String sNgaySinh = edNgaySinh.getText().toString();
                String sCMND = edCMND.getText().toString();

                if(tenDN == null || tenDN.equals("")){
                    Toast.makeText(DangKyActivity.this,R.string.nhap_ten_dang_nhap,Toast.LENGTH_SHORT).show();
                }else if(matKhau == null || matKhau.equals("")){
                    Toast.makeText(DangKyActivity.this,R.string.mat_khau_rong,Toast.LENGTH_SHORT).show();
                }else{
                    NHANVIENDTO nhanviendto = new NHANVIENDTO();

                    nhanviendto.setCMND(Integer.parseInt(sCMND));
                    nhanviendto.setGIOITINH(sGioiTinh);
                    nhanviendto.setNGAYSINH(sNgaySinh);
                    nhanviendto.setMATKHAU(matKhau);
                    nhanviendto.setTENDN(tenDN);
                    int kiemTra = nhanviendao.ThemNhanVien(nhanviendto);

                    if(kiemTra != 0){
                        Toast.makeText(DangKyActivity.this,R.string.them_thanh_cong,Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(DangKyActivity.this,R.string.them_that_bai,Toast.LENGTH_SHORT).show();
                    }
                }


                break;
            case R.id.btnThoat:
                finish();
                break;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        int id = v.getId();
        switch (id){
            case R.id.edNgaySinh:
                if(hasFocus){
                    //xuất popup ngày sinh
                    DatePickerFragment datePickerFragment = new DatePickerFragment();
                    datePickerFragment.show(getFragmentManager(),"Ngày sinh");
                }
                break;
        }
    }
}
