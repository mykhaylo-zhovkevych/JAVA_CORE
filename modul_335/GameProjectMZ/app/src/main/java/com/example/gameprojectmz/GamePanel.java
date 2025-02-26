package com.example.gameprojectmz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.FrameLayout;
import android.util.Log;  // Debugging-Log importieren



public class GamePanel extends AppCompatActivity {
    private GameLogic gameLogic;
    private FrameLayout enemyContainer;
    private Handler handler = new Handler();
    private int roundTime = 15000;
    private int checkInterval = 500;
    private boolean roundActive = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_panel);

        enemyContainer = findViewById(R.id.enemyContainer);

        if (enemyContainer == null) {
            Log.e("GamePanel", "Fehler: enemyContainer konnte nicht gefunden werden!");
        } else {
            Log.d("GamePanel", "enemyContainer erfolgreich gefunden!");
        }

        // Hier ist 'this' der 'Context' der GamePanel
        // Dadurch kann 'GameLogic' auf App-Ressourcen und UI-Elemente zugreifen
        gameLogic = new GameLogic(this, enemyContainer);

        // Die Klasse 'GameLogic' speichert den Context, um später Bilder zu laden, UI-Elemente zu erzeugen und Daten zu speichern

        startNewWave();

    }

    private void startNewWave() {
        if (roundActive) return; // Verhindert doppelten Start

        roundActive = true;
        gameLogic.spawnEnemiesForWave();

        // Startet das regelmässige Prüfen
        scheduleEnemyCheck();

        handler.postDelayed(this::forceEndRound, roundTime);

    }

    // Die problem besteht darin, dass es jede Runde einige Activity erstellt was nicht gewunscht ist

    private void scheduleEnemyCheck() {
        handler.postDelayed(() -> {
            if (gameLogic.allEnemiesDefeated()) {
                Log.d("GamePanel", "Alle Gegner besiegt! Starte nächste Runde sofort...");
                roundActive = false;
                gameLogic.nextWave();
                startNewWave();
            } else {
                scheduleEnemyCheck();
            }
        }, checkInterval);
    }

    private void forceEndRound() {
        if (!gameLogic.allEnemiesDefeated()) {
            Log.d("GamePanel", "Zeitlimit erreicht! Runde beendet.");
            endGame(gameLogic.getScore());

            // Kehr die User zurück zu Home Page
            Intent intent = new Intent(GamePanel.this, MainActivity.class);
            intent.putExtra("FINAL_SCORE", gameLogic.getScore());
            startActivity(intent);
            finish(); // Beendet das Spiel-Fenster

        }
    }

    private void endGame(int finalScore) {
        Log.d("GamePanel", "Spiel beendet! Endpunktzahl: " + finalScore);
        gameLogic.saveScore(finalScore);
    }
}