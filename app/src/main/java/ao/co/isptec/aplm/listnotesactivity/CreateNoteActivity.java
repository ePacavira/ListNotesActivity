package ao.co.isptec.aplm.listnotesactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import ao.co.isptec.aplm.listnotesactivity.R;

public class CreateNoteActivity extends AppCompatActivity {

    private EditText noteTitleEditText;
    private EditText noteTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        noteTitleEditText = findViewById(R.id.noteTitleEditText);
        noteTextEditText = findViewById(R.id.noteTextEditText);
        Button okButton = findViewById(R.id.okButton);
        Button cancelButton = findViewById(R.id.cancelButton);

        // Botão OK para aceitar a nota
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = noteTitleEditText.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("title", title);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        // Botão Cancel para cancelar a criação da nota
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
