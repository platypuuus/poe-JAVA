package fr.aelion.run;

import fr.aelion.modeles.Person;

/**
 * @name Personrun
 * Make some person instance et apres ils se disent bonjouuuuuur
 * */
public class PersonRun {

    public void run(){


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
}
