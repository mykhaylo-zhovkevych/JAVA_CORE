package telusko;

public class ArrayObjects {
    
    public static void main(String a[]) {
        
        Student s1 = new Student();
        s1.rollno =1;
        s1.name = "Navin";
        s1.marks = 88;

        Student s2 = new Student();
        s2.rollno = 2;
        s2.name = "Bro";
        s2.marks = 83;

        Student s3 = new Student();
        s3.rollno = 2;
        s3.name = "not Bro";
        s3.marks = 33;

        Student students[] = new Student[3]; // here is array that stores the objects
        students[0] = s1;
        students[1] = s2;
        students[2] = s3;
        
//        for(int i=0; i<students.length; i++){
//
//            System.out.println(students[i].name + " : " + students[i].marks);
//
//        }

// this enhanced loop dont  use any counter(i=0) like in for loop
    for(Student n : students){
        System.out.println(n.name +" : " +n.marks);

        }
    } 
    
    public static class Student {
        public int rollno;
        public String name;
        public int marks;
    }
}
