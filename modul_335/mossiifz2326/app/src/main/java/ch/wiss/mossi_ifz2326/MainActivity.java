package ch.wiss.mossi_ifz2326;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int GAME_ACT = 42;
    private TextView txtHighscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtHighscore = findViewById(R.id.textViewHighscore);
        readHighscore();
    }

    public void startGameScreen(View v) {
        Intent i = new Intent(this, GameActivity.class);
        startActivityForResult(i, GAME_ACT);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GAME_ACT && resultCode == RESULT_OK) {
            int result = data.getIntExtra("SCORE", 0);
            Toast.makeText(this, "GAME Over, dein Score: " + result, Toast.LENGTH_SHORT).show();

            int currentScore = getHighScore();
            if (result > currentScore) {
                // Neuer Highscore → Name abfragen
                askForPlayerName(result);
            }
        }
    }

    // Methode zum Anzeigen des Dialogs zur Namenseingabe
    private void askForPlayerName(int newHighScore) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Neuer Highscore!");
        builder.setMessage("Gib deinen Namen ein:");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("Speichern", (dialog, which) -> {
            String playerName = input.getText().toString();
            if (playerName.isEmpty()) {
                playerName = "Unbekannt";
            }
            saveHighScore(newHighScore, playerName);
            readHighscore(); // Aktualisiere Anzeige
        });

        builder.setNegativeButton("Abbrechen", (dialog, which) -> dialog.cancel());
        builder.show();
    }

    // Highscore & Name speichern
    private void saveHighScore(int score, String name) {
        SharedPreferences pref = getSharedPreferences("HIGH", MODE_PRIVATE);
        SharedPreferences.Editor edi = pref.edit();
        edi.putInt("SCORE", score);
        edi.putString("PLAYER_NAME", name);
        edi.apply();
    }

    // Highscore & Name laden
    private void readHighscore() {
        SharedPreferences pref = getSharedPreferences("HIGH", MODE_PRIVATE);
        int score = pref.getInt("SCORE", 0);
        String name = pref.getString("PLAYER_NAME", "-");

        txtHighscore.setText(String.valueOf(score));
        TextView txtHighscoreName = findViewById(R.id.textViewHighscoreName);
        txtHighscoreName.setText("Spieler: " + name);
    }

    private int getHighScore() {
        SharedPreferences pref = getSharedPreferences("HIGH", MODE_PRIVATE);
        return pref.getInt("SCORE", 0);
    }
}