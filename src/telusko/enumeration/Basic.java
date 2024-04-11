package telusko.enumeration;

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class Basic {
    Day day;

    public Basic(Day day) {
        this.day = day;
    }

    public void dayIsLike() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
            case SATURDAY: case SUNDAY:
                System.out.println("Weekends are best.");
                break;
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

    
    public static void main(String[] args) {
        Basic firstDay = new Basic(Day.MONDAY);
        firstDay.dayIsLike();
        Basic thirdDay = new Basic(Day.WEDNESDAY);
        thirdDay.dayIsLike();

        }
    }   
