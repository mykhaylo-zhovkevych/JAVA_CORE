package JavaBuildMethods;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class summary {
    
    //1.
    startsWith(String prefix):

    // Beschreibung: Überprüft, ob die Zeichenkette mit dem angegebenen Präfix beginnt.
    if (!sequenceDNA.startsWith("ATG")) return false;
   /*  Erklärung: Überprüft, ob die DNA-Sequenz mit dem Start-Codon ATG beginnt. 
    Wenn nicht, ist die Sequenz ungültig. */

    //2.
    length():

    // Beschreibung: Gibt die Länge der Zeichenkette zurück.
    if (sequenceDNA.length() % 3 != 0) return false;
    /* Erklärung: Überprüft, ob die Länge der DNA-Sequenz durch 3 teilbar ist. 
    DNA-Sequenzen müssen eine Länge haben, die ein Vielfaches von 3 ist. */

    //3.
    isEmpty():
    // Beschreibung: Überprüft, ob die Zeichenkette leer ist (d.h. keine Zeichen enthält).
    if (sequenceDNA == null || sequenceDNA.isEmpty()) return false;
    /*  Erklärung: Überprüft, ob die DNA-Sequenz null oder leer ist. Wenn ja, ist die Sequenz ungültig. */


    //4.
    matches(String regex):
    // regex: Ein String, der einen regulären Ausdruck darstellt.
    // Beschreibung: Überprüft, ob die gesamte Zeichenkette mit dem angegebenen regulären Ausdruck übereinstimmt.
    if (!sequenceDNA.matches(".*(?:TAA|TAG|TGA)$")) return false;
    /*  Erklärung: Überprüft, ob die DNA-Sequenz mit einem der Stop-Codons TAA, TAG oder TGA endet. 
    Der reguläre Ausdruck .*(?:TAA|TAG|TGA)$ bedeutet "irgendwelche Zeichen, gefolgt von einem dieser Stop-Codons am Ende der Zeichenkette". */

   /*  
   Z.b:
    public class Main {
        public static void main(String[] args) {
            String str = "hello";
            boolean result = str.matches("hello");
            System.out.println(result); // true
        }
    } 
    */
    
    Grundlegende Symbole und ihre Bedeutungen

    . (Punkt)
        Bedeutung: Ein beliebiges einzelnes Zeichen außer dem Zeilenumbruch.
        Beispiel: h.t passt zu hat, hit, hot usw.

    * (Stern)
        Bedeutung: Null oder mehr des vorangegangenen Zeichens oder der Gruppe.
        Beispiel: a* passt zu ``, a, aa, aaa usw.

    $ (Dollarzeichen)
        Bedeutung: Ende der Zeichenkette.
        Beispiel: abc$ passt zu abc (am Ende der Zeichenkette).

    ^ (Caret)
        Bedeutung: Anfang der Zeichenkette.
        Beispiel: ^abc passt zu abc (am Anfang der Zeichenkette).

    \\ (Backslash)
        Bedeutung: Escape-Zeichen, das verwendet wird, um spezielle Zeichen zu maskieren.
        Beispiel: \\d steht für eine Ziffer (0-9).

    | (Pipe)
        Bedeutung: Oder-Operator.
        Beispiel: a|b passt zu a oder b.

    () (Klammern)
        Bedeutung: Gruppierung.
        Beispiel: (abc) entspricht der Gruppe abc.

    (?:...) (Nicht erfassende Gruppe)
        Bedeutung: Gruppiert Ausdrucksteile ohne sie zu erfassen (keine Rückreferenz).
        Beispiel: (?:abc|def) passt zu abc oder def, ohne die Gruppe zu speichern.

    [] (Zeichenklasse)
        Bedeutung: Ein beliebiges Zeichen aus der angegebenen Zeichenklasse.
        Beispiel: [abc] passt zu a, b oder c.

    + (Plus)
        Bedeutung: Eins oder mehr des vorangegangenen Zeichens oder der Gruppe.
        Beispiel: a+ passt zu a, aa, aaa usw.


        Der gesamte Ausdruck .*(?:TAA|TAG|TGA)$ bedeutet:

        Bestandteile des Ausdrucks

        .*: Die Zeichenkette kann mit beliebigen Zeichen beginnen und diese beliebigen Zeichen können beliebig viele sein.
        Bedeutung: Null oder mehr beliebige Zeichen.
        Einfach erklärt: Stell dir vor, du kannst beliebig viele Zeichen (einschließlich keines) haben. Es ist wie ein Platzhalter, der für alles steht.
        
        (?:TAA|TAG|TGA):
        Bedeutung: Eine Gruppe, die nach TAA, TAG oder TGA sucht, aber diese Gruppe wird nicht für spätere Referenzen erfasst.
        Einfach erklärt: Schau nach einer der drei speziellen Sequenzen TAA, TAG oder TGA. Diese Gruppe selbst wird nicht gespeichert oder später verwendet, sie dient nur zum Suchen.
        $:
        
        Bedeutung: Ende der Zeichenkette.
        Einfach erklärt: Dies stellt sicher, dass die Zeichenkette genau hier endet.



    //5.
    compile(String regex):
    // Beschreibung: Erstellt ein Pattern-Objekt aus dem angegebenen regulären Ausdruck.
    Pattern p = Pattern.compile("TAA|TAG|TGA");
    Erklärung: Erstellt ein Muster, das nach den Stop-Codons TAA, TAG oder TGA sucht.


    //6.
    matcher(CharSequence input):
    // Beschreibung: Erstellt ein Matcher-Objekt, das die Eingabezeichenkette nach dem Muster durchsucht.
    Z.b: Matcher m = p.matcher(sequenceDNA.substring(3, sequenceDNA.length() - 3));
    Erklärung: Erstellt einen Matcher, der die mittlere Sequenz (ohne Start- und Stop-Codon) nach den Stop-Codons durchsucht.

    //7. 
    substring(int beginIndex, int endIndex):
    // Beschreibung: Gibt eine Teilzeichenfolge von beginIndex (inklusiv) bis endIndex (exklusiv) zurück.
    Z.b: sequenceDNA.substring(3, sequenceDNA.length() - 3)
    Erklärung: Extrahiert die mittlere Sequenz, indem die ersten 3 Basen (Start-Codon) und die letzten 3 Basen (Stop-Codon) ausgeschlossen werden.


    //8.
    find():
    // Beschreibung: Überprüft, ob das Muster irgendwo in der Eingabezeichenkette gefunden wird.
    if (m.find()) return false;
    Erklärung: Wenn der Matcher ein Stop-Codon in der mittleren Sequenz findet, ist die Sequenz ungültig.
    Verwendung
    !!! Die find()-Methode wird in Verbindung mit einem Matcher-Objekt verwendet, das aus einem Pattern-Objekt erstellt wurde.


    //9.
    indexOf(int ch):

    











}
