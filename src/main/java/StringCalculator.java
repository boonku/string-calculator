import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final String DEFAULT_DELIMITERS_IN_REGEX = "[,\n]";

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] nums = splitNumbers(numbers);
        return Arrays.stream(nums)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public String[] splitNumbers(String line) {
        Pattern pattern = Pattern.compile("//(.*)\n(.*)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            return matcher.group(2).split(delimiter);
        }
        return line.split(DEFAULT_DELIMITERS_IN_REGEX);
    }

}
