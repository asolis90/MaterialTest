package com.materialtest.adapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.materialtest.DataPojo;
import com.materialtest.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by angel on 8/25/2015.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    public  AppCompatActivity act;
    public List<DataPojo> data;
    LayoutInflater inflater;
    ItemClickListener itemClickListener;

    public MyRecyclerViewAdapter(AppCompatActivity a, List<DataPojo> d){
        Log.d("MYRECYCLERVIEWADAPTER", "passed");
        Log.d("list size", "" +d.size());
        this.data = d;
        this.act = a;
         inflater = LayoutInflater.from(act);
    }


    MyViewHolder holder;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.drawer_row, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        Log.d("oncreateViewHolder", "passed");
        return holder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewAdapter.MyViewHolder viewHolder, int position) {
        Log.d("onBindViewHolder", "passed");
        holder = viewHolder;
        DataPojo dpojo = data.get(position);
        String name = dpojo.getName();
        String description = dpojo.getDescription();
        int icon = dpojo.getIcon();
        holder.description.setText(description);
        holder.name.setText(name);
        holder.icon.setImageResource(icon);
    }

    public void setClickListener(ItemClickListener clickListener) {
        this.itemClickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, description;
        ImageView icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.textView_name);
            description = (TextView) itemView.findViewById(R.id.textView_description);
            icon = (ImageView) itemView.findViewById(R.id.imageView_icon);
        }

        @Override
        public void onClick(View view) {
            if(itemClickListener != null){
                itemClickListener.itemClicked(view, getAdapterPosition());
            }

        }
    }

    public interface ItemClickListener{
        public void itemClicked(View view, int position);
    }
}
