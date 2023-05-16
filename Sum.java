import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class SumOfDivided {

    public static String sumOfDivided(int[] arr) {
        Map<Integer, Integer> factorSumMap = new HashMap<>();
        
        for (int num : arr) {
            List<Integer> primeFactors = getPrimeFactors(Math.abs(num));
            
            for (int factor : primeFactors) {
                factorSumMap.put(factor, factorSumMap.getOrDefault(factor, 0) + num);
            }
        }
        
        List<Integer> sortedFactors = new ArrayList<>(factorSumMap.keySet());
        Collections.sort(sortedFactors);
        
        StringBuilder result = new StringBuilder();
        
        for (int factor : sortedFactors) {
            result.append("(").append(factor).append(" ").append(factorSumMap.get(factor)).append(")");
        }
        
        return result.toString();
    }
    
    private static List<Integer> getPrimeFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0 && isPrime(i)) {
                factors.add(i);
            }
            
            while (num % i == 0) {
                num /= i;
            }
        }
        
        if (num > 1) {
            factors.add(num);
        }
        
        return factors;
    }
    
    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}

// test this thing

public class SumOfDividedTest {

    @Test
    public void testOne() {
        int[] lst = new int[] {12, 15};
        assertEquals("(2 12)(3 27)(5 15)", SumOfDivided.sumOfDivided(lst));
    }
}
