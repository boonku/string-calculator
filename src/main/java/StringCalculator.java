import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final String DEFAULT_DELIMITERS_IN_REGEX = "[,\n]";

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] nums = splitNumbers(numbers);
        checkForNegatives(nums);
        return Arrays.stream(nums)
                .mapToInt(Integer::parseInt)
                .filter(number -> number <= 1000)
                .sum();
    }

    private String[] splitNumbers(String line) {
        Pattern pattern = Pattern.compile("//(.*)\n(.*)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            return matcher.group(2).split(delimiter);
        }
        return line.split(DEFAULT_DELIMITERS_IN_REGEX);
    }

    private void checkForNegatives(String[] numbers) {
        List<Integer> negatives = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .filter(number -> number < 0)
                .toList();
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed " + negatives);
        }
    }

}
