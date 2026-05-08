package com.ennoukra.compteurmvvm;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

// Test instrumenté — vérifie que le contexte de l'application correspond au bon identifiant
@RunWith(AndroidJUnit4.class)
public class TestInstrumentationCompteur {

    @Test
    public void verifierContexteApplication() {
        Context contexteApp = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.ennoukra.compteurmvvm", contexteApp.getPackageName());
    }
}
