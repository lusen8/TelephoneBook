package com.example.lusen.telephonebook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lusen on 2016/11/29.
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private ArrayList<Student> arrayList;
    private Context context;

    MyAdapter(ArrayList<Student> arrayList, Context context) {    //要显示的数据
        this.arrayList=arrayList;
        this.context=context;

    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,com.example.lusen.telephonebook.Select.class);
                intent.putExtra("phonenum",arrayList.get(position).getNum());
                context.startActivity(intent);

            }
        });
        // 传数据到RecycleView中
        holder.mTextView.setText(arrayList.get(position).getname()+"\n"+arrayList.get(position).getNum());
    }

    @Override
    public int getItemCount() {         //产生表的数量
        return arrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        MyHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.name);
        }
    }
}