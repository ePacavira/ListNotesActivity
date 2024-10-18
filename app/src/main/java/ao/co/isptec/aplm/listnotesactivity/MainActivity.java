package ao.co.isptec.aplm.listnotesactivity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> notesTitles = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notes);

        ListView notesListView = findViewById(R.id.notesListView);
        Button newNoteButton = findViewById(R.id.newNoteButton);

        // Adapta a lista de notas
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notesTitles);
        notesListView.setAdapter(adapter);

        // Botão para criar nova nota
        newNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicia a CreateNoteActivity para permitir a criação de uma nova nota
                Intent intent = new Intent(MainActivity.this, CreateNoteActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        // Clique em uma nota existente
        notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ReadNoteActivity.class);
                intent.putExtra("title", notesTitles.get(position));
                startActivity(intent);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String newTitle = data.getStringExtra("title");
            notesTitles.add(newTitle);
            adapter.notifyDataSetChanged();
        }
    }
}