package com.example.lusen.telephonebook;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Student> arrayList=new ArrayList<Student>();
    Student student1 = new Student("鲁森","2015210178");
    Student student2 =new Student("刘义珂","2015210169");
    Student student3 =new Student("蒲大炮","2015210179");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);//实例化
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//决定布局
//        arrayList.add(student1);
//        arrayList.add(student2);
//        arrayList.add(student3);
        readContacts();
        recyclerView.setAdapter(new MyAdapter(arrayList,MainActivity.this));
        StudentData studentData =new StudentData(arrayList);
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

    }


    private void readContacts(){
        Cursor cursor =null;
        try {
            cursor = getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null, null, null, null);
            while (cursor.moveToNext()) {
                Student student = new Student(cursor.getString(cursor.getColumnIndex(
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)),
                        cursor.getString(cursor.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER)));
                arrayList.add(student);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (cursor!=null){
                cursor.close();
            }
        }
    }
}
