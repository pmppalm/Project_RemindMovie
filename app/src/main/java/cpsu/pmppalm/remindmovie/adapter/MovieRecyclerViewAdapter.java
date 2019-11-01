package cpsu.pmppalm.remindmovie.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cpsu.pmppalm.remindmovie.R;
import cpsu.pmppalm.remindmovie.database.MovieItem;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private int mLayoutResId;
    private List<MovieItem> mMovieItemList;

    public MovieRecyclerViewAdapter(Context mContext, int mLayoutResId, List<MovieItem> mMovieItemList) {
        this.mContext = mContext;
        this.mLayoutResId = mLayoutResId;
        this.mMovieItemList = mMovieItemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mLayoutResId, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MovieItem item = mMovieItemList.get(position);

        holder.nameTextView.setText(item.name);
        holder.dateTextView.setText(item.date);

    }

    @Override
    public int getItemCount() {
        return mMovieItemList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        // private ImageView ledgerTypeImageView;
        private TextView nameTextView;
        private TextView dateTextView;
        //private TextView descriptionTextView;

        private MovieItem movieItem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.nameTextView = itemView.findViewById(R.id.movie_name_textView);
            this.dateTextView = itemView.findViewById(R.id.date_textView);
            //this.descriptionTextView = itemView.findViewById(R.id.des_textView);
        }
    }
}
