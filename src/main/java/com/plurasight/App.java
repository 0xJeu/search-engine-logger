package com.plurasight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        //System start log message
        actionLogger("Launch");

        //Main app function
        while (true){
            System.out.print("Enter a search term (X to exit): ");
            String searchInput = keyboard.nextLine();

            if (searchInput.equalsIgnoreCase("X")){
                actionLogger("Exit");
                System.exit(0);
            }else {
                actionLogger("Search - " +searchInput);
            }
        }

    }
   public static void actionLogger(String action) {
        try {

            //Create bufWriter to write to log file
           FileWriter fileWriter = new FileWriter("src/main/resources/logs.txt", true);
           BufferedWriter bufWriter = new BufferedWriter(fileWriter);

           //Obtain date and format date
           LocalDateTime today = LocalDateTime.now();
           DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
           String logTime = today.format(formattedDate);

           //Log actions from user and write to log file
           String logEntry = String.format("[%s] %s \n", logTime, action);
           bufWriter.write(logEntry);

           //Release file
           bufWriter.close();

       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
