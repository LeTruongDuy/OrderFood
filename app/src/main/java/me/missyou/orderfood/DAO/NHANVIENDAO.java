package me.missyou.orderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import me.missyou.orderfood.DTO.NHANVIENDTO;
import me.missyou.orderfood.Database.CreateDatabase;

/**
 * Created by LTDuy on 9/28/2017.
 */

public class NHANVIENDAO {
    SQLiteDatabase database;

    public NHANVIENDAO(Context context){
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }


    public int ThemNhanVien(NHANVIENDTO nhanviendto){
        ContentValues values = new ContentValues();
        values.put(CreateDatabase.TB_NHANVIEN_TENDN,nhanviendto.getTENDN());
        values.put(CreateDatabase.TB_NHANVIEN_CMND,nhanviendto.getCMND());
        values.put(CreateDatabase.TB_NHANVIEN_MATKHAU,nhanviendto.getMATKHAU());
        values.put(CreateDatabase.TB_NHANVIEN_GIOITINH,nhanviendto.getGIOITINH());
        values.put(CreateDatabase.TB_NHANVIEN_NGAYSINH,nhanviendto.getNGAYSINH());

        int kiemTra = (int) database.insert(CreateDatabase.TB_NHANVIEN,null,values);
        return kiemTra;
    }
}
