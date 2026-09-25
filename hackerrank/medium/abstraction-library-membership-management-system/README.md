# Abstraction - Library Membership Management System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Clara, a librarian, finds it challenging to track library member details, such as card numbers, book borrowing limits, and return dates. To simplify her workflow, we will design a basic Library Membership Management System that categorizes memberships into two types: Membership Card and LifeLong Membership Card. The system will allow her to enter member details and select the type of membership. Each membership type has different borrowing limits and return policies.

This solution uses Java to implement the classes and attributes Clara needs, including member details, borrowing limits, and return dates.

Program Specifications

Abstract Class: LibraryCard

Protected Attributes:

- String memberDetails: holds combined member information including name, card number, and expiry date.

Constructor:

- Initializes the memberDetails attribute.

Getters and Setters:

- Provides access to memberDetails.

Concrete Classes:

MembershipCard:

Private Attribute:

- Integer minimumBookToBorrow: minimum number of books the member can borrow.

Constructor:

- Takes memberDetails and minimumBookToBorrow.

Due Date Policy: Members with this card can keep books for 10 days.

LifeLongMembershipCard:

Private Attribute:

- Integer minimumBookToBorrow: minimum number of books the member can borrow.

Constructor:

- Takes memberDetails and minimumBookToBorrow.

Due Date Policy: Members with this card have an unlimited due date.

Main Class:

- Prompts Clara to choose a membership type and enter member details in the specified format.
- Based on the choice, it creates the appropriate membership type and displays details.

 **Input Format** 

- First Input: Choice of membership type (Integer: 1 for LifeLong Membership Card, 2 for Membership Card).
- Second Input: Member details in the format: Name | CardNumber | ExpiryDate (String).
- Third Input: Minimum number of books to borrow (Integer).

 **Constraints** 

NA

 **Output Format** 

- Display the member's name followed by "Membership Card Details".
- On the next line, display "Card Number:" followed by the card number.
- On the next line, display "Minimum books to borrow:" followed by the minimum number of books.
- On the final line, display the "Due date to return the book:" with the respective return period. For Membership Card: "10 days from the book taken". For LifeLong Membership Card: "unlimited".
- If the choice is invalid: Print " Invalid choice".

 **Sample Input 0** 

```
1
John Doe | 23456 | 01/05/2025
3

```

 **Sample Output 0** 

```
Here comes a choice to view
1. Lifelong Membership Card
2. Membership Card
Enter member details in format: Name | CardNumber | ExpiryDate
Enter the minimum number of books to borrow:
John Doe's Membership Card Details
Card Number: 23456
Minimum books to borrow: 3
Due date to return the book: unlimited

```

 **Sample Input 1** 

```
2
Alice Smith | 34567 | 22/07/2023
1

```

 **Sample Output 1** 

```
Here comes a choice to view
1. Lifelong Membership Card
2. Membership Card
Enter member details in format: Name | CardNumber | ExpiryDate
Enter the minimum number of books to borrow:
Alice Smith's Membership Card Details
Card Number: 34567
Minimum books to borrow: 1
Due date to return the book: 10 days from the book taken

```

 **Sample Input 2** 

```
3
Tom Baker | TB111 | 01-01-2027
4

```

 **Sample Output 2** 

```
Here comes a choice to view
1. Lifelong Membership Card
2. Membership Card
Enter member details in format: Name | CardNumber | ExpiryDate
Enter the minimum number of books to borrow:
Invalid choice

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-25T03:44:27.227Z  

```java
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

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/abstraction-library-membership-management-system/problem)