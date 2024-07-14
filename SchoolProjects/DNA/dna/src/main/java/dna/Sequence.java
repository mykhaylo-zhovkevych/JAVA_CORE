package dna;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Klasse, die einen DNA Sequenz Validierungsmechanismus darstellt.
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.1
 */
public class Sequence {
    private String sequence;
    private String identNummer;
    private String foundPlace;
    private String foundTime;

    /**
     * Konstruktor für die Klasse Sequence.
     * 
     * @param sequence Die DNA Sequenz.
     * @param identNummer Die Identifikationsnummer der Sequenz.
     * @param foundPlace Der Fundort der Sequenz.
     * @param foundTime Die Fundzeit der Sequenz.
     */
    public Sequence(String sequence, String identNummer, String foundPlace, String foundTime) {
        this.sequence = sequence;
        this.identNummer = identNummer;
        this.foundPlace = foundPlace;
        this.foundTime = foundTime;
    }
    
    /**
     * Validiert die DNA Sequenz.
     * 
     * @param sequence Die zu validierende DNA Sequenz.
     * @return true, wenn die Sequenz gültig ist, false wenn ungültig.
     */
    public boolean validSequence(String sequence) {
        if (sequence == null || sequence.isEmpty()) return false;
        if (!sequence.startsWith("ATG")) return false;
        if (sequence.length() % 3 != 0) return false;
        if (!sequence.matches(".*(?:TAA|TAG|TGA)$")) return false;
        
        for (char zeichen : sequence.toCharArray()) {
            if ("ATGC".indexOf(zeichen) == -1) return false;
        }

        if (sequence.length() > 6) {
            String CR = sequence.substring(3, sequence.length() - 3);
            Pattern p = Pattern.compile("TAA|TAG|TGA");
            Matcher m = p.matcher(CR);
            if (m.find()) return false;
        }

        return true;
    }

    public String getSequence() {
        return sequence;
    }

    public String getIdentNummer() {
        return identNummer;
    }

    public String getFoundPlace() {
        return foundPlace;
    }

    public String getFoundTime() {
        return foundTime;
    }
}
