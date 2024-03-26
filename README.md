# Luchtverdedigingssysteem simulatie (LVSsim)
Deze applicatie simuleert de operatie van één eenheid met een luchtverdedigingssysteem met de volgende drie onderdelen

- Radar
- Identification Friend or Foe (IFF)
- Missile launcher

## Instructie
Voor de simulatie is het volgende nodig:
- Een `.csv` bestand met radar gegevens in de vorm van binaire getallen, gescheiden door het karakter `;`

### Compileren en uitvoeren
Om het programma te compileren open een terminal in de hoofd directory en voer de volgende opdracht uit:
```
javac LVSsim.java
```

Om het programma vervolgens te runnen, voer de volgende opdracht uit:
```
java LVSsim [aantal radars] [aantal IFFs] [aantal launchers] [aantal scans uit te voeren] [radar gegevens bestand]
```

Voorbeeld:
```
java LVSsim 1 1 4 20 radar_data.csv
```

## Simulatie uitleg
1. De simulatie zal de radars, IFFs en missile launchers maken voor de unit.\
Vervolgens, per tijdstap gebeurt het volgende:
    1. Elke radar scant
    2. Elke radar zal vervolgens alle IFFs inzetten om het resultaat van de scan identificeren - Friend or Foe
    4. Elke IFF zal alle launchers inzetten indien het een vijandig object betreft. Een missile heeft een kans van 80% heeft om het doel te raken. Na launch is een missile niet meer beschikbaar voor die tijdstap.
    5. Stap 2-4 zal worden herhaald voor alle 20 scans

Op dit moment heeft het geen toegevoegde waarde om meerdere radars of IFFs in te zetten in een eenheid, dus hier kun je er dus het beste maar 1 van maken. Dit voorkomt ook wildgroei aan inzet van onderdelen.

De simulatie zal elke `durationPerScan` aantal miliseconden een scan uitvoeren. Om dit langzamer of sneller te doen, kan deze variabele worden aangepast.