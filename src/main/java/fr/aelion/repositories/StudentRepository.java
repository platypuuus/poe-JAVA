package fr.aelion.repositories;

import fr.aelion.modeles.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public StudentRepository() {
        populate();
    }
    public boolean findByLoginAndPassword(String login,String password){
        for (Student student : this.students) {
            if (student.getUsername().equals(login) && student.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public int size(){
        return this.students.size();
    }
    private void populate() {
        //genere un etudiant
        Student stu = new Student("Jean", "Dupond", "ultimatecrash@gmail.com");

        //defini ses ID
        stu.setUsername("user");
        stu.setPassword("mdptest");

        //Add student to list
        this.students.add(stu);

    }
}
