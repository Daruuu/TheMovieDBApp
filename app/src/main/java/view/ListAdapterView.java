package view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.daru_badar.themoviedbapp.R;

import java.util.List;

import model.MovieModel;

public class ListAdapterView extends RecyclerView.Adapter<ListAdapterView.MyViewHolder> {

    private List<MovieModel> movieListModel;
    private LayoutInflater myInflater;
    private Context context;

    public ListAdapterView(List<MovieModel> itemList, Context context) {
        this.movieListModel = itemList;
        this.context = context;
        this.myInflater = LayoutInflater.from(context);
    }

    public ListAdapterView() {
    }

    /*
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);

    }

     */

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MovieModel movie = movieListModel.get(position);
        holder.id.setText(movie.getId());
        holder.title.setText(movie.getTitle());

        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" + movie.getImage())
                .into(holder.image);


    }



/*
    @Override
    public ListAdapterView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = myInflater.inflate(R.layout.list_element, null);
        return new ListAdapterView.MyViewHolder(view);
        return view;
    }
*/

    /*
    TODO: this aint works
     */
/*
    @Override
    public void onBindViewHolder(@NonNull ListAdapterView holder, int position) {
        holder.bindData(movieListModel.get(position));
    }
*/

    @Override
    public int getItemCount() {
        return movieListModel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public WindowDecorActionBar.TabImpl name;
        TextView id;
        TextView title;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.textView_name);
            title = itemView.findViewById(R.id.textView_name);
            image = itemView.findViewById(R.id.imageView);
        }
    }
}
