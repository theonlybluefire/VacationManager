package src.main.java.utils;

import java.util.Scanner;

import src.main.java.main;

public class StartupUtils {
    public static void startup() {
        System.out.println("\r\n" + //
                "\r\n" + //
                "____   ____                     __  .__                  _____                                                _________   _____________ \r\n"
                + //
                "\\   \\ /   /____    ____ _____ _/  |_|__| ____   ____    /     \\ _____    ____ _____    ____   ___________    /     \\   \\ /   |______   \\\r\n"
                + //
                " \\   Y   /\\__  \\ _/ ___\\\\__  \\\\   __\\  |/  _ \\ /    \\  /  \\ /  \\\\__  \\  /    \\\\__  \\  / ___\\_/ __ \\_  __ \\  /  \\ /  \\   Y   / |     ___/\r\n"
                + //
                "  \\     /  / __ \\\\  \\___ / __ \\|  | |  (  <_> )   |  \\/    Y    \\/ __ \\|   |  \\/ __ \\/ /_/  >  ___/|  | \\/ /    Y    \\     /  |    |    \r\n"
                + //
                "   \\___/  (____  /\\___  >____  /__| |__|\\____/|___|  /\\____|__  (____  /___|  (____  |___  / \\___  >__|    \\____|__  /\\___/   |____|    \r\n"
                + //
                "               \\/     \\/     \\/                    \\/         \\/     \\/     \\/     \\/_____/      \\/                \\/                   \r\n"
                + //
                "\r\n" + //
                "");
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println("What do you want to do ?\r\n" + //
                "(n) Create a new preset\r\n" + //
                "(s) Show/Select available presets\r\n" + //
                "(p) Plan a new booking\r\n" + //
                "(r) Configure\r\n" + //
                "(e) Exit\r\n" + //
                "Please enter the number of your choice: ");
        Scanner scanner = new Scanner(System.in);
        char choice = scanner.next().charAt(0);
        scanner.nextLine();

        try {
            switch (choice) {
                case 'n':
                System.out.print("Name of the new holiday preset: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter your local holidays (Format: dd/mm, dd/mm, ...): ");
                    String dayString = scanner.nextLine();

                    PresetUtils.createNewPreset(name, dayString);

                    System.out.println("Preset created successfully. Press any key to continue...");
                    scanner.nextLine();
                    mainMenu();
                    break;
                case 's':
                    break;
                case 'p':
                    break;
                case 'r':
                    break;
                case 'e':
                    break;
                default:
                    System.out.println("Invalid choice.");
                    mainMenu();
                    break;
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        scanner.close();
    }
}
