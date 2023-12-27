import java.util.ArrayList;

public class StockCalculator {
    public static void main(String[] argv) {
        //I interpreted the question provided to mean we are given float type data (there were conflicting instructions),
        // as stock prices are likely to be given in decimal format.
        float[] stockPricesArray = {10.5f, 11.2f, 12.8f, 10.0f, 13.5f, 14.2f, 12.0f, 11.8f, 13.0f, 12.5f};
        ArrayList<Float> stockPricesList = new ArrayList<>();

        for (Float price : stockPricesArray) {
            stockPricesList.add(price);
        }
        // print out the results to check if they work correctly, we just want the actual values returned in each method
        // and not any printed lines
        float averagePrice = calculateAveragePrice(stockPricesArray);
        System.out.println("Average Stock Price: " + averagePrice);

        float maximumPrice = findMaximumPrice(stockPricesArray);
        System.out.println("Maximum Stock Price: " + maximumPrice);

        float targetPrice = 12.0f;
        int occurrenceCount = countOccurrences(stockPricesArray, targetPrice);
        System.out.println("Occurrences of " + targetPrice + ": " + occurrenceCount);

        ArrayList<Float> cumulativeSumList = computeCumulativeSum(stockPricesList);
        System.out.println("Cumulative Sum of Stock Prices: " + cumulativeSumList);
    }


    public static float calculateAveragePrice(float[] stockPricesArray) {
        float sum = 0;

        //add all items in list
        for (float item : stockPricesArray) {
            sum += item;
        }

        //divide sum by the number of items in list
        return sum / stockPricesArray.length;

    }

    public static float findMaximumPrice(float[] stockPricesArray) {
        float max = 0;

        //iteratively compare each item to see if it is bigger than the last item. If yes, reassign variable
        for (float item : stockPricesArray) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }

    public static int countOccurrences(float[] stockPricesArray, float targetNumber) {
        int counter = 0;

        //iteratively go through each item and compare to target value. If they are the same, add to counter
        for (float stock : stockPricesArray) {
            if (stock == targetNumber) {
                counter++;
            }
        }
        return counter;
    }
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> stockPricesList) {
        float accumulation = 0;
        ArrayList<Float> cumulativeSumList = new ArrayList<>();

        //iterate through each value and add it to all the previously added values
        for (Float stock : stockPricesList) {
            accumulation+=stock;
            cumulativeSumList.add(accumulation);
        }
        return cumulativeSumList;
    }
}


