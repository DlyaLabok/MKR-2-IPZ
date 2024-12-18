package Game;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Arena arena = new Arena();

            System.out.println("Choose a character type (warrior, mage, archer):");
            while (true) {
                String type = scanner.nextLine();
                if (type.equalsIgnoreCase("warrior") || type.equalsIgnoreCase("mage") || type.equalsIgnoreCase("archer")) {
                    System.out.println("Enter your character's name:");
                    String name = scanner.nextLine();

                    Character player = CharacterFactory.createCharacter(type, name);
                    System.out.println("Congratulations! You chose a character " + player.getName() + ". His base stats are: " + player);
                    arena.addCharacter(player);

                    int mannequinAttackCount = 0;
                    boolean inFightingMode = false;

                    System.out.println("WELCOME to ARENA 1. Press 1 to walk, Press 2 to attack.");
                    while (true) {
                        String action = scanner.nextLine();

                        if (action.equals("1")) {
                            player.move();
                            System.out.println(player);
                        } else if (action.equals("2")) {
                            player.attack();
                            mannequinAttackCount++;
                            Random random = new Random();
                            if (random.nextInt(100) < 30) { // 30% chance
                                player.takeDamage(10);
                                System.out.println("Mannequin fought back! " + player.getName() + " lost 10 HP.");
                                System.out.println(player);
                                if (player.getHealth() <= 0) {
                                    System.out.println("You were killed by a mannequin. What a shame! Press 0 to start all over.");
                                    break;
                                }
                            } else {
                                System.out.println("Mannequin doesn`t fight back...");
                            }

                            System.out.println("Press 0 to go to Arena menu.");
                            if (scanner.nextLine().equals("0")) {
                                break;
                            }

                            if (mannequinAttackCount == 3 && !inFightingMode) {
                                inFightingMode = true;
                                Character newCharacter = new Warrior("Newcomer");
                                arena.addCharacter(newCharacter);
                                System.out.println("You feel someone is nearby! Press 1 to greet him. Press 2 to keep on fighting the mannequin.");
                                String interaction = scanner.nextLine();

                                if (interaction.equals("1")) {
                                    System.out.println("'Hello, " + newCharacter.getName() + ". Nice to meet you! Good luck beating the mannequin.'");
                                    System.out.println("Press 1 to keep fighting the mannequin. Press 2 to go back to the Arena.");
                                    String choice = scanner.nextLine();
                                    if (choice.equals("1")) {
                                        System.out.println("Back to fighting the mannequin...");
                                    } else if (choice.equals("2")) {
                                        break;
                                    }
                                } else if (interaction.equals("2")) {
                                    System.out.println("Ignoring the newcomer. Back to fighting the mannequin...");
                                }
                            }
                        } else if (action.equals("0")) {
                            System.out.println("Returning to Arena menu...");
                            break;
                        } else {
                            System.out.println("Invalid input. Try again.");
                        }
                    }
                    break;
                } else {
                    System.out.println("Try again.");
                }
            }
        }
    }
}
