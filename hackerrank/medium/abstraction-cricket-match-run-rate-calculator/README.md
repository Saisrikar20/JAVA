# Abstraction - Cricket Match Run Rate Calculator

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine a sports analytics app is being developed to provide real-time updates to fans watching a cricket match. The app includes a feature where users can check the required run rate and remaining balls for any ongoing game in one of the three formats: ODI, T20, or Test. The app calculates and displays the run rate based on the user’s inputs for each game format.

Program Specifications

Abstract Class: Match

Attributes (private):

- int currentScore - The team's current score.
- float currentOver - The current over in the innings.
- int target - The target score to win.

Methods:

- Abstract method float calculateRunrate(): calculates the required run rate.
- Abstract method int calculateBalls(): calculates the remaining balls.
- Method void display(double reqRunRate, int balls): displays the number of balls remaining and the required run rate in a specified format.

Derived Classes:

- ODIMatch: A class extending Match with specific calculations for 50 overs (300 balls).
- T20Match: A class extending Match with calculations for 20 overs (120 balls).
- TestMatch: A class extending Match with calculations for 90 overs (540 balls).

Driver Class:

Main

- Creates instances of the ODIMatch, T20Match, and TestMatch classes and calculates the required run rate and remaining balls for each format.

 **Input Format** 

- Cricket format (1 for ODI, 2 for T20, 3 for Test)
- Current Score (int)
- Current Over (float)
- Target Score (int)

 **Constraints** 

NA

 **Output Format** 

Display requirements: Runs needed, balls remaining, and required run rate to two decimal places.

 **Sample Input 0** 

```
1
256
30
400

```

 **Sample Output 0** 

```
Enter the Cricket Format
1.ODI
2.T20
3. Test
Enter the Current Score
Enter the Current Over
Enter the Target Score
Requirements:
Need 144 Runs in 120 balls
Required Run Rate - 7.20

```

 **Sample Input 1** 

```
2
120
15
170

```

 **Sample Output 1** 

```
Enter the Cricket Format
1.ODI
2.T20
3. Test
Enter the Current Score
Enter the Current Over
Enter the Target Score
Requirements:
Need 50 Runs in 30 balls
Required Run Rate - 10.00

```

 **Sample Input 2** 

```
3
200
60
450

```

 **Sample Output 2** 

```
Enter the Cricket Format
1.ODI
2.T20
3. Test
Enter the Current Score
Enter the Current Over
Enter the Target Score
Requirements:
Need 250 Runs in 180 balls
Required Run Rate - 8.33

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:39:10.747Z  

```java
import java.util.*;

abstract class Match {
    private int currentScore;
    private float currentOver;
    private int target;

    public Match(int currentScore, float currentOver, int target) {
        this.currentScore = currentScore;
        this.currentOver = currentOver;
        this.target = target;
    }

    protected int getCurrentScore() {
        return currentScore;
    }

    protected float getCurrentOver() {
        return currentOver;
    }

    protected int getTarget() {
        return target;
    }

    abstract float calculateRunrate();

    abstract int calculateBalls();

    public void display(double reqRunRate, int balls) {
        System.out.println("Requirements:");
        System.out.println("Need " + (target - currentScore) +
                           " Runs in " + balls + " balls");
        System.out.printf("Required Run Rate - %.2f%n", reqRunRate);
    }
}

class ODIMatch extends Match {
    public ODIMatch(int score, float over, int target) {
        super(score, over, target);
    }

    float calculateRunrate() {
        int runsNeeded = getTarget() - getCurrentScore();
        int ballsRemaining = calculateBalls();
        return ballsRemaining > 0 ? runsNeeded * 6.0f / ballsRemaining : 0;
    }

    int calculateBalls() {
        return 300 - (int)(getCurrentOver() * 6);
    }
}

class T20Match extends Match {
    public T20Match(int score, float over, int target) {
        super(score, over, target);
    }

    float calculateRunrate() {
        int runsNeeded = getTarget() - getCurrentScore();
        int ballsRemaining = calculateBalls();
        return ballsRemaining > 0 ? runsNeeded * 6.0f / ballsRemaining : 0;
    }

    int calculateBalls() {
        return 120 - (int)(getCurrentOver() * 6);
    }
}

class TestMatch extends Match {
    public TestMatch(int score, float over, int target) {
        super(score, over, target);
    }

    float calculateRunrate() {
        int runsNeeded = getTarget() - getCurrentScore();
        int ballsRemaining = calculateBalls();
        return ballsRemaining > 0 ? runsNeeded * 6.0f / ballsRemaining : 0;
    }

    int calculateBalls() {
        return 540 - (int)(getCurrentOver() * 6);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Cricket Format");
        System.out.println("1.ODI");
        System.out.println("2.T20");
        System.out.println("3. Test");

        int format = sc.nextInt();

        System.out.println("Enter the Current Score");
        int score = sc.nextInt();

        System.out.println("Enter the Current Over");
        float over = sc.nextFloat();

        System.out.println("Enter the Target Score");
        int target = sc.nextInt();

        Match match;

        if (format == 1) {
            match = new ODIMatch(score, over, target);
        } else if (format == 2) {
            match = new T20Match(score, over, target);
        } else {
            match = new TestMatch(score, over, target);
        }

        match.display(match.calculateRunrate(), match.calculateBalls());

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/abstraction-cricket-match-run-rate-calculator/problem)