package com.example.gameprojectmz;


import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = findViewById(R.id.playButton);

        // OnClickListener ist ein Interface das Methode onClick(View v) vorschreibt
        // Da die Interface(View.OnClickListener()) keine eigen Implementierung haben, muss eine anonyme Klasse ( new View.OnClickListener() ) erstellt
        // Und die Methode onClick(View v) überschreibt
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });
    }

    private void showPopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Game Instructions");
        builder.setMessage("Are you ready? Click 'Understood' to start the game.");
        builder.setPositiveButton("Understood", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int ignored) {
                startGame();
            }
        });

        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    private void startGame() {
        Intent intent = new Intent(MainActivity.this, GamePanel.class);
        startActivity(intent);
    }
}