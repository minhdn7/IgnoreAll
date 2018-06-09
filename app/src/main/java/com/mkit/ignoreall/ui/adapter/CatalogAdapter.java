package com.mkit.ignoreall.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mkit.ignoreall.R;
import com.mkit.ignoreall.app.model.CatalogModel;
import com.mkit.ignoreall.app.utils.AppUtil;
import com.mkit.ignoreall.ui.activity.HomeActivity;
import com.mkit.ignoreall.ui.activity.MoreAppActivity;

import java.util.List;


public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.MyViewHolder> {
    private List<CatalogModel> datalist;
    private Context mContext;
    private HomeActivity homeActivity;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_desc, tv_title;
        public ImageView imgShareFace, imageViewItem;
        public LinearLayout lo_item_uu_dai;

        public MyViewHolder(View view) {
            super(view);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            tv_title = itemView.findViewById(R.id.tv_title);
            imgShareFace = itemView.findViewById(R.id.imgShareFace);
            imageViewItem = itemView.findViewById(R.id.imageViewItem);
            lo_item_uu_dai = itemView.findViewById(R.id.lo_item_uu_dai);

        }
    }

    public CatalogAdapter(Context mContext, List<CatalogModel> datalist, HomeActivity homeActivity) {
        this.mContext = mContext;
        this.datalist = datalist;
        this.homeActivity = homeActivity;
    }

    @Override
    public CatalogAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new CatalogAdapter.MyViewHolder(inflater.inflate(R.layout.custom_item_catalog, parent, false));
    }


    @Override
    public void onBindViewHolder(final CatalogAdapter.MyViewHolder holder, final int position) {
        final CatalogModel newItem = datalist.get(position);
        Typeface face= Typeface.createFromAsset(mContext.getAssets(), "fonts/SFUFuturaBook.TTF");
        final Typeface face2= Typeface.createFromAsset(mContext.getAssets(), "fonts/SFUFuturaHeavy.TTF");

        if (AppUtil.checkNull(newItem.getTitle())){
            holder.tv_title.setText(String.valueOf(newItem.getTitle()));
            holder.tv_title.setTypeface(face2);
        }
        if (AppUtil.checkNull(newItem.getDescription())){
            holder.tv_desc.setText(String.valueOf(newItem.getDescription()));
            holder.tv_desc.setTypeface(face2);
        }
        if (AppUtil.checkNull(newItem.getIdImage())){
            holder.imageViewItem.setImageDrawable(mContext.getResources().getDrawable(newItem.getIdImage()));
            holder.tv_desc.setTypeface(face2);
        }

        holder.lo_item_uu_dai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0){
                    homeActivity.showDataEbook();
                }else if(position == 1){
                    mContext.startActivity(new Intent(homeActivity, MoreAppActivity.class));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }



}
