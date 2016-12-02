package com.example.lusen.telephonebook;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by lusen on 2016/12/2.
 */

public class Select extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.function);
        Intent intent = getIntent();
        final String phonenum = intent.getStringExtra("phonenum");
        TextView telephone = (TextView) findViewById(R.id.telephone);
        TextView letter = (TextView) findViewById(R.id.sendletter);
        TextView delete = (TextView) findViewById(R.id.delete);
        telephone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phonenum)); //将号码传到拨号软件中。
                startActivity(intent);  //启动拨号软件
            }
        });
        letter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData((Uri.parse("smsto:"+phonenum)));
                startActivity(intent);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
     }
}
