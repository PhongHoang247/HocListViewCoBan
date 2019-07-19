package com.phong.hoclistviewcoban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.phong.model.Contact;

public class ListView3Activity extends AppCompatActivity {

    EditText edtMa, edtTen, edtPhone;
    Button btnLuu;
    ListView lvContact;
    //Nguồn dữ liệu nào thì ArrayAdapter lấy kiểu đó
    ArrayAdapter<Contact> contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view3);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyThemContact();
            }
        });
        //Nhấn giữ để xoá:
        lvContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Đối số 3 là vị trí dòng mà người dùng chọn
                Contact c = contactAdapter.getItem(i);//Lấy vị trí contact mà chọn trên giao diện
                contactAdapter.remove(c);//c chính là contact trên giao diện mà ta chọn
                return false;
            }
        });
        //Nhấn vào ListView để hiển thị ngược lên
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contact c = contactAdapter.getItem(i);
                edtMa.setText(c.getId() + "");
                //Chú ý: Khi truyền kiểu int vào setText hoặc EditText sẽ bị hiểu nhầm nên phải đưa int về chuỗi
                edtTen.setText(c.getTen());
                edtPhone.setText(c.getPhone());
            }
        });
    }

    private void xuLyThemContact() {
        Contact c = new Contact();
        c.setId(Integer.parseInt(edtMa.getText().toString()));
        c.setTen(edtTen.getText().toString());
        c.setPhone(edtPhone.getText().toString());
        contactAdapter.add(c);
    }

    private void addControls() {
        edtMa = (EditText) findViewById(R.id.edtMa);
        edtTen = (EditText) findViewById(R.id.edtTen);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        btnLuu = (Button) findViewById(R.id.btnLuu);
        lvContact = (ListView) findViewById(R.id.lvContact);
        /*Đối số 1 là màn hình hiện tại đang dùng
        Đối số 2 là Layout để nó vẽ lên giao diện
         */
        contactAdapter = new ArrayAdapter<Contact>(ListView3Activity.this,
                android.R.layout.simple_list_item_1);
        //Gán adapter này cho contact
        lvContact.setAdapter(contactAdapter);
        //Trong quá trình thực thi thì đẩy contact này vào adapter thì tự động vẽ lên
    }
}
