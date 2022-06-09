package com.example.soohwankim.soohwankim_project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//Adaptors provide a binding from an app specific data set to the views display in the recycler view

public class AnotherAdaptor extends RecyclerView.Adapter<AnotherAdaptor.ViewHolder> {
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    String[] SubjectValues; // for string array
    ArrayList<String> eventArrayList;
    Context context;
    View view1;
    ViewHolder viewHolder1;
    TextView textView;

    public AnotherAdaptor(Context context1, ArrayList<String> SubjectValues1){

        eventArrayList = SubjectValues1;
        context = context1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewID;

        public ViewHolder(View v){

            super(v);

            textViewID = (TextView)v.findViewById(R.id.textViewRecyclerItem);
        }
    }

    @Override
    public AnotherAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        view1 = LayoutInflater.from(context).inflate(R.layout.recyclerview_layout,parent,false);
        viewHolder1 = new ViewHolder(view1);
        // set size of items here
        viewHolder1.itemView.getLayoutParams().height=512;

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

//        holder.textView.setText(SubjectValues[position]);
        holder.textViewID.setText(eventArrayList.get(position));
    }

    @Override
    public int getItemCount(){

//        return SubjectValues.length;
        return eventArrayList.size();
    }
}
