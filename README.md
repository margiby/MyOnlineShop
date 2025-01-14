# MyOnlineShop: `kaufeDoch.de`
## Version 0.1

## Beschreibung
Willkommen bei kaufeDoch.de, einer einfachen Simulation eines Online-Shops, spezialisiert auf den Verkauf von refurbished Smartphones.

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
- Produkte hinzufügen
- Alle Produkte anzeigen
- Bestellung aufgeben

## Projektstruktur
- **models**: Enthält die grundlegenden Modelle des Shops, wie Produkte (z. B. Smartphones), Kunden und Bestellungen.
- **services**: Bietet geschäftslogische Funktionen wie Produktverwaltung, Bestellabwicklung und Kundenmanagement.
- **strategies**: Implementiert die verschiedenen Zahlungsstrategien mithilfe des Strategy Patterns.
- **Main.java**: Einstiegspunkt der Anwendung. Hier werden die Hauptlogik und Benutzerinteraktionen verwaltet.

## Hauptklassen und ihre Aufgaben
### Main
- Verantwortlich für die Benutzerinteraktion. Führt die Hauptlogik aus und delegiert Aktionen an die entsprechenden Services.

### Product
- **Eigenschaften**: id, name, price, brand, model, storage, isRefurbished.
- **Methoden**: Getter, Setter und eine übersichtliche toString()-Methode.

### Customer
- **Eigenschaften**: id, name, email, address, orders.
- **Methoden**: Getter, Setter und Methoden zum Hinzufügen von Bestellungen.

### Order
- **Eigenschaften**: orderId, products (Liste von Produkten), customer.
- **Methoden**: Getter, Setter und Methoden zur Berechnung des Gesamtpreises.

## Services
### ProductService
- Verantwortlich für die Produktverwaltung: einschließlich hinzufügen, entfernen, aktualisieren und suchen nach Produkten.

- **Methoden**:
    - `addProduct(Product product)`
    - `removeProduct(Product product)`
    - `updateProduct(int productId, String name, double price)`
    - `searchProductsByName(String name)`
    - `getAllProducts()`

### OrderService
- Verantwortlich für die Bestellungslogik: hinzufügen, aktualisieren und suchen nach Bestellungen.

- **Methoden**:
    - `addOrder(Order order)`
    - `updateOrder(int orderId, List<Product> products)`
    - `searchOrderById(int orderId)`
    - `getAllOrders()`

### CustomerService
- Verantwortlich für die Kundenverwaltung: hinzufügen, aktualisieren und suchen nach Kunden.

- **Methoden**:
    - `addCustomer(Customer customer)`
    - `updateCustomerAddress(int customerId, String newAddress)`
    - `searchCustomerById(int customerId)`
    - `getAllCustomers()`

### Strategies 
- Verantwortlich für die Implementierung der verschiedenen Zahlungsstrategien. 
- **Methoden**: 
  - `PaymentStrategy`: Ein Interface, das die Methode `pay(double amount)` definiert. 
  - `CreditCardPayment`: Implementiert `PaymentStrategy`, um Zahlungen per Kreditkarte zu verarbeiten.
  - `PayPalPayment`: Implementiert `PaymentStrategy`, um Zahlungen per PayPal zu verarbeiten.

## Design Patterns
In diesem Projekt werden folgende Design Patterns verwendet:
- Singleton Pattern für die Verwaltung einzelner Instanzen der Services
- Factory Pattern für die Produkterstellung
- Strategy Pattern für verschiedene Zahlungsarten


## Lizenz
Dieses Projekt ist unter der MIT Lizenz lizenziert. Siehe die LICENSE Datei für Details.
