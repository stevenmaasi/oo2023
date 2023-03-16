public class Main {
    public static void main(String[] args) {
        // Tee lihtne liitmistehe
        sum(5, 10);
        sum(8, 12);

        // Tee kindlaks kas arv on paaris või paaritu
        evenOrOdd(5);
        evenOrOdd(12);

        // Leia suurim arv
        int [] array = {1, 2, 4, 102, 54, 3};
        int max = findMax(array);
        System.out.println("Massiivi suurim arv on: " + max);

        // Teisenda Celsius Farenheitiks
        int C = 25;
        double F = celsiusToFahrenheit(C);
        System.out.println(C + "C on võrdne " + F + "F");

        // Leia ringi pindala
        double circleArea = calculateCircleArea(6);
        System.out.println(circleArea);

        // Leia miinimum ja maximum korraga
        int[] minMaxArray = findMinMax(array);
        System.out.println("Massiivi väiksem arv on " + minMaxArray[0] + " ja massiivi suurim arv on " + minMaxArray[1]);
    }

    private static void sum(int a, int b) {
        int sum = a + b;
        System.out.println(a + " + " + b + " = " + sum);
    }

    private static void evenOrOdd(int num) {
        if (num % 2 == 0) {
            System.out.println(num + " on paarisarv.");
        } else {
            System.out.println(num + " on paaritu arv");
        }
    }

    private static int findMax(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    private static int[] findMinMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return new int[]{min, max};
    }
}