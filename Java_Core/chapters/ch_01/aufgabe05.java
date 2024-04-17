package chapters.ch_01;

/**
 * (Population projection)
 * <p>
 * One birth every 7 seconds
 * One death every 13 seconds
 * One new immigrant every 45 seconds
 * Write a program to display the population for each of
 * the next five years.
 * Current population is 312,032,486 and a year is 365 days.
 */


public class aufgabe05 {

    public static void main(String[] args) {

        double birthInSeconds = 7.0;
        double deathInSeconds = 13.0;
        double immigrationInSeconds = 45.0;

        // secondstep after the second method
        double birthsPerYear = calculateOccurrencesPerYear(birthInSeconds);
        // secondsInYear(return) = Approximately 60 * 60 * 24 * 365 / 7.
        double deathsPerYear = calculateOccurrencesPerYear(deathInSeconds);
        // secondsInYear(return) = Approximately 60 * 60 * 24 * 365 / 13.0.
        double immigratePerYear = calculateOccurrencesPerYear(immigrationInSeconds);
        // secondsInYear(return) = Approximately 60 * 60 * 24 * 365 / 45.0.

        double currentPopulation = 312_032_486;

        for (int i = 1; i <= 5; i++) {
            currentPopulation += birthsPerYear - deathsPerYear + immigratePerYear;

        System.out.printf("The population in year %d will be %1.0f%n", i, currentPopulation);

        }
    }

    public static double calculateOccurrencesPerYear(double valueInSeconds) {

        double secondsInYear = 60 * 60 * 24 * 365;

        return secondsInYear / valueInSeconds;
    }
}
