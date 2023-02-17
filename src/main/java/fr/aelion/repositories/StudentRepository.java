package fr.aelion.repositories;

import fr.aelion.modeles.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public List<Student> students = new ArrayList<>();

    public StudentRepository() {
        populate();
    }

    private void populate() {
        //genere un etudiant
        Student stu = new Student("Jean", "Dupond", "ultimatecrash@gmail.com");

        //defini ses ID
        stu.setUsername("user");
        stu.setPassword("pssw");

        //Add student to list
        this.students.add(stu);

    }
}
