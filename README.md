# MyOnlineShop: kaufeDoch.de
## Version 0.1

## Beschreibung
Eine einfache Simulation eines Online-Shops.
Willkommen bei **kaufeDoch.de**, einer einfachen Simulation eines Online-Shops, spezialisiert auf den Verkauf von refurbished Smartphones.
## Features

### Must-Haves
1. Produkte hinzufügen (Smartphones verwalten)
2. Alle Produkte anzeigen
3. Bestellung aufgeben

### Nice-to-Have
4. Produkt löschen
5. Produkt suchen
6. Bestellung bearbeiten
7. Bestellübersicht exportieren

## Umgesetzt
* Produkte hinzufügen
* Alle Produkte anzeigen
* Bestellung aufgeben



## Projektstruktur
1. **models**: Enthält die grundlegenden Modelle des Shops, wie Produkte (z. B. Smartphones), Kunden und Bestellungen.
2. **services**: Bietet geschäftslogische Funktionen wie Produktverwaltung, Bestellabwicklung und Kundenmanagement.
3. **strategies**: Implementiert die verschiedenen Zahlungsstrategien mithilfe des Strategy Patterns.
4. **Main.java**: Einstiegspunkt der Anwendung. Hier werden Menüs und Benutzerinteraktionen verwaltet.


### 1. Hauptklassen und ihre Aufgaben
####  a. Main

Verantwortlich für die Benutzerinteraktion.
Zeigt ein Menü mit Optionen (z. B. Produkte anzeigen, hinzufügen, Bestellung aufgeben).
Delegiert Aktionen an die entsprechenden Services.
#### b. Product

Eigenschaften: id, name, price, quantity.
Methoden: Getter, Setter und eine übersichtliche toString()-Methode.
#### c. Order

Eigenschaften: orderId, products (Liste von Produkten), totalPrice, customerName.
Methoden: Berechnung des Gesamtpreises, Hinzufügen von Produkten.
#### d. ShopManager

Singleton-Klasse.
Verwaltet die Hauptdaten wie Produkt- und Bestelllisten.


### 2. Services

#### a. ProductService

Verantwortlich für die Produktverwaltung.

Methoden:
* addProduct(Product product)
* deleteProductById(int id)
* getAllProducts()
* findProductByName(String name)
#### b. OrderService

Verantwortlich für die Bestellungslogik.

Methoden:
* createOrder(List<Product> products, String customerName)
* editOrder(int orderId, List<Product> updatedProducts)
* getAllOrders()





## Design Patterns
In diesem Projekt werden folgende Design Patterns verwendet:
- Singleton Pattern für die Datenbankverbindung
- Factory Pattern für die Produkterstellung
- Observer Pattern für die Benachrichtigung von Kunden über Bestellstatusänderungen
- Strategy Pattern für verschiedene Zahlungsarten


## Lizenz
Dieses Projekt ist unter der MIT Lizenz lizenziert. Siehe die LICENSE Datei für Details.
