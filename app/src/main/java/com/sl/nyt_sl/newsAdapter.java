package com.sl.nyt_sl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class newsAdapter extends RecyclerView.Adapter<newsAdapter.newsViewHolder>
{
    private Context mContext;
    private ArrayList<newsitem> mnewsitem;
    private OnItemClickListener mListener;

    public interface OnItemClickListener
    {
        void onItemClick(int pos);
    }
    public  void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener=listener;
    }
    public newsAdapter(Context context,ArrayList<newsitem> newslist)
    {
        mContext=context;
        mnewsitem=newslist;
    }

    @NonNull
    @Override
    public newsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view= LayoutInflater.from(mContext).inflate(R.layout.news,viewGroup,false);
        return new newsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull newsViewHolder newsViewHolder, int i)
    {
     newsitem currentnews=mnewsitem.get(i);
     String NTitle=currentnews.getNewsTitle();
     String NAbstact=currentnews.getNewsAbstract();
     String NDate=currentnews.getNewsDate();
     String NUrl=currentnews.getNewsLink();

        newsViewHolder.NewsTitle.setText(NTitle);
        newsViewHolder.NewsAbstract.setText(NAbstact);
        newsViewHolder.NewsDate.setText(NDate);
    }

    @Override
    public int getItemCount()
    {
        return mnewsitem.size();
    }

    public class newsViewHolder extends RecyclerView.ViewHolder
    {
        public TextView NewsTitle;
        public  TextView NewsAbstract;
        public  TextView NewsDate;

        public newsViewHolder(@NonNull View itemView)
        {

            super(itemView);
            NewsTitle=itemView.findViewById(R.id.NewsTitle);
            NewsAbstract=itemView.findViewById(R.id.abStract);
            NewsDate=itemView.findViewById(R.id.newsDate);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view)
                {
                    if(mListener!=null)
                    {
                        int position= getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION);
                        {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
