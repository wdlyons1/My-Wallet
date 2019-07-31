package com.finalproject.mywallet;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private Context mContext;
    private Cursor mCursor;

    public RecyclerViewAdapter(Context context, Cursor cursor) {
            mContext = context;
            mCursor = cursor;
        }

        public class RecyclerViewHolder extends RecyclerView.ViewHolder {
            public TextView nameText;
            public TextView email;
            public TextView amount;

            public RecyclerViewHolder(View itemView) {
                super(itemView);

                nameText = itemView.findViewById(R.id.name);
                email = itemView.findViewById(R.id.email);
                amount = itemView.findViewById(R.id.amount);
            }
        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View view = inflater.inflate(R.layout.layout_recyclerview, parent, false);
            return new RecyclerViewHolder(view);
        }


    @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            if (!mCursor.moveToPosition(position)) {
                return;
            }

            String name = (mCursor.getString(mCursor.getColumnIndex(Database.col2)) + " " + mCursor.getString(mCursor.getColumnIndex(Database.col3)));
            int amount = mCursor.getInt(mCursor.getColumnIndex(Database.colll3));
            String email = mCursor.getString(mCursor.getColumnIndex(Database.coll1));

            holder.nameText.setText(name);
            holder.amount.setText(String.valueOf(amount));
            holder.email.setText(email);
        }

        @Override
        public int getItemCount() {
            return mCursor.getCount();
        }

        public void swapCursor(Cursor newCursor) {
            if (mCursor != null) {
                mCursor.close();
            }

            mCursor = newCursor;

            if (newCursor != null) {
                notifyDataSetChanged();
            }
        }
    }
    
    
    
    
    

