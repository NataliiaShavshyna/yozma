package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.security.SecureRandom;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * The type String generator.
 */
public class StringGenerator {

    private static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String NUMERIC = "123456789";
    private static final String SPECIAL_CHARS = "~!@#$%^&*() ";
    private static final String ALPHA_NUMERIC = AB + NUMERIC;
    private static final String ALPHA_NUMERIC_WITH_SPACE = " " + ALPHA_NUMERIC;
    private static final String ALPHA_NUMERIC_WITH_SPECIAL_CHARS = ALPHA_NUMERIC + SPECIAL_CHARS;
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    /**
     * Random alpha string.
     *
     * @param len the len
     * @return the string
     */
    public static String randomAlpha(final int len) {
        return randomize(AB, len);
    }

    /**
     * Random email string.
     *
     * @return the string
     */
    public static String randomEmail() {
        return (randomize(AB, 10) + "@test.com");
    }

    /**
     * Random alpha numeric string.
     *
     * @param len the len
     * @return the string
     */
    public static String randomAlphaNumeric(int len) {
        return randomize(ALPHA_NUMERIC, len);
    }

    /**
     * Random alpha numeric with spaces string.
     *
     * @param len the len
     * @return the string
     */
    public static String randomAlphaNumericWithSpaces(int len) {
        String str = randomize(ALPHA_NUMERIC_WITH_SPACE, len).trim();
        // during the trim we might lose the desired length, so we need to verify that and append if needed
        return str.length() < len ? str + randomAlpha(len - str.length()) : str;
    }

    /**
     * Random alpha numeric with special chars string.
     *
     * @param len the len
     * @return the string
     */
    public static String randomAlphaNumericWithSpecialChars(int len) {
        return randomize(ALPHA_NUMERIC_WITH_SPECIAL_CHARS, len).trim();
    }

    /**
     * Random numeric string.
     *
     * @param len the len
     * @return the string
     */
    public static String randomNumeric(int len) {
        return randomize(NUMERIC, len);
    }

    private static String randomize(String charCollection, int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(charCollection.charAt(SECURE_RANDOM.nextInt(charCollection.length())));
        }
        return sb.toString();
    }

    /**
     * Random uuid string.
     *
     * @return the string
     */
    public static String randomUuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * Random uuid string.
     *
     * @param length     the length
     * @param spacing    the spacing
     * @param spacerChar the spacer char
     * @return the string
     */
    public static String randomUuid(int length, int spacing, char spacerChar) {
        StringBuilder sb = new StringBuilder();
        int spacer = 0;
        while (length > 0) {
            if (spacer == spacing) {
                sb.append(spacerChar);
                spacer = 0;
            }
            length--;
            spacer++;
            sb.append(randomChar());
        }
        return sb.toString();
    }

    private static char randomChar() {
        return AB.charAt(SECURE_RANDOM.nextInt(AB.length()));
    }


    /**
     * Generate string.
     *
     * @return the string
     */
    public String generate() {
        return randomString(8L, 8L);
    }


    /**
     * Generate string.
     *
     * @param min the min
     * @param max the max
     * @return the string
     */
    public String generate(Long min, Long max) {
        return randomString(min, max);
    }

    private String randomString(long minLen, long maxLen) {
        long len = minLen == maxLen ? maxLen : ThreadLocalRandom.current().nextLong(minLen, maxLen);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(SECURE_RANDOM.nextInt(AB.length())));
        }
        return sb.toString();
    }

    public static List<String> performanceLogMessages(WebDriver webDriver) {

        LogEntries logEntries = webDriver.manage().logs().get(LogType.PERFORMANCE);

        // Filter POST requests
        List<String> postRequests = logEntries.getAll().stream()
                .filter(logEntry -> logEntry.getMessage()
                        .contains("\"method\":\"POST\"") &&
                        logEntry.getMessage().contains("billing_address"))
                .map(LogEntry::getMessage)
                .collect(Collectors.toList());

        // Print or process the filtered POST requests
        postRequests.forEach(System.out::println);
        return postRequests;
    }

}
