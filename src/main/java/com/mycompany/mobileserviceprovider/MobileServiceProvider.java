import javax.swing.JOptionPane;

public class MobileServiceProvider {

    public static void main(String[] args) {
        char choice;
        double hours, totalCharges = 0, savings = 0;
        String input;

        // Loop to allow running the program multiple times
        do {
            // Ask user to enter package choice and hours used
            input = JOptionPane.showInputDialog("Enter the package (A, B, or C): ");
            choice = input.charAt(0);
            input = JOptionPane.showInputDialog("Enter the number of hours used: ");
            hours = Double.parseDouble(input);

            // Calculate total charges based on package choice
            switch (choice) {
                case 'A':
                case 'a':
                    totalCharges = calculateCharges(hours, 9.95, 10, 2.0);
                    savings = calculateSavings(totalCharges, hours, 13.95, 20, 1.0);
                    break;
                case 'B':
                case 'b':
                    totalCharges = calculateCharges(hours, 13.95, 20, 1.0);
                    savings = calculateSavings(totalCharges, hours, 19.95, 0, 0);
                    break;
                case 'C':
                case 'c':
                    totalCharges = 19.95;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid package choice!");
            }

            // Display total charges and savings
            JOptionPane.showMessageDialog(null, "Total charges: $" + totalCharges +
                                                "\nAmount of money saved: $" + savings);

            // Ask user if they want to run the program again
            input = JOptionPane.showInputDialog("Do you want to calculate again? (yes/no)");
        } while (input != null && input.equalsIgnoreCase("yes"));
    }

    // Method to calculate total charges based on hours used and package details
    public static double calculateCharges(double hours, double basePrice, double includedHours, double additionalHourRate) {
        double totalCharges;
        if (hours > includedHours) {
            totalCharges = basePrice + (hours - includedHours) * additionalHourRate;
        } else {
            totalCharges = basePrice;
        }
        return totalCharges;
    }

    // Method to calculate savings based on total charges and alternative package details
    public static double calculateSavings(double currentCharges, double hours, double altBasePrice, double altIncludedHours, double altAdditionalHourRate) {
        double altCharges = calculateCharges(hours, altBasePrice, altIncludedHours, altAdditionalHourRate);
        return altCharges - currentCharges;
    }
}
