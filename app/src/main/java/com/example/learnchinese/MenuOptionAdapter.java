package com.example.learnchinese;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MenuOptionAdapter extends BaseAdapter {

    private Context context;
    private List<String> categories;

    public MenuOptionAdapter(Context context) {
        this.context = context;
        categories = Categories.GetCategories();
    }


    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Inflate layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.menu_options_row, parent, false);
        }

        // Get current category to be displayed
        String currentCategory= (String) getItem(position);

        // Get the TextView to set the category String
        TextView textViewItemName = (TextView)
                convertView.findViewById(R.id.menu_option_text);

        textViewItemName.setText(currentCategory);

        // returns the view for the current row
        return convertView;

    }
}

