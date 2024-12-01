package workspace;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class sq01a {

    public static void main(String[] args) {
    	
        // Erstelle eine Liste für Studenten
        List<Student> students = new ArrayList<>();

        // Füge 10 Studenten hinzu
        students.add(new Student("Max Müller", "10A", 15));
        students.add(new Student("Lisa Meier", "10B", 14));
        students.add(new Student("Tom Schuster", "9C", 16));
        students.add(new Student("Anna Schmidt", "11A", 17));
        students.add(new Student("Felix Krause", "10A", 15));
        students.add(new Student("Sophia Weber", "12B", 18));
        students.add(new Student("Lukas Braun", "9D", 14));
        students.add(new Student("Mia Fischer", "11C", 17));
        students.add(new Student("Emma Hoffmann", "10C", 16));
        students.add(new Student("Paul Richter", "9A", 13));

        // Gib die Liste der Studenten aus
        System.out.println("Liste der Studenten:");
        for (Student student : students) {
            System.out.println(student);
        }
        
        List<Student> filteredStudents = filterAgeGroup(students, 14, 16);
        List<Student> filteredStudent = filterByAge(students, 14);
        
        System.out.println("/-_-/");
        System.out.println(filteredStudents);
        
        System.out.println("/-_-/");
        System.out.println(filteredStudent);
    }

    
    
    // Methode welche die Liste von Studenten so filtert, dass nur noch Studenten in einer bestimmten Altersgruppe in einer Liste zurückgegeben werden (Alter als Parameter).
     
    // die Methode muss eine range of age gruppe 
    // die Methode muss von einer List<Student> sein
     
   
    
    public static List<Student> filterAgeGroup(List<Student> students, int minAge, int maxAge) {

        // Erstelle einen Stream aus der Liste von Studenten (students). Ein Stream ist eine
        // abstrakte Darstellung der Daten, auf denen Operationen durchgeführt werden können.
        // Anschließend wird eine Filteroperation auf dem Stream ausgeführt, um nur die Studenten
        // mit einem Alter innerhalb des angegebenen Bereichs (minAge bis maxAge) zu behalten.
        
        return students.stream()
                // Die filter-Methode überprüft für jeden Student, ob dessen Alter
                // im angegebenen Bereich (zwischen minAge und maxAge) liegt.
                .filter(student -> student.getAge() >= minAge && student.getAge() <= maxAge)
                
                // Am Ende wird der Stream mit der collect-Methode in eine neue Liste umgewandelt.
                // Die collect-Methode gibt eine Sammlung zurück (hier eine List), die das Ergebnis
                // der Filteroperation enthält. In diesem Fall wird die Liste von Studenten
                // mit den gefilterten Alterswerten zurückgegeben.
                .collect(Collectors.toList()); // Konvertiert den Stream in eine List und gibt diese zurück.
    }

    
    // So könnte es gemacht werden, mit oop
    
    
    public static ArrayList<Student> filterByAge(List<Student> students, int age){
        ArrayList<Student> filteredStudents = new ArrayList<>();
        for (Student s : students) {
            if (s.getAge() == age) {
                filteredStudents.add(s);
            }
        }
        return filteredStudents;
    }
    
    
    
    // Es soll eine Methode erstellt werden, welche die Liste von Studenten so filtert, dass nur noch Studenten der selben Klasse zurückgegeben werden (Klasse als Parameter).
    
    // ...
    
    // Interne Klasse Student
    static class Student {
    	
        private String name;
        private String className;
        private int age;

        // Konstruktor
        public Student(String name, String className, int age) {
            this.name = name;
            this.className = className;
            this.age = age;
        }

        // Getter und Setter
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            if (age > 0) { // Validierung des Alters
                this.age = age;
            } else {
                throw new IllegalArgumentException("Alter muss grösser als 0 sein.");
            }
        }

        // Überschreibe die toString-Methode für eine bessere Ausgabe
        @Override
        public String toString() {
            return "Student{name='" + name + "', className='" + className + "', age=" + age + '}';
        }
    }    
}


// nonstatic inner-class
//package workspace;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Sq01a {
//
//    public static void main(String[] args) {
//        // Erstelle eine Instanz der äußeren Klasse
//        Sq01a sq01a = new Sq01a();
//
//        // Erstelle eine Liste für Studenten
//        List<Student> students = new ArrayList<>();
//
//        // Füge 10 Studenten hinzu
//        students.add(sq01a.new Student("Max Müller", "10A", 15));
//        students.add(sq01a.new Student("Lisa Meier", "10B", 14));
//        students.add(sq01a.new Student("Tom Schuster", "9C", 16));
//        students.add(sq01a.new Student("Anna Schmidt", "11A", 17));
//        students.add(sq01a.new Student("Felix Krause", "10A", 15));
//        students.add(sq01a.new Student("Sophia Weber", "12B", 18));
//        students.add(sq01a.new Student("Lukas Braun", "9D", 14));
//        students.add(sq01a.new Student("Mia Fischer", "11C", 17));
//        students.add(sq01a.new Student("Emma Hoffmann", "10C", 16));
//        students.add(sq01a.new Student("Paul Richter", "9A", 13));
//
//        // Gib die Liste der Studenten aus
//        System.out.println("Liste der Studenten:");
//        for (Student student : students) {
//            System.out.println(student);
//        }
//    }
//
//    // Nicht-statische innere Klasse
//    class Student {
//        private String name;
//        private String className;
//        private int age;
//
//        // Konstruktor
//        public Student(String name, String className, int age) {
//            this.name = name;
//            this.className = className;
//            this.age = age;
//        }
//
//        // Getter und Setter
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getClassName() {
//            return className;
//        }
//
//        public void setClassName(String className) {
//            this.className = className;
//        }
//
//        public int getAge() {
//            return age;
//        }
//
//        public void setAge(int age) {
//            if (age > 0) { // Validierung des Alters
//                this.age = age;
//            } else {
//                throw new IllegalArgumentException("Alter muss größer als 0 sein.");
//            }
//        }
//
//        // Überschreibe die toString-Methode für eine bessere Ausgabe
//        @Override
//        public String toString() {
//            return "Student{name='" + name + "', className='" + className + "', age=" + age + '}';
//        }
//    }
//}



