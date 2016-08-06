package id.dayhard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.dayhard.R;
import id.dayhard.model.PeopleModel;

/**
 * Created by ocittwo on 8/5/16.
 */
public class PeopleAdapter extends BaseAdapter {

    LayoutInflater inflater;
    private ArrayList<PeopleModel> data;

    public PeopleAdapter(Context context, ArrayList<PeopleModel> data) {
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.all_people, null);

            ImageView img = (ImageView) convertView.findViewById(R.id.img_people);
            TextView title = (TextView) convertView.findViewById(R.id.title);
            TextView sub_title = (TextView) convertView.findViewById(R.id.sub_title);
            TextView desc = (TextView) convertView.findViewById(R.id.desc);
            TextView date = (TextView) convertView.findViewById(R.id.date);

            if (position == position % 2) {
                img.setVisibility(View.GONE);
            }
            img.setImageResource(data.get(position).img_people);
            title.setText(data.get(position).title);
            sub_title.setText(data.get(position).sub_title);
            desc.setText(data.get(position).desc);
            date.setText(data.get(position).date);

        }
        return convertView;
    }
}
