package com.phong.hoclistviewcoban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListView2Activity extends AppCompatActivity {

    ListView lvData2;
    String arrData2[];
    ArrayAdapter<String> adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        addControls();
        addEvents();
    }

    private void addEvents() {
        //OnItemClickListener tức là sự kiện nhấn trên 1 dòng nào đó
        lvData2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Đối số 3 là vị trí dòng mà người dùng chọn
                Toast.makeText(ListView2Activity.this,"Bạn chọn: " + arrData2[i],Toast.LENGTH_LONG).show();
                //Hển thị lên chi tiết dữ liệu đang chọn là gì
            }
        });
        //Nhấn giữ để xoá:
        lvData2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Đối số 3 là vị trí dòng mà người dùng chọn
                String s = arrData2[i];
                adapter2.remove(s);
                return false;
            }
        });
    }

    private void addControls() {
        lvData2 = (ListView) findViewById(R.id.lvData2);
        //Lấy nguồn dữ liệu
        arrData2 = getResources().getStringArray(R.array.myArray);
        //Gán nguồn dữ liệu cho adapter2:
        /*Đối số 1 là màn hình hiện tại đang dùng
        Đối số 2 là Layout để nó vẽ lên giao diện
        Đối số 3 là nguồn dữ liệu
         */
        adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                arrData2);
        //Gán adapter cho listview:
        lvData2.setAdapter(adapter2);
    }
}
