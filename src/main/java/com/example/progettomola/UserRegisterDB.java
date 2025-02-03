package com.example.ironmaiden;

import java.util.Scanner;

public class UserRegisterDB {

    public UserRegisterDB() {

    }

    public void registrati(User user) {

        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("registrarsi?");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("y")) {


                UserDAOImplDB userDB = new UserDAOImplDB();
                userDB.addUser(user);

/*
                for (User utente : utenti) {
                    System.out.println(utente);
                }

*/

            } else {
                UserLoginCSV userLoginCLI = new UserLoginCSV();
                userLoginCLI.doReject();
                break;
            }
        }
        //bisogna uscire in qualche modo dal while
        //chiudere la scansione
        scanner.close();
    }

}
