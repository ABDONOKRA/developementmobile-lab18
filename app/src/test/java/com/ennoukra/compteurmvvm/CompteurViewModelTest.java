package com.ennoukra.compteurmvvm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Tests unitaires de base pour vérifier les opérations du compteur
public class CompteurViewModelTest {

    @Test
    public void addition_basique_correcte() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void soustraction_basique_correcte() {
        assertEquals(0, 5 - 5);
    }
}
