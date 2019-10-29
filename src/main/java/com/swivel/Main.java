package com.swivel;

import com.swivel.application.Console;
import com.swivel.exception.TermNotPresentException;
import com.swivel.service.SearchService;
import com.swivel.service.SearchServiceImpl;
import com.swivel.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        String user = FileUtil.getProperty("config.properties", "user.json.path");
        String tickets = FileUtil.getProperty("config.properties", "ticket.json.path");
        String org = FileUtil.getProperty("config.properties", "organization.json.path");

        File userFile = StringUtils.isBlank(user) ? getFromResource("users.json") : new File(user);
        File ticketFile = StringUtils.isBlank(tickets) ? getFromResource("tickets.json") : new File(tickets);
        File orgFile = StringUtils.isBlank(org) ? getFromResource("organizations.json") : new File(org);

        SearchService search = new SearchServiceImpl(userFile, ticketFile, orgFile);
        Console.displayHomeScreen();
        String choice;
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        ;
        //This is used for console display
        do {
            Console.displayMainOptions();
            choice = scan.next();
            switch (choice) {
                case Console.SEARCH:
                    do {
                        Console.displaySearchOptions();
                        choice = scan.next();
                        switch (choice) {
                            case Console.SEARCH_USERS:
                            case Console.SEARCH_TICKETS:
                            case Console.SEARCH_ORGANIZATIONS:
                                System.out.println("Enter search term");
                                String term = scan.next();
                                System.out.println("Enter search value");
                                String value = scan.next();
                                try {
                                    if (choice.equals(Console.SEARCH_USERS)) {
                                        Console.displayResults(search.searchByUser(term, value));
                                    } else if (choice.equals(Console.SEARCH_TICKETS)) {
                                        Console.displayResults(search.searchByTicket(term, value));
                                    } else if (choice.equals(Console.SEARCH_ORGANIZATIONS)) {
                                        Console.displayResults(search.searchByOrganization(term, value));
                                    }
                                } catch (TermNotPresentException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case Console.EXIT:
                                break;
                            case Console.QUIT:
                                Console.displayClosingMessage();
                                System.exit(1);
                            default:
                                System.out.println("Please enter a valid option.\n");
                                break;
                        }
                    } while (!choice.equals(Console.EXIT));
                    break;
                case Console.LIST_FIELDS:
                    Console.displaySearchableFields("Users", search.getUserFields());
                    Console.displaySearchableFields("Tickets", search.getTicketFields());
                    Console.displaySearchableFields("Organizations", search.getOrganizationFields());
                    break;
                case Console.QUIT:
                    Console.displayClosingMessage();
                    System.exit(1);
                default:
                    System.out.println("Please enter a valid option.\n");
                    break;
            }
        } while (!choice.equals(Console.QUIT));

    }
    //This is used for load the file
    private static File getFromResource(String s) {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(s);
        File tmpFile = null;
        try {
            tmpFile = File.createTempFile(s, ".tmp");
            FileUtils.copyInputStreamToFile(inputStream, tmpFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        return tmpFile;
    }
}
