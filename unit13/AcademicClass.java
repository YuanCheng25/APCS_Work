import java.util.ArrayList;

// Part a: Student class
class Student {
    private String name;
    private int favoriteNumber;
    
    public Student(String name, int favoriteNumber) {
        this.name = name;
        this.favoriteNumber = favoriteNumber;
    }
    
    public String getName() {
        return name;
    }
    
    public int getFavoriteNumber() {
        return favoriteNumber;
    }
}

// Part c: AcademicClass class
class AcademicClass {
    private Teacher teacher;
    private ArrayList<Student> students;
    
    public AcademicClass(Teacher teacher) {
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }
    
    // Alternative: set teacher after construction
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    // Add a student to the list
    public void addStudent(Student student) {
        students.add(student);
    }
    
    // Print info about the class
    public void printClassInfo() {
        System.out.println("Teacher: " + teacher.getName() + " (" + teacher.getSubject() + ")");
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }
    
    // Get names of students with favorite number n
    public ArrayList<String> studentsWithFavoriteNumber(int n) {
        ArrayList<String> names = new ArrayList<>();
        for (Student student : students) {
            if (student.getFavoriteNumber() == n) {
                names.add(student.getName());
            }
        }
        return names;
    }
    
    // Get names of students with odd favorite numbers
    public ArrayList<String> studentsWithOddFavoriteNumbers() {
        ArrayList<String> names = new ArrayList<>();
        for (Student student : students) {
            if (student.getFavoriteNumber() % 2 != 0) {
                names.add(student.getName());
            }
        }
        return names;
    }
}