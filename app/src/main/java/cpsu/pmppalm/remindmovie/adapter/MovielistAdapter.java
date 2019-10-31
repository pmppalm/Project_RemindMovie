package cpsu.pmppalm.remindmovie.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import cpsu.pmppalm.remindmovie.R;
import cpsu.pmppalm.remindmovie.model.MovieItem;

public class MovielistAdapter extends ArrayAdapter<MovieItem> {
    private Context tContext;
    private int tResource;
    private List<MovieItem> MovieItemList;

    public MovielistAdapter(@NonNull Context context, int resource, @NonNull List<MovieItem> movieItemList) {
        super(context, resource,movieItemList);
        this.tContext = context;
        this.tResource = resource;
        this.MovieItemList = movieItemList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)tContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(tResource,parent,false);
        MovieItem movieItem = MovieItemList.get(position);
        TextView movieNameTextView = view.findViewById(R.id.movie_name_textView);
        movieNameTextView.setText(movieItem.name);
        TextView dateMovieTextView = view.findViewById(R.id.date_textView);
        dateMovieTextView.setText(movieItem.date);

        ImageView logoImageView = view.findViewById(R.id.logo_image_view);
        logoImageView.setImageResource(movieItem.imageRes);

        return view;
    }
}
