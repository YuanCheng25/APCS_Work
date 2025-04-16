public class testBoth2 {
    public static void main(String[] args) {
  Teacher teacher = new Teacher("Dr. Kessner", "PCHA");
        AcademicClass mathClass = new AcademicClass(teacher);
        
        mathClass.addStudent(new Student("Sally", 7));
        mathClass.addStudent(new Student("Yvonne", 42));
        mathClass.addStudent(new Student("Kris", 7));
        
        mathClass.printClassInfo();
        System.out.println("Students who like 7: " + mathClass.studentsWithFavoriteNumber(7));
        System.out.println("Students with odd favorite numbers: " + mathClass.studentsWithOddFavoriteNumbers());
        
    }
}