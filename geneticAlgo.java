import java.util.Random;
import java.util.Arrays;

// Use Genetic Algo to divide ten cards (numbered 1 to 10)
// into two equal piles
// under the following constraints:
// 1. The sum of the card values in the first pile is 36
// 2. The product of the cards in the second pile is 360
// I.E. 10 numbers that have to add to 36 and multiply to 360

// For GA we have three selectors:
//  1. Parents -> select candidates that will be used as parents
//      What is a parent? a guess to start with, like beam search
//      Kids with best scores get to be parents more often
//      Bad scores might still get picked so there is variety
//      So one parent is a full int[] guess -> [0, 1, 1, 1, 0, 0, 0, 0, 0, 1]
//      => Pile A -> 1, 5, 6, 7, 8
//      => Pile B -> 2, 3, 4, 9, 10

// 2. Crossover -> generate new child by combining contents of the two parents
//      Mix Two Rows
//      mom: A B B B A | A A A A B
//      dad: B A A B B | A B A A A
//      child: A B B B A | A B A A A

// 3. Mutation -> one small random change. Every so often flip one card to the
//      other pile.

// 4. Repeat until one row scores perfect.
//

public class geneticAlgo {

    static Random rand = new Random();

    static final int NUM_CARDS = 10;
    static final int SELECTION_SIZE = 3;

    // fill an int[10] with 5 0s and 5 1s randomly
    // i.e. make a guess as to what the answer is
    static int[] randomGuess() {
        int[] guess = new int[NUM_CARDS];

        // loop through a guess and fill it with 0s and 1s
        for (int i = 0; i < NUM_CARDS; i++) {
            // fill with the same number of 0s and 1s
            if (i < NUM_CARDS / 2) {
                guess[i] = 0;
            } else
                guess[i] = 1;
        }

        // swap places randomly
        for (int i = 0; i < NUM_CARDS; i++) {
            int j = rand.nextInt(NUM_CARDS);

            int temp = guess[i];
            guess[i] = guess[j];
            guess[j] = temp;
        }
        return guess;
    }

    // determine how fit a guess is
    // 0 is perfect
    // higher guess is further away
    static int fitness(int[] guess) {

        int pileAValue = 0;

        int pileBValue = 1;

        // get the value of pile A (the sum pile) and
        // pile B (the product pile)
        for (int i = 0; i < NUM_CARDS; i++) {
            if (guess[i] == 0) {
                pileAValue += i + 1;
            } else {
                pileBValue *= i + 1;
            }

        }

        // clean the results and return
        int fitnessA = Math.abs(36 - pileAValue);
        int fitnessB = Math.abs(360 - pileBValue);
        int fitness = fitnessA + fitnessB;
        return (fitness);
    }

    // create a tournament with three guesses
    // whichever guess has the lowest fitness wins
    static int[] selection(int[][] population) {
        // get the first guess
        int[] lowest = population[rand.nextInt(population.length)];

        // get two more guesses
        for (int i = 1; i < SELECTION_SIZE; i++) {
            int[] selection = population[rand.nextInt(population.length)];

            // find the lowest guess
            if (fitness(selection) < fitness(lowest)) {
                lowest = selection;
            }
        }

        return lowest;
    }

    static int[] crossover(int[] mom, int[] dad) {
        int rando = rand.nextInt(NUM_CARDS - 1) + 1;
        System.out.println("Cut point" + rando);
        int[] child = new int[NUM_CARDS];

        for (int i = 0; i < NUM_CARDS; i++) {
            if (i < rando) {
                child[i] = mom[i];
            } else
                child[i] = dad[i];
        }
        child = repair(child);
        return child;
    }

    // helper method that makes a child have exactly 5 0s and 5 1s
    static int[] repair(int[] child) {
        int count = 0;

        for (int i = 0; i < NUM_CARDS; i++) {
            if (child[i] == 0) {
                count++;
            }
        }

        while (count > NUM_CARDS / 2) {
            int rando = rand.nextInt(NUM_CARDS) + 1;
            if (child[rando] == 0) {
                child[rando] = 1;
                count--;
            }
        }

        while (count < NUM_CARDS / 2) {
            int rando = rand.nextInt(NUM_CARDS) + 1;
            if (child[rando] == 1) {
                child[rando] = 0;
                count++;
            }
        }
        return child;
    }

    // mutates a child by swapping a random 1 with a random 0.
    static int[] mutate(int[] child) {

        int zero;
        int one;

        do {
            zero = rand.nextInt(NUM_CARDS);
        } while (child[zero] != 0);

        do {
            one = rand.nextInt(NUM_CARDS);
        } while (child[one] != 1);

        int temp = child[zero];
        child[zero] = child[one];
        child[one] = temp;

        return child;
    }

    // int[][] population = [[1 4 7 8 10 1 3 4 5 6], [1 3 4 5 6 1 3 4 5 6],
    // [1 3 4 5 6 1 3 4 5 6], [1 3 4 5 6 1 3 4 5 6]]

    // Plan:
    // geneticSearch(population):
    // repeat for each generation:
    // 1. check: does any row have fitness 0? → if yes, done
    // 2. make a new, empty population
    // 3. fill it with children, one at a time:
    // mom = selection(population)
    // dad = selection(population)
    // child = crossover(mom, dad) ← repair happens inside
    // sometimes: child = mutate(child)
    // add child to the new population
    // 4. the new population replaces the old one
    // stop after a max number of generations if no perfect row was found

    static void geneticSearch(int[][] population) {
        for (int i = 0; i < NUM_CARDS; i++) {

        }

    }

    // String representation of a child
    static String toString(int[] child) {
        String pileA = "";
        int pileAValue = 0;

        String pileB = "";
        int pileBValue = 1;

        for (int i = 0; i < NUM_CARDS; i++) {
            if (child[i] == 0) {
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
        int POP_SIZE = 20;
        int[][] population = new int[POP_SIZE][];
        // Loop through the whole population and print each of their values and fitness
        for (int i = 0; i < POP_SIZE; i++) {
            population[i] = randomGuess();
            // System.out.println(toString(population[i]));
            // System.out.println("Fitness is: " + fitness(population[i]));
        }

        // Make a tournament with three guesses and get the lowest one
        // int[] select = selection(population);
        // System.out.println(toString(select));

        // System.out.println("Selected Fitness is: " + fitness(select));

        // Test the crossover function
        int[] mom = selection(population);
        int[] dad = selection(population);
        int[] child = crossover(mom, dad);
        System.out.println("Dad " + toString(dad));
        System.out.println("Mom " + toString(mom));
        System.out.println("Child " + toString(child));

    }
}
