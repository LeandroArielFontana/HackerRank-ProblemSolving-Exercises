package LuckyNumbers;

import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {
    public static boolean isPrime(Integer number) {
        if (number <= 1) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }

        return true;
    }

    public static long luckyNumbers(long a, long b) {
        int countLuckyNumber = 0;
        int digitNumber;
        int digitSumatory = 0;
        int sqareDigitSumatory = 0;


        for (long i = a; i <= b; i++) {
            String numberAsString = String.valueOf(i);
            for (int j = 0; j < numberAsString.length(); j++) {
                digitNumber = Character.getNumericValue(numberAsString.charAt(j));
                digitSumatory += digitNumber;
                sqareDigitSumatory += (int)Math.pow(digitNumber, 2);
            }

            if (isPrime(sqareDigitSumatory) && isPrime(digitSumatory)) countLuckyNumber++;
            digitSumatory = 0;
            sqareDigitSumatory = 0;
        }
        return countLuckyNumber;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                long a = Long.parseLong(firstMultipleInput[0]);
                long b = Long.parseLong(firstMultipleInput[1]);
                long result = Result.luckyNumbers(a, b);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

