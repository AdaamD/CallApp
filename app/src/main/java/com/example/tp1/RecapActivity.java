package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RecapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap);

    // Extraire les données de l'intent
        Intent intent = getIntent();
        if (intent != null) {
            String nom = intent.getStringExtra("NOM");
            String prenom = intent.getStringExtra("PRENOM");
            String age = intent.getStringExtra("AGE");
            String domaine = intent.getStringExtra("DOMAINE");
            String ntelephone = intent.getStringExtra("TELEPHONE");

            // Afficher le texte récupéré dans TextViews ou d'autres vues
            TextView nomTextView = findViewById(R.id.TextView_Nom);
            nomTextView.setText("Bonjour  " + nom);
            TextView prenomTextView = findViewById(R.id.TextView_Prenom);
            prenomTextView.setText("Prénom : " + prenom);
            TextView ageTextView = findViewById(R.id.TextView_Age);
            ageTextView.setText("Age : " + age);
            TextView domaineTextView = findViewById(R.id.TextView_Domaine);
            domaineTextView.setText("Domaine : " + domaine);
            TextView telephoneTextView = findViewById(R.id.TextView_Telephone);
            telephoneTextView.setText("Téléphone : " + ntelephone);


            //Action des 2 boutons
            Button okButton = findViewById(R.id.okButton);
            Button retourButton = findViewById(R.id.retourButton);

            //récupérer le numéro de téléphone écrit
            String telephone = intent.getStringExtra("TELEPHONE");
            okButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Lancer une troisième activité, par exemple une activité vide
                    Intent intent = new Intent(RecapActivity.this, CallActivity.class);
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
