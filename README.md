# LAB 18 — ViewModel et LiveData en Android

## Description

Ce projet est une application Android de compteur simple qui illustre l'architecture **MVVM** (Model-View-ViewModel) avec les composants Jetpack **ViewModel** et **LiveData**.

L'objectif principal est de montrer comment conserver les données de l'interface utilisateur lors d'un changement de configuration (rotation d'écran), sans utiliser `onSaveInstanceState`. Le `ViewModel` survit aux rotations, et le `LiveData` notifie automatiquement l'interface dès qu'une valeur change.

---

## Technologies

| Technologie | Version |
|---|---|
| Android Studio | Dernière version stable |
| Java | 11 |
| Android Jetpack — ViewModel | 2.10.0 |
| Android Jetpack — LiveData | 2.10.0 |
| Minimum SDK | API 24 (Android 7.0) |
| Target SDK | API 36 |

---

## Fonctionnalités

- Affichage de la valeur actuelle du compteur en grand format
- Bouton **AUGMENTER** : incrémente le compteur de 1
- Bouton **DIMINUER** : décrémente le compteur de 1
- Bouton **RÉINITIALISER** : remet le compteur à zéro
- Conservation automatique de la valeur lors de la rotation d'écran (grâce au `ViewModel`)
- Mise à jour automatique de l'interface via `LiveData` et le pattern Observer

---

## Architecture du projet

```
app/src/main/java/com/ennoukra/compteurmvvm/
├── MainActivity.java         — Vue : observe le ViewModel et gère les clics
└── CompteurViewModel.java    — ViewModel : contient le MutableLiveData du compteur

app/src/main/res/
├── layout/activity_main.xml  — Interface utilisateur (LinearLayout)
└── values/
    ├── strings.xml           — Textes de l'application
    ├── colors.xml            — Palette de couleurs
    └── themes.xml            — Thème Material3
```

---

## Installation

1. Cloner ou télécharger ce dépôt
2. Ouvrir le projet dans **Android Studio**
3. Attendre la synchronisation Gradle
4. Lancer l'application sur un émulateur ou un appareil physique (API 24 minimum)

### Dépendances à ajouter dans `build.gradle.kts`

```kotlin
val lifecycle_version = "2.10.0"

implementation("androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version")
implementation("androidx.lifecycle:lifecycle-livedata:$lifecycle_version")
```

---

## Utilisation

Au démarrage, le compteur affiche **0**.

- Appuyer sur **AUGMENTER** pour incrementer
- Appuyer sur **DIMINUER** pour décrémenter
- Appuyer sur **RÉINITIALISER** pour revenir à 0
- Faire pivoter l'appareil : la valeur est conservée automatiquement

---

## Résultats
<img width="444" height="817" alt="image" src="https://github.com/user-attachments/assets/66fbfc29-6d80-4936-9cb2-1ab45da57036" />

  
- Le compteur fonctionne correctement dans les deux sens
- Aucune perte de données lors de la rotation d'écran
- L'interface se met à jour automatiquement grâce au mécanisme Observer de LiveData
- Le code est structuré selon le pattern MVVM : la logique métier est isolée dans le `ViewModel`, l'activité ne fait qu'observer

---

## Concepts clés abordés

| Concept | Rôle dans le projet |
|---|---|
| `ViewModel` | Conserve l'état du compteur au-delà des rotations |
| `MutableLiveData<Integer>` | Stocke et émet la valeur courante du compteur |
| `LiveData.observe()` | L'activité s'abonne aux changements et met à jour l'affichage |
| `ViewModelProvider` | Instancie le ViewModel lié au cycle de vie de l'activité |
| Pattern MVVM | Séparation claire entre la vue et la logique |
