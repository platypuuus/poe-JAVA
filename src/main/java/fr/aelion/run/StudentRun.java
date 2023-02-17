package fr.aelion.run;

import fr.aelion.modeles.Student;

public class StudentRun {

    public void run(){

        //genere un etudiant
        Student stu = new Student("Jean","Dupond","ultimatecrash@gmail.com");

        //defini ses ID
        stu.setUsername("user");
        stu.setPassword("pssw");

        //test ses ID
        if(!stu.isLoggedIn()){
            if(stu.login("user","pssw")){
                System.out.println("\nlogin succes !");
            }else{
                System.out.println("username ou mdp incorrect");
            }
        }else {

            System.out.println("User déja connecté");
        }

        //Test mauvais ID
        if(!stu.login("badusername","badpssw")){
            System.out.println("username ou mdp incorrect");
        }

        //Logout
        if (stu.isLoggedIn()){
            stu.logout();
        }
    }
}
