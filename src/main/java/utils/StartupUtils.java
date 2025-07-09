package src.main.java.utils;

import java.util.Scanner;

import src.main.java.logic.DayModelLogic;
import src.main.java.model.Config;
import src.main.java.model.Preset;

public class StartupUtils {
    public Preset preset;
    public Config config;

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
                "(p) Plan a new booking\r\n" + //
                "(e) Exit\r\n" + //
                "Please enter the number of your choice: ");
        Scanner scanner = new Scanner(System.in);
        char choice = scanner.next().charAt(0);
        scanner.nextLine();

        try {
            switch (choice) {
                case 'n': // create new preset
                    System.out.print("Name of the new holiday preset: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter your local holidays (Format: dd/mm, dd/mm, ...): ");
                    String dayString = scanner.nextLine();

                    PresetUtils.createNewPreset(name, dayString);

                    System.out.println("Preset created successfully. Press any key to continue...");
                    scanner.nextLine();
                    scanner.close();
                    mainMenu();
                    break;
                case 's': // show available presets
                    break;
                case 'p': // new booking
                    String[] presets = PresetUtils.getAvailablePresets();
                    int i = 0;
                    Config config = new Config();

                    System.out.println(
                            "Following presets are avaible to choose. Please type the according number to select a preset");

                    for (String preset : presets) {
                        System.out.println(i + " > " + preset);
                        i++;
                    }
                    int presetNumber = scanner.nextInt();

                    Preset preset = new Preset(presets[presetNumber], config.currentYear, config.startWeekday);

                    DayModelLogic.generateDayModel(preset, config);

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
