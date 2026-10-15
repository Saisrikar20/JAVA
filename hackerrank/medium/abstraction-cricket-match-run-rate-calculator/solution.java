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
