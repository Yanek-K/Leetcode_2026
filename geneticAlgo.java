import java.util.Random;
import java.util.Arrays;

// Use Genetic Algo to divide ten cards (numbered 1 to 10)
// into two equal piles
// under the following constraints:
// 1. The sum of the card values in the first pile is 36
// 2. The product of the cards in the second pile is 360
// So basically 10 numbers that have to add to 36 and multiply to 360
// What i would do is start taking random guesses so for example 9 + 8 + 7 + 6 +
// 5 + 1 = 36. -- 2 * 3 * 4 * 10 = 240
//
// Close. Try again.
// HOW CLOSE MEANS FITNESS
//
// For GA we have three selectors:
// 1. Parents -> select candidates that will be used as parents
// What is a parent? a guess to start with, like beam search
// Kids with best scores get to be parents more often
// Bad scores might still get picked so there is variety
// So one parent is a full int[] guess -> [0, 1, 1, 1, 0, 0, 0, 0, 0, 1]
// => Pile A -> 1, 5, 6, 7, 8, 9
// => Pile B -> 2, 3, 4, 10
//
// 2. Crossover -> generate new child by combining contents of the two parents
// Mix Two Rows
// mom: A B B B A | A A A A B
// dad: B A A B B | A B A A A
// child: A B B B A | A B A A A
// 3. Mutation -> one small random change. Every so often flip one card to the
// other pile.
//
// 4. Repeat until one row scores perfect.

public class geneticAlgo {

    static Random rand = new Random();

    static final int NUM_CARDS = 10;

    static void geneticSearch(int[][] guesses) {

    }

    static int[] randomGuess() {
        int[] guess = new int[NUM_CARDS];
        for (int i = 0; i < NUM_CARDS; i++) {
            guess[i] = rand.nextInt(2);
        }
        return guess;
    }

    static int fitness(int[] guess) {

        int pileAValue = 0;

        int pileBValue = 1;

        for (int i = 0; i < NUM_CARDS; i++) {
            if (guess[i] == 0) {
                pileAValue += i + 1;
            } else {
                pileBValue *= i + 1;
            }

        }
        // E.g
        // 36 - 30 = 6
        int fitnessA = Math.abs(36 - pileAValue);
        // 360 - 300 = 60
        int fitnessB = Math.abs(360 - pileBValue);
        // 60 + 6 = 66, 0 is correct
        int fitness = fitnessA + fitnessB;
        return (fitness);
    }

    static String toString(int[] guess) {
        String pileA = "";
        int pileAValue = 0;

        String pileB = "";
        int pileBValue = 1;

        for (int i = 0; i < NUM_CARDS; i++) {
            if (guess[i] == 0) {
                pileA += i + 1 + " ";
                pileAValue += i + 1;
            } else {
                pileB += i + 1 + " ";
                pileBValue *= i + 1;
            }

        }
        String result = "Pile A: " + pileA + "= " + pileAValue + " Pile B: " + pileB + "= " + pileBValue;
        return result;
    }

    public static void main(String[] args) {
        //
        int[] parentA = randomGuess();
        int[] parentB = randomGuess();

        System.out.println(Arrays.toString(parentA));
        System.out.println(Arrays.toString(parentB));

        System.out.println(toString(parentA));

    }

}
