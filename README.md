# Luchtverdedigingssysteem simulatie (LVSsim)
Deze applicatie simuleert de operatie van een luchtverdedigingssysteem met de volgende drie onderdelen

- Radar
- Identification Friend or Foe (IFF)
- Missile launcher


## Instructie
Voor de simulatie is het volgende nodig:
- `radar_data.csv` bestand in de hoofd directory (al aanwezig).\
Dit bestand moet 20 regels hebben met binaire getallen, gescheiden door het karakter `;`

### Compileren en uitvoeren
Om het programma te compileren open een terminal in de hoofd directory en voer de volgende opdracht uit:
```
javac LVSsim.java
```

Om het programma vervolgens te runnen, voer de volgende opdracht uit:
```
java LVSsim [aantal radars] [aantal IFFs] [aantal launchers]
```

## Simulatie uitleg
1. De simulatie zal de radars, IFFs en missile launchers maken voor de unit.\
Vervolgens, per tijdstap:
    1. Elke radar scant
    2. Elke radar zal vervolgens alle IFFs inzetten om het resultaat van de scan identificeren - Friend or Foe
    4. Elke IFF zal alle launchers inzetten indien het een vijandig object betreft. Een missile heeft een kans van 80% heeft om het doel te raken
    5. Stap 2-4 zal worden herhaald voor alle 20 scans

Op dit moment heeft het geen toegevoegde waarde om meerdere radars of IFFs in te zetten in een unit, dus hier kun je er dus het beste maar 1 van maken. Dit voorkomt ook wildgroei aan inzet van onderdelen.