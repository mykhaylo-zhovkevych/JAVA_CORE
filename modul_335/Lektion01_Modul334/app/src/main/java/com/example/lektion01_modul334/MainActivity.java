package com.example.lektion01_modul334;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtTitle;
    EditText editTextText;

    Button buttonActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Nach dieser Zeile können die anderen Elemente initialisiert werden
        setContentView(R.layout.activity_main);

        txtTitle = findViewById(R.id.txtTitle);
        editTextText = findViewById(R.id.editTextText);
        Button button = findViewById(R.id.button);
        buttonActive = findViewById(R.id.button2);

        //     button.setOnClickListener(new View.OnClickListener() {
        //         @Override
        //         public void onClick(View view) {
        //             txtTitle.setText("Konnichiwa");
        //         }
        //     });

        /**
         *
         * Die Lambda-Schreibweise ist kürzer und übersichtlicher,
         * da sie die Notwendigkeit einer anonymen Klasse und der @Override-Anmerkung vermeidet.
         * In diesem Fall ist die Methode onClick(View v) implizit durch den Lambda-Ausdruck definiert.
         *
         * */

        //   button.setOnClickListener(
        //           v -> doStuff()
        //    );

        // Eine weitere Ereignis wie ich Click Erreignis Konfiguriert werden kann


        txtTitle.setText(getString(R.string.title));

        buttonActive.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Button wurde geklickt!", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, FormActivity.class);
            startActivity(i);
        });
    }



        public void buttonGeklickt(View xyz) {
            Log.d("My-App", "button geklickt");
            doStuff();
        }



    private void doStuff() {
        String inputText = editTextText.getText().toString().trim();

        if (inputText.isEmpty()) {
            Toast.makeText(this, "Eingabe darf nicht leer sein!", Toast.LENGTH_SHORT).show();

            return;
        }


        txtTitle.setText("Konnichiwa, " + inputText);
        editTextText.setText("");
    }
}
