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

public class ListAdapterView extends RecyclerView.Adapter<ListAdapterView, ViewHolder> {

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

    @NonNull
    @Override
    public ListAdapterView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapterView holder, int position) {

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
