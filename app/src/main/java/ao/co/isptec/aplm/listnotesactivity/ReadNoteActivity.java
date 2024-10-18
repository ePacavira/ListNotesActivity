package ao.co.isptec.aplm.listnotesactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReadNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_note);

        TextView noteTitleTextView = findViewById(R.id.noteTitleTextView);
        TextView noteTextTextView = findViewById(R.id.noteTextTextView);

        // Obtém os dados da nota da intenção
        String title = getIntent().getStringExtra("title");
        noteTitleTextView.setText(title);

        // Como exemplo, o texto da nota está sendo exibido como "Sample text"
        noteTextTextView.setText("Sample text");
    }
}
