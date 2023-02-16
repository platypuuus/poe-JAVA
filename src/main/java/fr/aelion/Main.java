package fr.aelion;

import fr.aelion.modeles.Person;
import fr.aelion.modeles.Student;

import javax.swing.plaf.synth.Region;

public class Main {
    private static Main app;

    public static void main(String[] args) {
        app = new Main();
        System.out.println("Je suis la methode main !! :p XD");
    }

    public Main() {


        Person jl = new Person();
        jl.setFirstName("Damien");
         jl.setLastName("Nomdefamille");
         jl.setPhoneNumber("0666666666");
         jl.setEmail("rien@gmail.com");
        System.out.printf( jl.greetings());


        Person bs = new Person("Saquet", "Bilbon", "0111111111", "laConte@gmail.com");
        /** bs.firstName = "Bilbon";
         bs.lastName = "Saquet";
         bs.phoneNumber = "0111111111";
         bs.email = "laConte@gmail.com";*/
        System.out.printf( bs.greetings());




    }

    public void testStudent(){

        //genere un etudiant
        Student stu = new Student("Jean","Dupond","ultimatecrash@gmail.com");

        //defini ses ID
        stu.setUsername("user");
        stu.setPassword("pssw");

        //test ses ID
        if(!stu.isLoggedIn()){
            if(stu.login("user","pssw")){
                System.out.println("login succes !");
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

    public Main(String name) {

        System.out.println("Salut " + name + " !");
    }
}