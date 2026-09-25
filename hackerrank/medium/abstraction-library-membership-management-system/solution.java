import java.util.Scanner;
abstract class LibraryCard {
    protected String memberDetails;
    LibraryCard(String memberDetails) {
        this.memberDetails = memberDetails;
    }
    public String getMemberDetails() {
        return memberDetails;
    }
    public void setMemberDetails(String memberDetails) {
        this.memberDetails = memberDetails;
    }
    abstract void displayDetails();
}
class MembershipCard extends LibraryCard {
    private Integer minimumBookToBorrow;
    MembershipCard(String memberDetails, Integer minimumBookToBorrow) {
        super(memberDetails);
        this.minimumBookToBorrow = minimumBookToBorrow;
    }
    void displayDetails() {
        String[] details = memberDetails.split("\\|");
        String name = details[0].trim();
        String cardNumber = details[1].trim();
        System.out.println(name + "'s Membership Card Details");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Minimum books to borrow: " + minimumBookToBorrow);
        System.out.println("Due date to return the book: 10 days from the book taken");
    }
}
class LifeLongMembershipCard extends LibraryCard {
    private Integer minimumBookToBorrow;
    LifeLongMembershipCard(String memberDetails, Integer minimumBookToBorrow) {
        super(memberDetails);
        this.minimumBookToBorrow = minimumBookToBorrow;
    }
    void displayDetails() {
        String[] details = memberDetails.split("\\|");
        String name = details[0].trim();
        String cardNumber = details[1].trim();
        System.out.println(name + "'s Membership Card Details");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Minimum books to borrow: " + minimumBookToBorrow);
        System.out.println("Due date to return the book: unlimited");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Here comes a choice to view");
        System.out.println("1. Lifelong Membership Card");
        System.out.println("2. Membership Card");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter member details in format: Name | CardNumber | ExpiryDate");
        String memberDetails = sc.nextLine();
        System.out.println("Enter the minimum number of books to borrow:");
        int minimumBookToBorrow = sc.nextInt();
        LibraryCard card;
        if(choice == 1) {
            card = new LifeLongMembershipCard(memberDetails, minimumBookToBorrow);
            card.displayDetails();
        }
        else if(choice == 2) {
            card = new MembershipCard(memberDetails, minimumBookToBorrow);
            card.displayDetails();
        }
        else {
            System.out.println("Invalid choice");
        }
        sc.close();
    }
}
