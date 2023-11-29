package view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daru_badar.themoviedbapp.R;

import java.util.List;

import model.MovieModel;

public class ListAdapterView extends RecyclerView.Adapter<ListAdapterView.ViewHolder> {

    private List<MovieModel> movieListModel;
    private LayoutInflater myInflater;
    private Context context;

    public ListAdapterView(List<MovieModel> itemList, Context context) {
        this.movieListModel = itemList;
        this.context = context;
        this.myInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = myInflater.inflate(R.layout.element_recycle_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(movieListModel.get(position));

    }

    @Override
    public int getItemCount() {
        return movieListModel.size();
    }

    public void setMovieListModel(List<MovieModel> movieListModel) {
        this.movieListModel = movieListModel;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView id;
        ImageView image;
        TextView title;
        TextView rating;
        TextView release_date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.idMovieTextView);
            title = itemView.findViewById(R.id.titleTextView);
            image = itemView.findViewById(R.id.iconImageView);
            rating = itemView.findViewById(R.id.ratingTextView);
            release_date = itemView.findViewById(R.id.releaseDateTextView);
        }

        /*
        cambios que se generan sobre el los distintos atributos de la cardView
         */
        void bindData(final MovieModel itemModel)
        {
            //image.setColorFilter(Color.parseColor(""),(PorterDuff.Mode.SRC_IN));
            id.setText(itemModel.getId());
            title.setText(itemModel.getTitle());
            rating.setText(itemModel.getRating());
            release_date.setText(itemModel.getReleaseDate());
        }
    }
}