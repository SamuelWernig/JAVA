# Würstelstand "HTL-Leoben POS-Stüberl"  - CashRegister

# Kurzbeschreibung

Neben dem erfolgreichem Studium an der HTL-Leoben im 2. Jahrgang, betreiben wir - um die Versorgungslücke zu schließen einen eigenen mobilen Würstelstand vor der Schule. Für eine korrekte Abrechnung ist ein Registrierkasse Pflicht. Nachdem wir die Künste der Java-Programmierung mittlerweile verinnerlicht haben, implementieren wir eine solche Registrierkasse natürlich selbst mit Hilfe der vier Säulen der Objektorientierten Programmierung - der Kapselung, Vererbung, Abstraktion und dem Polymorphismus.

Mit unserer Registrietkasse kann man für eine Kund:in bestellt Produkte aufsummieren und eine Rechnung (Kassenbon) erstellen. Sollten manche Produkte mehrfach bestellt werden , weil man z.B. großen Hunger verspürt oder eine Runde Frankfurter spendiert, so kann man das bei der Eingabe in die Registrierkasse berücksichtigen, indem man einen Multiplikator z.B. 5 für 5 Paar Frankfurter eingibt. Man kann, solange die Kund:in weitere Produkte bestellt, auch jederzeit die aktuelle Liste einsehen und deren aktuelle Summe. 

Wird der Kauf abgeschlossen, bekommt die Kund:in nicht nur die bestellten und bezahlten Produkte sondern auch die Rechnung (Kassenbon) wo im Detail aufgelistet ist was konsumiert wurde und wieviel das in Summe ausgemacht hat. 

Danach wird diese Summe des Verkaufs zu den Tageseinaahmen gezählt, die Liste der Detailbeträge in das Tages-EinnahmenLogbuch übernommen und dir Registrierkasse für die nächste Kundin initialisiert (Zwischensumme und Liste der Produkte und deren Multiplikatoren zurückgesetzt). 

### Die Klassenhierarchie:

Grundsätzlich arbeitet die Registrierkasse mit Instanzen der**`Item`** Klasse. An unserem würstelstand gibt es aktuell zwei Produktgruppen - die Getränke (**`Drink`** Klasse)  und das Essen ( **`Food`** Klasse). Beides sind Subklassen der `Item`-Klasse.

Die gegebenen Beispielklassen aus dem **`food`** bzw. **`drink`** Package (Subklassen von **`Food`** bzw. **`Drink`**) können Sie getrost ignorieren - sie sind aber sehr praktisch wenn man exemplarische Produkte für den Würstelstand erstellen will.

## Ihre Aufgabe:

1. Vervollständigen Sie die Methoden von **`Item`**, **`Food`** und **`Drink`** damit die Funktionalität gegeben ist und die Ausgabe wie in der Beispielausgabe aussieht.

   * fehlende Getter für lokale properties
   * toDetailedString() - hier solle folgendes ausgegeben werden:
     "Name: xxx , Calories: xxx, Costs: xxx €"
     Bsp: "Name: Duff, Calories: 218, Costs: 5.6€"
   * toString() - hier soll nur der Name und die Kosten ausgegeben werden:
     Bsp: "Duff: 5.6 €" - also "\<name\>: \<costsInEuro\> €"
   * Beachten Sie dass sämtliche Preise in der Einheit **cent** geführt werden und damit gerechnet wird. Bei der Ausgabe kann dann in Euro umgerechnet werden was soviel bedeutet wie eine Division durch 100.

2. Vervollständigen Sei die Methoden in der Klasse **`CashRegister`** sodass die Funktionalität gegeben ist und die Ausgabe wie in der Beispielausgabe aussieht.  Orientieren Sie sich an den Fehlern in der **`CashRegisterDemo`**-Klasse

   * Im Konstruktor initialisieren Sie alle Datenstrukturen und Felder - es gibt zwei Arrays mit der gleichen Anzahl an Feldern - ein Array mit dem Produkt und das andere Array mit dem Multiplikator.
   * Lassen Sie sich Getter für die Arrays erstellen.
   * Sie benötigen Getter für die Zwischensumme (subTotalSumInCent) in Cent und Euro.
   * `new CustomerSession` sollte die Tageneinnahmen (totalSuminCents) aktualisieren die Rechnung erstellen und die Arrays löschen.
   * Sie sollten zu jeder Zeit ein Zwischenrechnung erstellen können `getSubTotalReceipt()` - ohne dass dabei die Session gestört oder die Tageseinnahmen verändert werden.
   * **`addItem(item)`**, **`addItem(item, multiplier)`**... fügen zum `items`- und `mutliplier`- Array das bergebene item (Produkt) hinzu und auch die Anzahl - ACHTUNG die Methode ist überladen - d.h. die einfache Methode kann die komplexere aufrufen.
     * Passen Sie beim Hinzufügen darauf auf, dass Sie NUR dort wo ein Slot frei ist (also null) im `item`-Array steht, Sie das übergebene `item` speichern und an der gleichen Stelle im `multiplier`-Array die übergebene Anzahl.
     * Sollte es keinen freien Platz mehr geben, dann schreiben Sie diese Info auf die Konsole und retournieren `false`damit man sieht, dass das Hinzufügen NICHT funktioniert hat. Hat es hingegen funktioniert geben Sie `true`zurück.
     * **BONUS**: Wenn Sie Zeit haben überlegen Sei sich wie Sie das Hinzufügen optimieren können, damit wenn Sie z.b.: ein zweites Mal 3 Paar Frankfurter hinzufügen, nicht ein Produkt hinzugefügt wird SONDERN die Anzahl von 3 auf 6 erhöht wird, weil ja das Produkt bereits schon einmal hinzugefügt wurde. D.h. bei Gleichheit sollten Sie also nur den `multiplier`aktualsieren.
   * **Hilfsmethoden:**
     * **`computeSubTotalReceipt()`**: berechnet sich die aktuelle Summe aller Produkte im `items`-Array in Berücksichtigung der Anzahl aus dem `multiplier`-Array. Als Rückgabe wird ein `String` verlangt - nutzen Sie also unbedingt einen `StringBuilder`um die Rechnung (Kassenbon) zu erstellen.
     * **`computeSubTotalSumInCents()`**: berechnet sich die aktuelle Summe aller Produkte in Cent in Berücksichtigung ihrer Anzahl und gibt diese als `long` zurück. Auch hier aufpassen - Sie müssen NICHT das ganze Array durchgehen, sobald Sie auf ein `null`-Referenz treffen können Sie die Schleife beenden.
   

### Vorgegebene Klassen:

* **`at.htlle.pos.drink`**

  Hierbei handelt es sich um "Sub"-Klassen der **`Drink`**-Klasse, die einfach mit Konstanten versehen sind und parameterlosen Konstruktoren haben die den Super-Klasse-Konstruktor aufrufen und mit typischen Werten (aus den Konstanten) initialisieren &rArr; sehr praktisch um schnell mal ein passendes Getränk zu instantiieren. Sie können aber auch gerne die `Drink`-Klasse direkt nutzen und eigene Produkte erstellen.

  * **`Beer`** ... ein typisches Produkt am Würstelstand (hier natürlich alkoholfrei)
  * **`Soda`** ... Limonadengetränk wie "Himbeerkracherl" oder Orangensaft

* **`at.httle.pos.food`**

  Hierbei handelt es sich um "Sub"-Klassen der **`Food`**-Klasse, die einfach mit Konstanten versehen sind und parameterlosen Konstruktoren haben die den Super-Klasse-Konstruktor aufrufen und mit typischen Werten (aus den Konstanten) initialisieren  &rArr; sehr praktisch um schnell mal ein passendes Getränk zu instantiieren. Sie können aber auch gerne die `Food`-Klasse direkt nutzen und eigene Produkte erstellen.

  * **`Sausage`** ... das Ausshängeschild der POS-Stüberl 
  * **`VeganPatty`** ... wenns mal was Leichtes sein soll - in Olivenöl saftig gebraten
  * **`Bun`** ... typisches Füllmaterial um nicht beim Wurstkonsum verhungern zu müssen

* **`at.htlle.pos.CashRegisterDemo`**:

  * Diese Klasse demonstriert die Funktionalität der Registrier-Kasse. Es wird die Registrierkasse des Würstelstandes instantiiert und die Funktionen darauf aufgerufen. 
  * Es werden einige Produkte der Kategorie `Food` und `Drink` erstellt und zur Registrierkasse hinzugefügt. Beachten Sie dass Sie auch eigene Instanzen direkt der Klasse `Food`und `Drink`erstellen können indem Sie mit dem `new` welche erzeugen - hier müssen Sie allerdings die Parameter setzen. 
  * Orientieren Sie sich an der Beispielausgabe und den Fehlern die in dieser Klasse vorhanden sind, sie sind auf Grund der Fehler in den andern Klassen. D.h. diese Klasse sollte von Ihnen nicht verändert werden sie stellt eine Art ausführbare Spezifikation dar - wenn Sie alles richtig vervollständigt und implementiert haben sieht die Ausgabe der `main()`- Methode wie die Beispielausgabe aus.

  

### Beispielausgabe

```text
// nach Instantiierung der Registrierkasse

--- after instantiation of cash register - there are no products and no sub- or total sum, and the receipt is more or less empty.
register.getCurrentTotalSumInCent(): 0
register.getCurrentTotalSumInEuro(): 0.0
register.getItems(): [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]
register.getMultipliers(): [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
register.getCurrentSubTotalSumInCent(): 0
register.getCurrentSubTotalSumInEuro(): 0.0
Receipt: 
HTL-Leoben POS-Stüberl Rechnung 2025-01-16 
===
Summe:	0.0 €

--- create some items and print the details
beer.toDetialedString(): Name: Duff, Calories: 218, Costs: 5.6€
soda.toDetialedString(): Name: SuperQuench, Calories: 50, Costs: 0.05€
saasage.toDetialedString(): Name: Frankfurter, Calories: 300, Costs: 4.2€
bun.toDetialedString(): Name: Semmerl, Calories: 180, Costs: 2.0€

--- now enter some items to the register
register.getCurrentTotalSumInCent(): 0
register.getCurrentTotalSumInEuro(): 0.0
register.getItems()[Duff: 5.6€, Frankfurter: 4.2€, Semmerl: 2.0€, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]
register.getMultipliers()[3, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
register.getCurrentSubTotalSumInCent(): 2500
register.getCurrentSubTotalSumInEuro(): 25.0
Receipt: 
HTL-Leoben POS-Stüberl Rechnung 2025-01-16 
Duff
3 x 5.6 =	16.8
Frankfurter
1 x 4.2 =	4.2
Semmerl
2 x 2.0 =	4.0
===
Summe:	25.0 €

--- now conclude the customer session and create a new one
Call newCustomerSession():
HTL-Leoben POS-Stüberl Rechnung 2025-01-16 
Duff
3 x 5.6 =	16.8
Frankfurter
1 x 4.2 =	4.2
Semmerl
2 x 2.0 =	4.0
===
Summe:	25.0 €

register.getCurrentTotalSumInCent(): 2500
register.getCurrentTotalSumInEuro(): 25.0
register.getItems()[null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]
register.getMultipliers()[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
register.getCurrentSubTotalSumInCent(): 0
register.getCurrentSubTotalSumInEuro(): 0.0

```



**==Viel Erfolg!==**
