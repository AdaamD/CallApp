package com.example.tp1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText nomEditText;
    private EditText prenomEditText;
    private EditText ageEditText;
    private EditText domaineEditText;
    private EditText telephoneEditText;
    private TextView resumeTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomEditText = findViewById(R.id.nomEditText);
        prenomEditText = findViewById(R.id.prenomEditText);
        ageEditText = findViewById(R.id.ageEditText);
        domaineEditText = findViewById(R.id.domaineEditText);
        telephoneEditText = findViewById(R.id.telephoneEditText);
        resumeTextView = findViewById(R.id.resumeTextView);


        Button butonRecap = findViewById(R.id.butonRecap);
        //Button Recap est cliqué
        butonRecap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recapForm();
            }

        });

        //Button submit est cliqué
        Button submitButton = findViewById(R.id.butonSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }

        });

        //Button de changement de langue est cliqué
        Button changeLanguageButton = findViewById(R.id.changeLanguageButton);

        changeLanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Changez la langue ici
                changerLangue();
            }
        });

    }

    private void recapForm(){
        String nom = nomEditText.getText().toString();
        String prenom = prenomEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String domaine = domaineEditText.getText().toString();
        String telephone = telephoneEditText.getText().toString();

        String resultat = "Nom: " + nom + "\n" +
                "Prenom: " + prenom + "\n" +
                "Age: " + age + "\n" +
                "Domaine: " + domaine + "\n" +
                "Telephone: " + telephone;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Résumé de la saisie");
        builder.setMessage(resultat);
        builder.setPositiveButton("OK", null); // Ajouter un bouton "OK" pour fermer la boîte de dialogue

        //Créer la boîte de dialogue
        AlertDialog dialog = builder.create();

        // Définir le fond personnalisé
        Drawable backgroundDrawable = getResources().getDrawable(R.drawable.dialog_background);
        dialog.getWindow().setBackgroundDrawable(backgroundDrawable);

        dialog.show();
    }

    private void submitForm() {
        String nom = nomEditText.getText().toString();
        String prenom = prenomEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String domaine = domaineEditText.getText().toString();
        String telephone = telephoneEditText.getText().toString();


        // Créer un nouvel Intent pour lancer la nouvelle activité
        Intent intent = new Intent(MainActivity.this, RecapActivity.class);

        // Ajouter les données récupérées en tant qu'extra dans l'Intent
        intent.putExtra("NOM", nom);
        intent.putExtra("PRENOM", prenom);
        intent.putExtra("AGE", age);
        intent.putExtra("DOMAINE", domaine);
        intent.putExtra("TELEPHONE", telephone);

        // Lancer la nouvelle activité avec l'Intent
        startActivity(intent);


    }

    // Méthode pour changer la langue de l'application
    private void changerLangue() {
        // Récupérer la langue actuelle
        String currentLanguage = getResources().getConfiguration().locale.getLanguage();

        // Changer la langue
        if (currentLanguage.equals("en")) {
            setLocale("fr"); // Changer en français
        } else {
            setLocale("en"); // Changer en anglais
        }

        // Redémarrer l'activité pour appliquer les changements de langue
        recreate();
    }

    // Méthode pour définir la langue de l'application
    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }


}