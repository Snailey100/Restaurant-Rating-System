import java.util.Scanner;

public class TallahasseeRestaurantRatings {
    static Scanner scanner = new Scanner(System.in);

    public static int getValidRating() {
        int rating;
        System.out.println("Please enter a valid rating (1-5):");
        rating = scanner.nextInt();
        while (rating < 1 || rating > 5) {
            System.out.println("Please enter a valid rating (1-5):");
            rating = scanner.nextInt();
        }
        return rating;
    }

    public static int getValidRestaurant(int NUM_RESTAURANTS) {
        int restaurants;
        System.out.println("Please enter the restaurants number:");
        restaurants = scanner.nextInt();
        while (restaurants < 1 || restaurants > NUM_RESTAURANTS) {
            System.out.println("Please enter a valid restaurants number:");
            restaurants = scanner.nextInt();
        }
        return restaurants;
    }

    public static void displayRatings(int[] storeRatings, int NUM_RESTAURANTS) {
        System.out.println("Display Ratings");
        for (int i = 0; i < NUM_RESTAURANTS; i++) {
            System.out.print(storeRatings[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Count by Rating");
        int[] counts = new int[6];
        for (int rating : storeRatings) {
            counts[rating]++;
        }
        for (int i = 1; i <= 5; i++) {
            System.out.printf("%-20d%d\n", i, counts[i]);
        }
    }

    public static double calculateAverageRating(int[] restaurantRatings) {
        double sum = 0;
        for (int rating : restaurantRatings) {
            sum += rating;
        }
        return sum / restaurantRatings.length;
    }

    public static void changeRating(int[] restaurantRatings) {
        int NUM_RESTAURANTS = restaurantRatings.length;
        int customer = getValidRestaurant(NUM_RESTAURANTS);
        int rating = getValidRating();
        restaurantRatings[customer - 1] = rating;
    }

    public static int getLowestRating(int[] restaurantRatings) {
        int lowest = restaurantRatings[0];
        for (int i = 1; i < restaurantRatings.length; i++) {
            if (restaurantRatings[i] < lowest) {
                lowest = restaurantRatings[i];
            }
        }
        return lowest;
    }

    public static int getHighestRating(int[] restaurantRatings) {
        int highest = restaurantRatings[0];
        for (int i = 1; i < restaurantRatings.length; i++) {
            if (restaurantRatings[i] > highest) {
                highest = restaurantRatings[i];
            }
        }
        return highest;
    }

    public static void sortRatingsAscending(int[] restaurantRatings) {
        for (int i = 0; i < restaurantRatings.length - 1; i++) {
            for (int j = 0; j < restaurantRatings.length - i - 1; j++) {
                if (restaurantRatings[j] > restaurantRatings[j + 1]) {
                    int temp = restaurantRatings[j];
                    restaurantRatings[j] = restaurantRatings[j + 1];
                    restaurantRatings[j + 1] = temp;
                }
            }
        }
    }

    public static void sortRatingsDescending(int[] restaurantRatings) {
        for (int i = 0; i < restaurantRatings.length - 1; i++) {
            for (int j = i + 1; j < restaurantRatings.length; j++) {
                if (restaurantRatings[i] < restaurantRatings[j]) {
                    int temp = restaurantRatings[i];
                    restaurantRatings[i] = restaurantRatings[j];
                    restaurantRatings[j] = temp;
                }
            }
        }
    }

    public static int[] addAnotherRating(int[] restaurantRatings, int newRating) {
        int[] newProductRatings = new int[restaurantRatings.length + 1];
        System.arraycopy(restaurantRatings, 0, newProductRatings, 0, restaurantRatings.length);
        newProductRatings[newProductRatings.length - 1] = newRating;
        return newProductRatings;
    }

    public static void main(String[] args) {
        int NUM_RESTAURANTS = 113;
        int[] restaurantRatings = {
                4, 4, 4, 2, 3, 4, 5, 4, 5, 4,
                4, 3, 4, 4, 5, 4, 4, 4, 4, 3,
                2, 5, 5, 5, 4, 4, 4, 5, 4, 5,
                3, 4, 2, 3, 3, 4, 3, 5, 4, 3,
                5, 5, 4, 5, 3, 3, 3, 4, 3, 5,
                3, 4, 4, 5, 5, 3, 4, 2, 5, 3,
                4, 3, 4, 4, 2, 3, 4, 5, 4, 3,
                3, 3, 4, 4, 2, 2, 3, 5, 4, 4,
                4, 4, 3, 4, 5, 4, 4, 5, 3, 3,
                3, 3, 4, 4, 3, 3, 4, 4, 4, 4,
                3, 3, 4, 5, 3, 2, 5, 4, 3, 5,
                3, 4, 1
        };
        System.out.println("Welcome to the Starbucks Coffee Customer Ratings Program!");
        int choice;
        do {
            System.out.println("1) Display ratings");
            System.out.println("2) Change a rating");
            System.out.println("3) Display the average rating");
            System.out.println("4) Find the lowest rating");
            System.out.println("5) Find the highest rating");
            System.out.println("6) Display sorted ratings ascending");
            System.out.println("7) Display sorted ratings descending");
            System.out.println("8) Add another rating");
            System.out.println("9) Quit");
            System.out.println("Select an option (1-9):");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayRatings(restaurantRatings, NUM_RESTAURANTS);
                    break;
                case 2:
                    changeRating(restaurantRatings);
                    break;
                case 3:
                    System.out.printf("The average rating is: %.2f\n", calculateAverageRating(restaurantRatings));
                    break;
                case 4:
                    System.out.println("The lowest rating is: " + getLowestRating(restaurantRatings));
                    break;
                case 5:
                    System.out.println("The highest rating is: " + getHighestRating(restaurantRatings));
                    break;
                case 6:
                    sortRatingsAscending(restaurantRatings);
                    displayRatings(restaurantRatings, NUM_RESTAURANTS);
                    break;
                case 7:
                    sortRatingsDescending(restaurantRatings);
                    displayRatings(restaurantRatings, NUM_RESTAURANTS);
                    break;
                case 8:
                    System.out.println("Enter the new rating:");
                    int newRating = getValidRating();
                    restaurantRatings = addAnotherRating(restaurantRatings, newRating);
                    NUM_RESTAURANTS++;
                    break;
                case 9:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 9.");
            }
        } while (choice != 9);
        scanner.close();
    }
}