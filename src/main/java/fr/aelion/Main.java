package fr.aelion;

import fr.aelion.modeles.Person;
import fr.aelion.modeles.Student;
import fr.aelion.run.PersonRun;
import fr.aelion.run.StudentRun;

import javax.swing.plaf.synth.Region;

public class Main {

    public static void main(String[] args) {
        PersonRun PR = new PersonRun();
        PR.run();

        new StudentRun().run();
    }

}