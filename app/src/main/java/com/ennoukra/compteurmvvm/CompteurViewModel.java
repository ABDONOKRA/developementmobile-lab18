package com.ennoukra.compteurmvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

// Conserve et gère l'état du compteur, survit aux rotations d'écran
public class CompteurViewModel extends ViewModel {

    private static final int VALEUR_INITIALE = 0;
    private static final int PAS = 1;

    private final MutableLiveData<Integer> valeurActuelle = new MutableLiveData<>(VALEUR_INITIALE);

    public MutableLiveData<Integer> obtenirValeur() {
        return valeurActuelle;
    }

    public void augmenter() {
        int actuel = valeurActuelle.getValue() != null ? valeurActuelle.getValue() : VALEUR_INITIALE;
        valeurActuelle.setValue(actuel + PAS);
    }

    public void diminuer() {
        int actuel = valeurActuelle.getValue() != null ? valeurActuelle.getValue() : VALEUR_INITIALE;
        valeurActuelle.setValue(actuel - PAS);
    }

    public void reinitialiser() {
        valeurActuelle.setValue(VALEUR_INITIALE);
    }
}
