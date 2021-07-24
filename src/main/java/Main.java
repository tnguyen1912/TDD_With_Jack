import java.util.Comparator;

/**
 * Given arr of numbers
 * sort them - lowest to highest
 * stored as a string
 * elements has to remain as strings while sorting
 *
 * ["1","5","9"] - result
 * ["9","5","1"] - given
 * ["5","1","9"]
 */

/**
 * compareTo
 * 1 - if greater than
 * 0 - if equal
 * -1 - if less than
 */

public class Main{

    public String[] sortArr(String[] input) {
        boolean sorted = false;
        while(sorted == false){
            sorted = true;
            for (int i = 0; i < input.length-1; i++) {
                String current = input[i];
                String next = input[i+1];

//                if(current.length() > next.length()){
//                    String temp = input[i];
//                    input[i] = input[i+1];
//                    input[i+1] = temp;
//                    sorted = false;
//                } else if((current.length() == next.length()) &&
//                        (current.compareTo(next) > 0)){
//                    String temp = input[i];
//                    input[i] = input[i+1];
//                    input[i+1] = temp;
//                    sorted = false;
//                }

                if(currentIsGreaterThanNext(current,next)){
                    String temp = input[i];
                    input[i] = input[i+1];
                    input[i+1] = temp;
                    sorted = false;
                }

            }
        }
        return input;
    }

    public Boolean currentIsGreaterThanNext(String current,String next){

        //call method to remove leading zero
        /**
         * while current first char is zero - remove it
         */
        if(current.length() > next.length()){
            return true;
        }
        if(current.length() < next.length()){
            return false;
        }
        if(current.compareTo(next) > 0){
            return true;
        }
        return false;
    }


}
