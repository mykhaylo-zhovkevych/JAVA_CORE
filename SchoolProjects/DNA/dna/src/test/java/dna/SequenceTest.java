package dna;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class SequenceTest {

//Dieser JUnit-Test ist für Aufgabe 4, aber er wird auch für 3 passen, weil ich die gleiche Klasse(Sequenz) mit der gleichen Logik eingesetzt hatte.
	
    @ParameterizedTest(name = "{index}: {0}")
    @CsvSource({
    	// Gültige Sequenzen
    	"ATGTAA, true",  // korrekt, Länge 6
        "ATGCGCTAA, true",  // korrekt, Länge 9
        "ATGCCCCCCTAA, true",  // korrekt, Länge 12
        
        // Ungültige Sequenzen
        // 3. Die DNA Sequenz muss mit dem 3-er Block ATG beginnen.
        "TTTCCCCCCTAA, false",  // keine Anfang-Codon
        
        // 4. Die DNA Sequenz muss mit einer der folgenden Stop 3-er Blöcke beendet werden: TAA, TAG oder TGA.
        "ATGCGTA, false", // Länge 6, aber ungültig (kein Stop-Codon)
      
        // 5. Die in Punkt 4 beschriebenen 3-er Blöcke dürfen sonst nirgends in der Sequenz vorkommen.
        "ATGCGTAAAGTGA, false", // enthält Stop-Codon TGA in der Mitte
        "ATGCGTAGTAG, false", // enthält Stop-Codon TAG in der Mitte
        "ATGCGTAAGTAA, false", // enthält Stop-Codon TAA in der Mitte
        
        // Andere Fälle
        "ATGABCTAA, false", // falscher Buchstabe B
        "ATGCGTAG, false", // Länge 7, nicht durch 3 teilbar
        "ATGCAT, false", // nicht durch 3 teilbar
        
    })
    void testValidation(String seq, boolean expectedResult) {
        Sequence sequence = new Sequence(seq, "ID1", "Ort", "Datum");
        assertEquals(expectedResult, sequence.validSequence(seq));
    }
}