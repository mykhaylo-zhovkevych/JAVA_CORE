//package com.wiss.m295.sq1c; // Definiert das Package für die Klasse
//
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.Arrays; // Importiert die Klasse für Arrays
//import java.util.List; // Importiert die Klasse für Listen
//
//@RestController // Markiert die Klasse als REST-Controller
//public class StudentController2 { // Definition der StudentController-Klasse
//
//    // Definiert eine Liste von Studenten
//    List<String> students = new ArrayList<>(Arrays.asList("Pascal", "Nrunno", "jan")); // Initialisiert die Liste mit Studenten
//
//    // Bindet die Methode an GET-Anfragen an die URL "/student"
//    @GetMapping("/student")
//    public List<String> getStudents() { // Methode, die eine Liste von Studenten zurückgibt
//        return students; // Gibt die Liste der Studenten zurück
//    }
//
//    // Bindet die Methode an DELETE-Anfragen an die URL "/student/{id}"
//    @DeleteMapping("/student/{id}") // Der Platzhalter {id} in der URL wird für den Parameter verwendet
//
//    // Methode zum Löschen eines Studenten
//    public ResponseEntity<String> deleteStudent(@PathVariable int id)
//    {
//        if (id < 0 || id >= students.size()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body("Invalid student ID: " + id);
//        }
//        String removedStudent = students.remove(id);
//        return ResponseEntity.ok(removedStudent);
//    }
//
//}

