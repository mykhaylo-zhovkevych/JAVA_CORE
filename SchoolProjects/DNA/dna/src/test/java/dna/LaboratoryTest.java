package dna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LaboratoryTest {

    @ParameterizedTest(name = "{index}: calculateEvolutionaryDistance({0}, {1})")
    @CsvSource({
        "'ATGC', 'ATGC', 0",      // Identische Sequenzen
        "'ATGC', 'ATGA', 1",      // Eine Substitution
        "'ATGC', 'ATGCA', 1",     // Eine Einfügung
        "'ATGC', 'ATG', 1",       // Eine Löschung
        "'GATTACA', 'GCATGCU', 4" // Mehrere Bearbeitungen
    })
    void testCalculateEvolutionaryDistance(String dna1, String dna2, int expectedDistance) {
        Laboratory lab = new Laboratory("Test Lab");
        assertEquals(expectedDistance, lab.calculateEvolutionaryDistance(dna1, dna2));
    }
}
