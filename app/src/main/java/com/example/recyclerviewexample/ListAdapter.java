package com.example.recyclerviewexample;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
   private List<ListElemtn> mData;
   private LayoutInflater mInflater;
   private Context context;

   public ListAdapter(List<ListElemtn> itemList, Context context){
    this.mInflater = LayoutInflater.from(context);
    this.context= context;
    this.mData = itemList;
   }

   @Override
    public int getItemCount(){ return mData.size(); }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view =mInflater.inflate(R.layout.list_element,null);
        return new ListAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
    }


    public  void setItems(List<ListElemtn> items){ mData= items; }

    public class ViewHolder extends  RecyclerView.ViewHolder{
       ImageView iconImage;
       TextView name, city, status;
       ViewHolder(View itemView){
           super(itemView);
           iconImage= itemView.findViewById(R.id.inconImageView);
           name = itemView.findViewById(R.id.tvname);
       }

        public void bindData(ListElemtn item) {
           iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
           name.setText(item.getName());
        }
    }
}
