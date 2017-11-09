package estevao.com.notes;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by estevao on 08/11/17.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder> {

    private ArrayList<Note> notes;
    private Context context;

    public NoteAdapter(ArrayList<Note> notes, Context context) {
        this.notes = notes;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note,
                        parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Note note = notes.get(position);

        holder.textViewTitle.setText(note.getTitle());
        holder.textViewDescription.setText(note.getDescription());

        String[] stringArray = context.
                            getResources().
                            getStringArray(R.array.card_colors);
//olar
        Random random = new Random();
        String color = stringArray[random.nextInt(5)];

        holder.linear.setBackgroundColor(Color.parseColor(color));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        TextView textViewDescription;
        LinearLayout linear;

        public MyViewHolder(View itemView) {
            super(itemView);

            linear = itemView.findViewById(
                                        R.id.parent);

            textViewTitle = itemView.findViewById(
                                        R.id.textViewTitle);
            textViewDescription = itemView.findViewById(
                                        R.id.textViewDescription);
        }
    }
}
