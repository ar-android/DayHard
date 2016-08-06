package id.dayhard.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.dayhard.R;
import id.dayhard.model.Film;

/**
 * Created by ocittwo on 8/5/16.
 */
public class FilmViewHolder extends RecyclerView.ViewHolder{

    private ImageView img_film;
    private TextView title;
    private TextView desc;

    public FilmViewHolder(View itemView) {
        super(itemView);
        img_film = (ImageView) itemView.findViewById(R.id.img_film);
        title = (TextView) itemView.findViewById(R.id.title_film);
        desc = (TextView) itemView.findViewById(R.id.desc_film);
    }

    public void bindView(Film model, int position) {
        img_film.setImageResource(model.img);
        title.setText(model.name);
        desc.setText(model.desc);
    }
}
