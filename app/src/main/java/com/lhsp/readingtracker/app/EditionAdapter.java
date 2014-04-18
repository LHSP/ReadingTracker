package com.lhsp.readingtracker.app;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.lhsp.readingtracker.R;

/**
 * Created by LHSP on 15/03/14.
 */
public class EditionAdapter extends ArrayAdapter<Edition> {

    Context context;
    int layoutResourceId;
    Edition data[] = null;

    public EditionAdapter(Context context, int layoutResourceId, Edition[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        EditionHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new EditionHolder();
            holder.tvEditionTitle = (TextView)row.findViewById(R.id.tvEditionTitle);
            holder.cbEditionAcquired = (CheckBox)row.findViewById(R.id.cbEditionAcquired);

            row.setTag(holder);
        }
        else
        {
            holder = (EditionHolder)row.getTag();
        }

        Edition edition = data[position];
        holder.tvEditionTitle.setText(edition.title);
        holder.cbEditionAcquired.setChecked(edition.acquired);

        return row;
    }

    static class EditionHolder
    {
        TextView tvEditionTitle;
        CheckBox cbEditionAcquired;
    }
}
