package com.ennoukra.compteurmvvm;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

// Activité principale : observe le ViewModel et rafraîchit l'interface selon le LiveData
public class MainActivity extends AppCompatActivity {

    private CompteurViewModel compteurViewModel;

    private TextView affichageValeur;
    private Button boutonAugmenter;
    private Button boutonDiminuer;
    private Button boutonRemettre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lierVues();
        initialiserViewModel();
        configurerBoutons();
    }

    // Liaison entre les variables Java et les vues XML
    private void lierVues() {
        affichageValeur = findViewById(R.id.affichageValeur);
        boutonAugmenter  = findViewById(R.id.boutonAugmenter);
        boutonDiminuer   = findViewById(R.id.boutonDiminuer);
        boutonRemettre   = findViewById(R.id.boutonRemettre);
    }

    // Récupère le ViewModel et abonne l'UI au LiveData pour une mise à jour automatique
    private void initialiserViewModel() {
        compteurViewModel = new ViewModelProvider(this).get(CompteurViewModel.class);

        compteurViewModel.obtenirValeur().observe(this, valeur -> {
            if (valeur != null) {
                affichageValeur.setText(String.valueOf(valeur));
            }
        });
    }

    // Branchement des actions sur chaque bouton
    private void configurerBoutons() {
        boutonAugmenter.setOnClickListener(v -> compteurViewModel.augmenter());
        boutonDiminuer.setOnClickListener(v -> compteurViewModel.diminuer());
        boutonRemettre.setOnClickListener(v -> compteurViewModel.reinitialiser());
    }
}
