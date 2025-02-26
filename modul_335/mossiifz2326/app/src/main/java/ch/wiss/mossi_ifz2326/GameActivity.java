package ch.wiss.mossi_ifz2326;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements Runnable{

    int score = 0;
    int level = 0;
    int mossisToCatch = 10;
    int mossisCatched = 0;
    long remainingTime = 0;

    Date tStar = new Date();

    FrameLayout barRemainingMossis;

    FrameLayout barRemainingTime;


    private final static int LEVEL_TIME = 50;
    public static final int DELAY_MILIS = 500;

    private Random random;
    private FrameLayout gameFrame;
    private TextView txtScore;
    private TextView txtLevel;
    private TextView txtTimeRemaining;
    private TextView txtMossisRemaining;



    Handler handler;

    private void decrementTime() {
        remainingTime = LEVEL_TIME - (new Date().getTime() - tStar.getTime()) / DELAY_MILIS;

        if (!gameOver()) {
            if (!levelFinished()) {
                spawnMossi();
            } else {
                startNextLevel();
            }
            hideMossis();
            handler.postDelayed(this,1000);
        } else {
            showGameOver();
        }
        refreshDisplay();
    }

    private boolean gameOver() {
        return remainingTime <= 0 && mossisCatched < mossisToCatch;
    }

    private boolean levelFinished() {
        return mossisCatched >= mossisToCatch;
    }


    private void startNextLevel() {
        level++;
        mossisToCatch = level * 10;
        mossisCatched = 0;
        tStar = new Date();
    }

    private void showGameOver() {
        // entfern alle Mossis
        gameFrame.removeAllViews();
        // Toast.makeText(this, "GAME OVER", Toast.LENGTH_LONG).show();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("SCORE", score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        random = new Random();
        gameFrame = findViewById(R.id.gameFrame);
        txtScore = findViewById(R.id.textViewScore);
        txtLevel = findViewById(R.id.textViewLevel);
        txtMossisRemaining = findViewById(R.id.textViewRemainingMossis);
        txtTimeRemaining = findViewById(R.id.textViewRemainingTime);
        barRemainingMossis = findViewById(R.id.barRemainingMossis);
        barRemainingTime = findViewById(R.id.barRemainingTime);


        handler = new Handler();
        handler.postDelayed(this, 1000);

    }

    // Aktualisiere die Anzeige
    private void refreshDisplay() {
        txtScore.setText("Punkte: " + score);
        txtLevel.setText("Level: " + level);
        txtMossisRemaining.setText(String.valueOf(mossisToCatch - mossisCatched));
        txtTimeRemaining.setText(String.valueOf(remainingTime));

        barRemainingMossis.getLayoutParams().width = (int)
                (gameFrame.getWidth() *
                        (double) mossisCatched / mossisToCatch);

        barRemainingTime.getLayoutParams().width = (int)
                (gameFrame.getWidth() * (double) remainingTime / LEVEL_TIME );
    }

    /**
     *
     *
     * */
    private void hideMossis() {
        int currentIndex = 0;
        while (currentIndex < gameFrame.getChildCount()) {
            ImageView currentMossi = (ImageView) gameFrame.getChildAt(currentIndex);
            long bday = (long) currentMossi.getTag(R.string.bday);
                if (new Date().getTime()-bday > 2000) {
                    gameFrame.removeView(currentMossi);

                } else {
                    currentIndex++;
                }
            }
        }

    public void buttonClicked(View xyz) {
        spawnMossi();
    }

    // Methode, um ein Mosquito zu spawnen
    private void spawnMossi() {
        ImageView mossi = new ImageView(this);
        mossi.setImageResource(R.drawable.mosquito);

        mossi.setTag(R.string.bday, new Date().getTime());

        // Grösse des Mosquito je nach Frame
        int size = gameFrame.getWidth() / 10;
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(size, size);

        // Position des Mosquito zufällig im sichtbaren Bereich des Frames
        params.topMargin = random.nextInt(gameFrame.getHeight() - size);
        params.leftMargin = random.nextInt(gameFrame.getWidth() - size);

        mossi.setLayoutParams(params);

        // Debugging-Log, um zu sehen, wo das Mosquito erscheint
        Log.d("GameActivity", "Spawning mossi at position: " + params.leftMargin + ", " + params.topMargin);

        // Wenn das Mosquito geklickt wird, wird es entfernt
        mossi.setOnClickListener(v -> {
            gameFrame.removeView(mossi);
            score += 10;
            mossisCatched++;
            refreshDisplay();
        });

        // Füge das Mosquito zum FrameLayout hinzu
        gameFrame.addView(mossi);
    }

    @Override
    public void run() {
        // Spiel Logik
        decrementTime();

    }
}