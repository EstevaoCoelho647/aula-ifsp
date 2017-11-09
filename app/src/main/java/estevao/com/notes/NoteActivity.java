package estevao.com.notes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by estevao on 07/11/17.
 */

public class NoteActivity extends AppCompatActivity{

    static ArrayList<Note> noteList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        final EditText edtTextTitle =
                    findViewById(R.id.edt_title);

        final EditText edtTextDescription =
                findViewById(R.id.edt_description);

        Button button = findViewById(R.id.button);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            Note note = (Note) extras.get("noteExtra");

        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note note = new Note();

                String title = edtTextTitle.getText().toString();
                String description = edtTextDescription
                                            .getText().toString();

                note.setTitle(title);
                note.setDescription(description);

                Toast.makeText(
                        NoteActivity.this,
                        note.getTitle(),
                        Toast.LENGTH_SHORT).show();

                noteList.add(note);

                finish();
            }
        });

    }
}
