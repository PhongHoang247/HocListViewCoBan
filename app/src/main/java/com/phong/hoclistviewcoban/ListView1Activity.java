package com.phong.hoclistviewcoban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListView1Activity extends AppCompatActivity {

    ListView lvData1;
    String arrData[] = {"Hà Nội", "Đà Nẵng", "Nha Trang", "Phú Quốc", "Vũng Tàu", "Cần Thơ", "Quảng Ninh","Hà Giang", "Cao Bằng"
    , "Đà Lạt","Cần Thơ","Tiền Giang","Lào Cai","Yên Bái","Buôn Ma Thuật","Agasdian"};//Tạo sẵn một nguồn
    //Nguồn có kiểu gì thì ArrayAdapter có kiểu đó
    ArrayAdapter<String> adapter;
    //ArrayAdapter phụ thuộc vào nguồn dữ liệu
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view1);
        addControls();
        addEvents();
    }

    private void addEvents() {
        //OnItemClickListener tức là sự kiện nhấn trên 1 dòng nào đó
        lvData1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Đối số 3 là vị trí dòng mà người dùng chọn
                Toast.makeText(ListView1Activity.this,"Bạn chọn: " + arrData[i],Toast.LENGTH_LONG).show();
                //Hển thị lên chi tiết dữ liệu đang chọn là gì
            }
        });
    }

    private void addControls() {
        lvData1 = (ListView) findViewById(R.id.lvData1);
        //Tạo Adapter và gán nguồn dữ liệu:
        /*Đối số 1 là màn hình hiện tại đang dùng
        Đối số 2 là Layout để nó vẽ lên giao diện
        Đối số 3 là nguồn dữ liệu
         */
        adapter = new ArrayAdapter<String>(ListView1Activity.this,
                android.R.layout.simple_list_item_1,
                arrData);
        //Gán adapter cho ListView:
        lvData1.setAdapter(adapter);
    }
}
