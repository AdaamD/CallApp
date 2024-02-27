package com.example.tp1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class CallActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    private String telephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        Button retourButton = findViewById(R.id.retourButton);

        Intent intent = getIntent();
        if (intent != null) {
            telephone = intent.getStringExtra("TELEPHONE");
            TextView telephoneTextView = findViewById(R.id.TextView_Telephone);
            telephoneTextView.setText("Numéro de téléphone : " + telephone);

            Button appelerButton = findViewById(R.id.appelButton);

            appelerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Vérifier si la permission CALL_PHONE a été accordée
                    if (ContextCompat.checkSelfPermission(CallActivity.this, Manifest.permission.CALL_PHONE)
                            != PackageManager.PERMISSION_GRANTED) {
                        // Si la permission n'a pas été accordée, demander à l'utilisateur de l'accorder
                        ActivityCompat.requestPermissions(CallActivity.this,
                                new String[]{Manifest.permission.CALL_PHONE},
                                MY_PERMISSIONS_REQUEST_CALL_PHONE);
                    } else {
                        // Si la permission a déjà été accordée, procéder à l'appel téléphonique
                        makePhoneCall();
                    }
                }
            });


            // Boutton de retour
            retourButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Revenir à l'activité précédente (dans ce cas, MainActivity)
                    finish();
                }
            });
        }
    }

    // Méthode pour gérer la réponse de l'utilisateur à la demande de permission
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_PERMISSIONS_REQUEST_CALL_PHONE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission accordée, procéder à l'appel téléphonique
                makePhoneCall();
            } else {
                // Permission refusée, afficher un message à l'utilisateur
                Toast.makeText(this, "Permission refusée pour effectuer l'appel téléphonique", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Méthode pour effectuer l'appel téléphonique
    private void makePhoneCall() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + telephone));
        startActivity(callIntent);
    }
}
