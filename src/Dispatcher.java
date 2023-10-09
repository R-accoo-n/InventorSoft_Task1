public class Dispatcher {
        public static void main(String[] args) {
            int[] arr1 = {1, 3};
            int[] arr2 = {1, 5, 10, 10};
            int[] arr3 = {1, 6, 15, 20};
            int[] arr4 = {1, 6, 15, 20, 15, 6, 1};

            System.out.println(arrayChallenge(arr1)); // Output: 3
            System.out.println(arrayChallenge(arr2)); // Output: 5
            System.out.println(arrayChallenge(arr3)); // Output: 15
            System.out.println(arrayChallenge(arr4)); // Output: -1
        }

        public static int arrayChallenge(int[] arr) {

            // Check if the input array is a complete row
            if (arr[0] == 1 && arr[arr.length - 1] == 1) {
                return -1;
            }

            // Length of full row from Pascal's triangle
            int n = arr[1] + 1;

            // Calculate the next number in the row based on the previous row
            int nextNumber = 1;
            for (int i = 1; i < arr.length; i++) {
                nextNumber = nextNumber * (n - i) / (i);

                //Return -1 if the row is not from the Pascal's triangle
                if (nextNumber != arr[i]) {
                    return -1;
                }
            }

            //If row that is not from the Pascal's triangle can not been entered,
            //we can complete this task in 4 lines:
            /*
             if (arr[0] == 1 && arr[arr.length - 1] == 1) {
                return -1;
             }else {
                return arr[arr.length - 1] * (arr[1] + 1 - arr.length) / arr.length;
             }
             */

            return nextNumber * (n - arr.length) / arr.length; // If the input is not a valid partial row
        }

}
