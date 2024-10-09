package com.plurasight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(System.in);
            FileWriter fileWriter = new FileWriter("src/main/resources/logs.txt");

            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            LocalDateTime today = LocalDateTime.now();

            DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String logTime = today.format(formattedDate);

            boolean isOn = true;
            String logEntry;


            logEntry = String.format("[%s] Program launched \n", logTime);
            bufWriter.write(logEntry);

            while (isOn) {

                System.out.print("Enter a search term (X to exit): ");
                String searchInput = keyboard.nextLine();
                today = LocalDateTime.now();
                logTime = today.format(formattedDate);
                logEntry = String.format("[%s] search: %s \n", logTime, searchInput);
                bufWriter.write(logEntry);

                if (searchInput.equalsIgnoreCase("x")) {
                    isOn = false;
                }

            }
            logEntry = String.format("[%s] Exit", logTime);
            bufWriter.write(logEntry);
            bufWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
