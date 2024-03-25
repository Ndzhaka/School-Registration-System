import java.util.ArrayList;
import java.util.Scanner;

public class SchoolRegistrationSystem {

    static class Learner {
        private ArrayList<String> learners = new ArrayList<>();
        private Scanner scanner;

        public Learner(Scanner scanner) {
            this.scanner = scanner;
            learners.add("Johnny");
            learners.add("Freddy");
            learners.add("Brandon");
            learners.add("Mark");
        }

        public void addLearner(String newLearner) {
            learners.add(newLearner);
        }

        public void removeLearner() {
            displayLearners();
            System.out.println("Enter the number of the learner you want to remove:");
            int indexToRemove = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (indexToRemove >= 0 && indexToRemove < learners.size()) {
                String removedLearner = learners.remove(indexToRemove);
                System.out.println("Learner " + removedLearner + " has been removed.");
            } else {
                System.out.println("Invalid learner number.");
            }
        }

        public void updateLearner() {
            displayLearners();
            System.out.println("Enter the number of the learner you want to update:");
            int indexToUpdate = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (indexToUpdate >= 0 && indexToUpdate < learners.size()) {
                System.out.println("Enter the new name for the learner:");
                String newName = scanner.nextLine();
                learners.set(indexToUpdate, newName);
                System.out.println("Learner updated successfully.");
            } else {
                System.out.println("Invalid learner number.");
            }
        }

        public void displayLearners() {
            System.out.println("Learners:");
            for (int i = 0; i < learners.size(); i++) {
                System.out.println(i + ") " + learners.get(i));
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Learner learner = new Learner(scanner);
            int continueChoice = 1;
            while (continueChoice == 1) {
                System.out.println("Welcome!\n1) Add a learner\n2) Quit");
                int userAnswer = scanner.nextInt();
                scanner.nextLine();
                if (userAnswer == 1) {
                    System.out.println("Enter Learner name:");
                    String learnerName = scanner.nextLine();
                    learner.addLearner(learnerName);
                    System.out.println("Do you want to perform a task?");
                    System.out.println("1) Update Learner\n2) Display Learners\n3) Add a Learner\n4) Remove a Learner\n5) Continue");
                    continueChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    switch (continueChoice) {
                        case 1:
                            learner.updateLearner();
                            break;
                        case 2:
                            learner.displayLearners();
                            break;
                        case 3:
                            System.out.println("Enter the name of the learner you want to add:");
                            String newName = scanner.nextLine();
                            learner.addLearner(newName);
                            break;
                        case 4:
                            learner.removeLearner();
                            break;
                        default:
                            break;
                    }
                } else {
                    System.out.println("See you soon!");
                    break;
                }
            }
        }
    }
}
