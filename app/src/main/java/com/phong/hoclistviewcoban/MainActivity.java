package com.phong.hoclistviewcoban;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MoManHinhListView1(View view) {
        /*Muốn mở một cửa sổ nào đó lên thì chúng ta khai báo 1 cái Intent có 2 đối số
        Đối số 1 là màn hình hiện tại
        Đối số 2 là màn hình muốn mở lên
        */
        Intent intent = new Intent(this, ListView1Activity.class);
        startActivity(intent);
    }

    public void MoManHinhListView2(View view) {
        Intent intent = new Intent(this, ListView2Activity.class);
        startActivity(intent);
    }

    public void MoManHinhListView3(View view) {
        Intent intent = new Intent(this, ListView3Activity.class);
        startActivity(intent);
    }
}
