# Luchtverdedigingssysteem simulatie (LVSsim)
Deze applicatie simuleert de operatie van een luchtverdedigingssysteem met de volgende drie onderdelen

- Radar
- Identification Friend or Foe (IFF)
- Missile launcher

## Simulatie uitleg
1. De simulatie zal 1 radar, 1 IFF en 1 missile launcher maken.
2. De radar zal scannen
3. De IFF zal het resultaat identificeren - Friend or Foe
4. Indien het een vijandig object betreft, zal de launcher een missile vuren die een kans van 80% heeft om het doel te raken
5. Stap 2-4 zal worden herhaald voor alle 20 scans

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
java LVSsim
```

