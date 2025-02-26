package com.example.gameprojectmz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.util.Log;  // Debugging-Log importieren

import java.util.Random;

/**
 * SharedPreferences ist eine einfache Möglichkeit, kleine Datenmengen dauerhaft auf dem Gerät zu speichern.
 * Benutzt wird in: Speichern von Einstellungen, Punkteständen, Benutzerdaten.
 *
 * ⚡ SharedPreferences speichert Daten als Schlüssel-Wert-Paare (Key-Value) in einer XML-Datei.
 * ⚡ Sie sind persistent, d. h. die Daten bleiben gespeichert, auch wenn die App geschlossen wird.
 *
 * */
public class GameLogic {

    /**
     *
     *
     *
     * */
    private Context context;
    private FrameLayout enemyContainer;
    private Random random = new Random();
    private int currentWave = 1;
    private int score = 0;

    public GameLogic(Context context, FrameLayout enemyContainer) {
        this.context = context;
        this.enemyContainer = enemyContainer;

        if (enemyContainer == null) {
            Log.e("GameLogic", "Fehler: enemyContainer ist null");
        } else {
            Log.d("GameLogic", "enemyContainer erfolgreich übergeben");
        }
    }

    public boolean allEnemiesDefeated() {
        return enemyContainer.getChildCount() == 0;
    }

    public int getScore() {
        return score;
    }

    public void spawnEnemiesForWave() {
        int enemyCount = 4 + (currentWave - 1) * 2;
        Log.d("GameLogic", "Starte Welle "+ currentWave + " mit " + enemyCount + "Gegnern");

        for (int i = 0; i < enemyCount; i++) {
            spawnEnemy();
        }
    }

    public void saveScore(int score) {
        SharedPreferences prefs = context.getSharedPreferences("GameScores", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        int bestScore = prefs.getInt("bestScore", 0);
        if (score > bestScore) {
            editor.putInt("bestScore", score);
        }
        editor.putInt("currentScore", score);
        editor.apply();
    }

    public void spawnEnemy() {

        if (enemyContainer == null) {
            Log.e("GameLogic", "Fehler: enemyContainer ist null, Feind kann nicht gespawnt werden");
            return;
        }

        // Die ImageView hat nur eine Auftrag und dass die Bildern Anzeigen
        ImageView enemy = new ImageView(context);
        int[] enemyImages = {
                R.drawable.ship1, R.drawable.ship2, R.drawable.ship3,
                R.drawable.ship4, R.drawable.ship5, R.drawable.ship6
        };


        int randomIndex = new Random().nextInt(enemyImages.length);
        Log.d("GameLogic", "Zufälliges Enemy-Image gewählt: " + randomIndex);

        enemy.setImageResource(enemyImages[randomIndex]);
        enemy.setLayoutParams(new FrameLayout.LayoutParams(90, 90));

        enemy.setScaleType(ImageView.ScaleType.FIT_XY);
        enemy.setAdjustViewBounds(true);
        enemy.setLayoutParams(new FrameLayout.LayoutParams(350, 350));

        enemyContainer.post(() -> {
            int maxX = enemyContainer.getWidth() - 90;
            int maxY = enemyContainer.getHeight() - 90;

            if (maxX > 0 && maxY > 0) {
                int randomX = random.nextInt(maxX);
                int randomY = random.nextInt(maxY);
                enemy.setX(randomX);
                enemy.setY(randomY);
                Log.d("GameLogic", "Enemy Position: X=" + randomX + ", Y=" + randomY);
            } else {
                Log.e("GameLogic", "Fehler: enemyContainer hat eine ungültige Grösse!");
            }

            enemy.setOnClickListener( v -> {
                enemyContainer.removeView(enemy);
                score++;
                Log.d("GameLogic", "Gegner zerstört! Neuer Punktestand: " + score);
            });

            enemyContainer.addView(enemy);
        });
    }
    public void nextWave() {
        currentWave++;
        spawnEnemiesForWave();
    }
    public void resetGame() {
        Log.d("GameLogic", "Spiel zurücksetzen...");

        // Speichert den Punktestand
        saveScore(score);

        // Wechsel zurück zur MainActivity
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}