package com.swivel.application;
import java.util.Set;

public class Console {

    public static final String SEARCH = "1";
    public static final String LIST_FIELDS = "2";
    
    public static final String SEARCH_USERS = "1";
    public static final String SEARCH_TICKETS = "2";
    public static final String SEARCH_ORGANIZATIONS = "3";

    public static final String EXIT = "exit";
    public static final String QUIT = "quit";
   
    //This is used for home screen
    public static void displayHomeScreen() {
        StringBuilder s = new StringBuilder();
        s.append("Type 'quit' to exit at any time,Press 'Enter' to continue\n");
        System.out.println(s.toString());
    }
    //This is used for display main Options 
    public static void displayMainOptions() {
        StringBuilder s = new StringBuilder();
        s.append("\t Select search options:\n")
                .append("\t* Press " + SEARCH + " to search \n")
                .append("\t* Press " + LIST_FIELDS + " to view a list of searchable fields\n")
                .append("\t* Type '" + QUIT + "' to exit\n\n");
        System.out.println(s.toString());

    }
    
    //This is used for display Search Options
    public static void displaySearchOptions() {
        StringBuilder s = new StringBuilder();
        s.append("Select ")
                .append("1)" + "Users       ")
                .append("2)" + "Tickets     ")
                .append("3)" + "Organizations\n")
                .append("\t* Type '" + EXIT + "' to go back to the main menu or '" + QUIT + "' to quit\n\n");
        System.out.println(s.toString());

    }
    //This is used for searchable options
    public static void displaySearchableFields(String name, Set fields) {
        StringBuilder s = new StringBuilder();
        s.append("\n----------------------------------------\n");
        s.append("Search " + name + " with \n");
        fields.stream().forEach(u -> s.append(u).append("\n"));
        System.out.println(s.toString());
    }
    //This is used for display the results 
    public static void displayResults(Set results) {
        if (results.size() > 0) {
            results.stream().forEach(r ->
                System.out.println(r + "\n-----------------------------------------\n"));
            System.out.println("Total records found is  " + results.size() + "\n");
        } else {
            System.out.println("No results found");
        }
    }
    //This is used for display closing message
    public static void displayClosingMessage() {
        System.out.println("Thank you for using come again ");
    }
}
