package com.MohFauziRamadhan_F52124052.aplikasiuts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class HostingAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<HostingModel> hostingArrayList;

    public HostingAdapter(Context context, ArrayList<HostingModel> hostingArrayList) {
        this.context = context;
        this.hostingArrayList = hostingArrayList;
    }

    @Override
    public int getCount() {
        return hostingArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return hostingArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void updateList(ArrayList<HostingModel> newList) {
        this.hostingArrayList = newList;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_hosting, parent, false);
            holder = new ViewHolder();
            holder.imgHosting = convertView.findViewById(R.id.imgHosting);
            holder.txtNamaHosting = convertView.findViewById(R.id.txtNamaHosting);
            holder.txtKeterangan = convertView.findViewById(R.id.txtKeterangan);
            holder.txtWebsite = convertView.findViewById(R.id.txtWebsite);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        HostingModel item = hostingArrayList.get(position);

        holder.txtNamaHosting.setText(item.getNamaHosting());
        holder.txtKeterangan.setText(item.getKeterangan());
        holder.txtWebsite.setText(item.getWebsite());
        holder.imgHosting.setImageResource(item.getGambar());

        return convertView;
    }

    static class ViewHolder {
        ImageView imgHosting;
        TextView txtNamaHosting;
        TextView txtKeterangan;
        TextView txtWebsite;
    }
}
