import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * This program generates Magic Squares using recursion.
 *
 * @author  Marlon Poddalgoda
 * @version 1.0
 * @since 2021-05-12
 */

public final class MagicSquare {
    private MagicSquare() {

        // Throw an exception if this ever *is* called
        throw new AssertionError("Instantiating utility class.");
    }

    /**
    * This method generates the arrays and passes them to the genSquare func.
    * @param args
    */
    public static void main(final String[] args) {
        // main stub, get user input here

        // constants
        final int two = 2;
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        final int seven = 7;
        final int eight = 8;
        final int nine = 9;

        Integer[] magicSquare = {1, two, three, four, five, six,
                                 seven, eight, nine};
        int[] indexArr = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println("\n");
        System.out.println("All Possible Magic Squares (3x3):\n");
        genSquare(magicSquare, indexArr, 1);
    }

    /**
    * This method generates possible magic squares using shuffle().
    * @param square This value is the magic square array.
    * @param indexArray This value is the index array.
    * @param index This value is the index
    */
    public static void genSquare(final Integer[] square, final int[] indexArray,
                                 final int index) {
        // generates magic square code goes here

        // for loop, goes through magic square generation
        for (int counter = 0; counter < square.length; counter++) {
            // counter
            if (indexArray[counter] == 0) {
                // converting array to list
                List<Integer> intSquare = Arrays.asList(square);

                // shuffling list randomly using .shuffle()
                // this generates possible magic squares
                Collections.shuffle(intSquare);

                // converting list back to array
                intSquare.toArray(square);

                indexArray[counter] = 1;

                // if statement, calls recursive function
                if (index < square.length) {
                    // recursive call
                    genSquare(square, indexArray, index + 1);
                } else {
                    // check possible squares
                    boolean check = isMagic(square);
                    if (check == true) {
                        // print call
                        printMagicSquare(square);
                    }
                }
                // reset index counter
                indexArray[counter] = 0;
            }
        }
    }

    /**
    * This method checks if the inputted array is a magic square.
    * @param potSquare This value is the magic square array.
    * @return This returns a true or false.
    */
    public static boolean isMagic(final Integer[] potSquare) {
        // returns true or false for whether or not array is a magic square
        final int magicNum = 15;

        // constants
        final int two = 2;
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        final int seven = 7;
        final int eight = 8;
        final int nine = 9;

        int row1 = potSquare[0] + potSquare[1] + potSquare[two];
        int row2 = potSquare[three] + potSquare[four] + potSquare[five];
        int row3 = potSquare[six] + potSquare[seven] + potSquare[eight];
        int col1 = potSquare[0] + potSquare[three] + potSquare[six];
        int col2 = potSquare[1] + potSquare[four] + potSquare[seven];
        int col3 = potSquare[two] + potSquare[five] + potSquare[eight];
        int diag1 = potSquare[0] + potSquare[four] + potSquare[eight];
        int diag2 = potSquare[two] + potSquare[four] + potSquare[six];

        if (row1 == magicNum && row2 == magicNum && row3 == magicNum
                && col1 == magicNum && col2 == magicNum && col3 == magicNum
                && diag1 == magicNum && diag2 == magicNum) {
            return true;
        } else {
            return false;
        }
    }

    /**
    * This method prints the magic squares.
    * @param outputSquare This value is the magic square array.
    */
    public static void printMagicSquare(final Integer[] outputSquare) {
        // prints inputted array in a magic square format

        // constant
        final int fifty = 50;
        final int three = 3;
        final int six = 6;

        System.out.println("\n****");
        int size = outputSquare.length;

        for (int count = 0; count < size; count++) {
            if (count == three || count == six) {
                System.out.println();
                System.out.print(outputSquare[count] + " ");
            } else {
                System.out.print(outputSquare[count] + " ");
            }
            wait(fifty);
        }
        System.out.println("\n*****");
    }

    /**
    * This method is a timer.
    * @param ms This value is the milliseconds?.
    */
    public static void wait(final int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
