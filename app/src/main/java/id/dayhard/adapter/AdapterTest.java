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
import id.dayhard.model.KotaKabupaten;

/**
 * Created by ocittwo on 8/4/16.
 */
public class AdapterTest extends BaseAdapter {

    private ArrayList<KotaKabupaten> kotaKabupatens;
    private LayoutInflater inflater;

    public AdapterTest(Context context, ArrayList<KotaKabupaten> kotaKabupatens) {
        inflater = LayoutInflater.from(context);
        this.kotaKabupatens = kotaKabupatens;
    }

    @Override
    public int getCount() {
        return kotaKabupatens.size();
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
        convertView = inflater.inflate(R.layout.list_kota_kabupaten, null);

        ViewHolder holder = new ViewHolder();
        holder.title = (TextView) convertView.findViewById(R.id.title);
        holder.desc = (TextView) convertView.findViewById(R.id.desc);
        holder.img = (ImageView) convertView.findViewById(R.id.img);

        convertView.setTag(holder);

        holder.title.setText(kotaKabupatens.get(position).name);
        if (kotaKabupatens.get(position).type == 0){
            holder.desc.setText("Kota");
        }else{
            holder.desc.setText("Kabupaten");
        }
        holder.img.setImageResource(R.drawable.img_kota);
        return convertView;
    }

    class ViewHolder{
        TextView title;
        TextView desc;
        ImageView img;
    }
}
