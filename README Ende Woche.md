# `kaufeDoch.de`: Version 0.2

## Beschreibung
Willkommen bei `kaufeDoch.de`, einer kleinen Simulation eines Online-Shops, spezialisiert auf den Verkauf von refurbished Smartphones.  

Dieses Projekt implementiert die Kernfunktionen, die für die Verwaltung eines Online-Shops notwendig sind, und verwendet gängige Design-Patterns, um die Entwicklung flexibel und erweiterbar zu gestalten.  

---

## Änderungen in Version 0.2
In dieser Version wurden folgende Features und Änderungen implementiert:
- **Nice-to-Have-Funktionen umgesetzt:**
  - **Produkt löschen:** Produkte können nun anhand ihrer ID entfernt werden.
  - **Produkt suchen:** Verbesserte Suche nach Produkten mit Teilbegriffen (case-insensitive).
  - **Bestellung bearbeiten:** Nutzer können Bestellinhalte (Produkte) aktualisieren.
- **Zusätzlich implementiert:**
  - **Anzeige und Aktualisierung von Produktmerkmalen:**
    - Preise (z. B. für Sonderangebote) werden dynamisch aktualisiert.
    - Lagerbestand wird bei Bestellungen oder Änderungen angepasst.
    - Refurbished-Status für Smartphones kann geändert werden.
  - **Zahlungsarten mit Strategy-Pattern erweitert:**
    - Unterstützung für Kreditkartenzahlungen und PayPal-Zahlungen.
  - **Kundendetails bearbeiten:** Aktualisierung der Kundendaten wie Adresse, Name und E-Mail.
  - **Neue Konsolenausgabe:** Die **`ConsolePrinter`-Klasse** konsolidiert die Ausgabefunktionen und sorgt durch klare Formatierungen für eine benutzerfreundliche Darstellung von Produkten, Bestellungen, Zahlungen und Kundendaten.

---

## Features

### Must-Haves
1. Produkte hinzufügen (Smartphones verwalten)
2. Alle Produkte anzeigen
3. Bestellung aufgeben

### Nice-to-Have
4. Produkt löschen ✅
5. Produkt suchen ✅
6. Bestellung bearbeiten ✅
7. Bestellübersicht exportieren (*noch nicht umgesetzt*)

---

## Projektstruktur

### Ordner
- **`models`**: Definiert die Kernmodelle wie `Product`, `Smartphone`, `Customer` und `Order`.
- **`services`**: Kapselt die Geschäftslogik (z. B. `ProductService`, `OrderService`, `CustomerService`).
- **`strategies`**: Implementiert die Zahlungsstrategien mit dem Strategy-Pattern.
- **NEU: ConsolePrinter**: Klasse zur strukturierten Konsolenausgabe.
- **`Main.java`**: Einstiegspunkt der Anwendung. Führt die Interaktionen und Logik aus.

---

## Hauptfunktionen

### Produktverwaltung
- Produkte können hinzugefügt, gelöscht, gesucht und bearbeitet werden.
- Es werden detaillierte Informationen über den Lagerbestand, Preis und den Refurbished-Status verwaltet.
- **NEU**: Verbesserte Suchfunktion für Produkte (unterstützt auch Teilbegriffsuche).

### Bestellverwaltung
- Kunden können Bestellungen erstellen, die eine Liste von Produkten enthalten.
- Bestellungen enthalten folgende Informationen:
  - Gesamtkosten, berechnet aus den enthaltenen Produkten.
  - Zugeordneter Kunde und seine Details.
- Bestellungen können aktualisiert oder gefiltert (nach Kunden) abgerufen werden.

### Kundenverwaltung
- Kunden können hinzugefügt oder aktualisiert werden.
- Kundeninformationen umfassen Namen, Adresse, E-Mail und zugehörige Bestellungen.
- Direkte Verknüpfung von Bestellungen mit Kunden.

### Zahlungen
- Unterstützung mehrerer Zahlungsarten (über das Strategy-Pattern):
  - Kreditkarte
  - PayPal

---

## Klassen und Methoden

### **ProductService**
- Verwalten der Produkte im System.
  - **Neu hinzugefügt:**
    - `removeProductById()`: Löschen eines Produkts.
    - `updateProductPrice()`: Preisänderung für spezielle Angebote.
    - `updateProductStock()`: Lagerbestandsänderungen bei Bestellungen.
    - `updateProductStatus()`: Refurbished-Status für Smartphones.

### **OrderService**
- Verwaltung der Bestellungen mit Zuweisung zu Kunden.
  - **Neu hinzugefügt:**
    - Bestellung nach ID suchen und aktualisieren (`updateOrder()`).

### **CustomerService**
- Verwaltung und Unterstützung von Kundeninteraktionen.
  - **Neu hinzugefügt:**
    - Aktualisierung der Kundendaten (Adresse, E-Mail und Name).
    - Abruf aller Bestellungen eines bestimmten Kunden.

### **ConsolePrinter**
- Benutzerfreundliche Darstellung der wichtigsten Informationen (Produkte, Kunden, Bestellungen).
- Implementiert für eine strukturierte Konsolenausgabe, z. B. Zahlungsmethoden, Bestellliste und Bestätigungen.

### **Design Patterns**
- **Singleton Pattern**: Verwendet zur Verwaltung der Serviceinstanzen.
- **Factory Pattern**: Verwendet zur Erstellung von Produkten.
- **Strategy Pattern**: Verwendet zur flexiblen Handhabung verschiedener Zahlungsarten.

---

## Beispiel für Konsolenausgabe
Die folgenden interaktiven Funktionen stehen zur Verfügung:
1. Produkte anzeigen:
   ```plaintext
   PRODUKTLISTE
   =================================================
   ID: 1 | Name: Apple iPhone 14 Pro | Preis: 699.00€ | Lagerbestand: 10 Stück (Refurbished: Nein)
   ID: 2 | Name: Samsung Galaxy S20  | Preis: 799.00€ | Lagerbestand: 7 Stück (Refurbished: Ja)
   ```
2. Bestellung erstellen:
   ```plaintext
   Zahlung per Kreditkarte: 1498.00€.
   Bestellung erfolgreich aufgegeben!
   ```
3. Kundeninformationen aktuell halten:
   ```plaintext
   AKTUALISIERTE KUNDENINFORMATIONEN
   =================================================
   ID: 1 | Name: Max Mustermann | E-Mail: max.neuemustermann@gmail.com | Adresse: Neue Musterstraße 34, 07896 Berlin
   ```
4. Produkt löschen:
   ```plaintext
   PRODUKT LÖSCHEN
   =================================================
   Produkt mit ID 2 wurde erfolgreich gelöscht!
   ```
5. Produkt suchen:
   ```plaintext
   PRODUKTSUCHE
   =================================================
   Name enthält: "iPhone" ➡️ Gefundene Produkte:
   ID: 1 | Name: Apple iPhone 14 Pro | Preis: 699.00€ | Lagerbestand: 10 Stück (Refurbished: Nein)
   ```
---

## Noch Ausstehend
- Implementierung eines Export-Features (z. B. Bestellübersicht als Datei).
- Optimierung der Benutzerführung, z. B. durch ein UI oder Web-Interface, ist für eine zukünftige Version (z. B. Version 0.3) geplant.

---

## Voraussetzungen

- **JDK 21 (Preview)**

- **Bibliotheken:** Aktuell werden keine externen Bibliotheken verwendet, das Projekt basiert ausschließlich auf nativen Java-Funktionen.
- **Tests:** Entwicklung und Tests wurden vollständig mit nativen Java-Funktionalitäten durchgeführt.

---

## Lizenz
Dieses Projekt ist lizenziert unter der MIT Lizenz. Weitere Details finden Sie in der Datei `LICENSE`.