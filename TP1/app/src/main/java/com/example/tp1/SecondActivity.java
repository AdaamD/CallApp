package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    // Extraire les données de l'intent
        Intent intent = getIntent();
        if (intent != null) {
            String nom = intent.getStringExtra("NOM");


            // Afficher le texte récupéré dans TextViews ou d'autres vues
            TextView nomTextView = findViewById(R.id.TextView_Nom);
            nomTextView.setText("Bonjour  " + nom);

    //Action des 2 boutons
            Button okButton = findViewById(R.id.okButton);
            Button retourButton = findViewById(R.id.retourButton);

            //récupérer le numéro de téléphone écrit
            String telephone = intent.getStringExtra("TELEPHONE");
            okButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Lancer une troisième activité, par exemple une activité vide
                    Intent intent = new Intent(SecondActivity.this, TroisiemeActivity.class);
                   //        // Ajouter les données récupérées en tant qu'extra dans l'Intent
                    intent.putExtra("TELEPHONE", telephone);

                    startActivity(intent);
                }
            });

            retourButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Revenir à l'activité précédente (dans ce cas, MainActivity)
                    finish();
                }
            });

        }
    }
}
