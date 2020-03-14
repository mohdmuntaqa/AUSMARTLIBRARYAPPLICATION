package com.demotxt.myapp.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aws on 28/01/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> implements Filterable{

    private Context mContext;
    private ArrayList<Book> mData;
    private ArrayList<Book> mFilteredData;


    public RecyclerViewAdapter(Context mContext, ArrayList<Book> mData) {
        this.mContext = mContext;
        this.mData = mData;
        this.mFilteredData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardveiw_item_book, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_book_title.setText(mFilteredData.get(position).getTitle());
        holder.img_book_thumbnail.setImageResource(mFilteredData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, Book_Activity.class);

                // passing data to the book activity
                intent.putExtra("Title", mFilteredData.get(position).getTitle());
                intent.putExtra("Description", mFilteredData.get(position).getDescription());
                intent.putExtra("Thumbnail", mFilteredData.get(position).getThumbnail());
                intent.putExtra("PDFAsset", mFilteredData.get(position).getPDFAsset());
                intent.putExtra("Author", mFilteredData.get(position).getAuthorName());
                // start the activity
                mContext.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        Log.d("TEst", this.mFilteredData.get(0).getTitle());
        return this.mFilteredData.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    mFilteredData = mData;
                } else {
                    ArrayList<Book> filteredList = new ArrayList<>();
                    for (Book row : mData) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getTitle().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    mFilteredData = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredData;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredData = (ArrayList<Book>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_book_title = (TextView) itemView.findViewById(R.id.book_title_id);
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.book_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }


}
