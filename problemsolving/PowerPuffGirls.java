package problemsolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PowerPuffGirls {

    private static final String SPACE = " ";
    private static final Integer INITAL_IDX = 0;
    private static final Integer LOWER_IDX = 1;
    private static final Integer SECOND_IDX = 2;
    private static final Integer MAX_LINES = 3;
    private static final Integer UPPER_IDX = 10000000;
    private static String[] UnitsArr = null;
    private static String[] totIngrdientsArr = null;
    private static int size = 0;

    public static void main(String[] args) {
        List<Integer> maxPowerPuffGirlsCreationList = new ArrayList<Integer>();
    Scanner stdin = new Scanner(System.in);
    String[] input = new String[MAX_LINES];
        try {
        for (int i = 0; i < input.length; i++) {
            input[i] = stdin.nextLine();
            System.out.println(input[i]);
            if (validateIngredienInput(input[INITAL_IDX])) {
                System.exit(INITAL_IDX);
            }
        }
    } finally {
        stdin.close();

    }
    int numOfIngredients = Integer.parseInt(input[INITAL_IDX]);
    String units = input[LOWER_IDX];
    UnitsArr = units.split(SPACE);
    String ingredients = input[SECOND_IDX];
    totIngrdientsArr = ingredients.split(SPACE);

    size = UnitsArr.length;
    int[] specifiedArrayOfUnits = convertToIntegerArray(UnitsArr);
    int[] totIngredientInLabArray = convertToIntegerArray(totIngrdientsArr);
        for (int i = 0; i < size; i++) {
        totIngredientInLabArray[i] = Integer.parseInt(totIngrdientsArr[i]);
    }

        for (int i = 0; i < numOfIngredients; i++) {
        maxPowerPuffGirlsCreationList.add(totIngredientInLabArray[i] / specifiedArrayOfUnits[i]);
    }
        System.out.println(Collections.min(maxPowerPuffGirlsCreationList));

}
    private static boolean validateIngredienInput(String noOfIngredients) {
        int numOfIngredients = Integer.parseInt(noOfIngredients);
        boolean result = false;
        if (numOfIngredients <= LOWER_IDX && numOfIngredients <= Long.MAX_VALUE) {
            result = true;
            return result;
        }
        return result;
    }

    private static int[] convertToIntegerArray(String[] arrayToBeParsed) {
        int array[] = new int[size];
        for (int i = INITAL_IDX; i < size; i++) {
            array[i] = Integer.parseInt(arrayToBeParsed[i]);
        }
        return array;
    }
}