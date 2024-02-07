package com.example.tp1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        Button submitButton = findViewById(R.id.butonSubmit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }

        });
    }

    private void submitForm() {
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
}