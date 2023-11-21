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


public class AdapterView extends RecyclerView.Adapter<AdapterView.MyViewHolder> {

    private Context myContext;
    private List<MovieModel> listMovies;

    public AdapterView(Context myContext, List<MovieModel> listMovies) {
        this.myContext = myContext;
        this.listMovies = listMovies;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(myContext);
        view = inflater.inflate(R.layout.fragment_second, parent, false);
        return new MyViewHolder(view);
    }
/*

    @Override
    public void onBindViewHolder(@NonNull AdapterView holder, int position) {

    }
*/

    /*
    set the data to display
     */
    @Override
    public void onBindViewHolder(@NonNull AdapterView.MyViewHolder holder, int position) {
        holder.id.setText(listMovies.get(position).getId());
        holder.name.setText(listMovies.get(position).getName());
        //TODO: import library in grade to can renderize

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView id;
        TextView name;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.textView_name);
            name = itemView.findViewById(R.id.textView_name);
            image = itemView.findViewById(R.id.imageView);
        }
    }
}
