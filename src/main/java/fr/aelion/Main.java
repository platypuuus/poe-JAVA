package fr.aelion;

import fr.aelion.modeles.Person;
import fr.aelion.modeles.Student;
import fr.aelion.run.CourseRun;
import fr.aelion.run.PersonRun;
import fr.aelion.run.StudentRun;

import javax.swing.plaf.synth.Region;

public class Main {

    public static void main(String[] args) {
        CourseRun courseRun = new CourseRun();
        courseRun.run();
    }

}