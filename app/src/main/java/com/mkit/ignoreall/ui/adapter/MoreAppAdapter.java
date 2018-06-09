package com.mkit.ignoreall.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.mkit.ignoreall.R;
import com.mkit.ignoreall.app.model.MoreAppModel;
import com.mkit.ignoreall.app.utils.AppUtil;

import java.util.List;

public class MoreAppAdapter extends ArrayAdapter<MoreAppModel> {
    private Context context;
    private int resource;
    private List<MoreAppModel> objects;


    public MoreAppAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<MoreAppModel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects != null ? objects.size() : 0;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MoreAppAdapter.ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_item_more_app, parent, false);
            holder = new MoreAppAdapter.ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (MoreAppAdapter.ViewHolder) convertView.getTag();
        }
        if(AppUtil.checkNull(getItem(position).getName())){
            holder.btnApp.setText(getItem(position).name);
            holder.btnApp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(AppUtil.checkNull(getItem(position).getUrl())){
                        try {
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getItem(position).getUrl())));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }



        return convertView;
    }

    private class ViewHolder {
        TextView btnApp;

        public ViewHolder(View view) {
            btnApp = view.findViewById(R.id.btn_app);

        }
    }
}