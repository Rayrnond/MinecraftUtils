package com.reflexian.minecraftutils.math;

import lombok.experimental.UtilityClass;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

@UtilityClass
public class MathUtil {


    private static final NavigableMap<Long, String> suffixes = new TreeMap<>();
    static {
        suffixes.put(1_000L, "k");
        suffixes.put(1_000_000L, "M");
        suffixes.put(1_000_000_000L, "B");
        suffixes.put(1_000_000_000_000L, "T");
        suffixes.put(1_000_000_000_000_000L, "Q");
        suffixes.put(1_000_000_000_000_000_000L, "E");
    }

    public static String formatNumber(long value) {
        if (value == Long.MIN_VALUE) return formatNumber(Long.MIN_VALUE + 1);
        if (value < 0) return "-" + formatNumber(-value);
        if (value < 1000) return Long.toString(value);

        Map.Entry<Long, String> e = suffixes.floorEntry(value);
        Long divideBy = e.getKey();
        String suffix = e.getValue();

        long truncated = value / (divideBy / 10);
        boolean hasDecimal = truncated < 100 && (truncated / 10d) != (truncated / 10);
        return hasDecimal ? (truncated / 10d) + suffix : (truncated / 10) + suffix;
    }
    public static String formatDurationToString(Long duration) {
        TimeUnit u = TimeUnit.MILLISECONDS;
        long days = u.toDays(duration) % 24;
        long hours = u.toHours(duration) % 24;
        long minutes = u.toMinutes(duration) % 60;
        long seconds = u.toSeconds(duration) % 60;
        return String.format("%02d:%02d:%02d:%02d",days, hours, minutes, seconds);
    }

    public static String formatOffsetDateTime(OffsetDateTime time) {
        return DateTimeFormatter.ofPattern("M/d/u h:m:s a").format(time);
    }

    /**
     * Returns the "Nice" variant of formatDurationToString
     *
     * Before: 01:12:18:39
     * After: 1d 12h 18m 39s
     */
    public static String formatDurationToNiceString(Long duration) {
        TimeUnit u = TimeUnit.MILLISECONDS;
        long days = u.toDays(duration);
        long hours = u.toHours(duration) % 24;
        long minutes = u.toMinutes(duration) % 60;
        long seconds = u.toSeconds(duration) % 60;

        if (days==0&&hours==0&&minutes==0&&seconds==0) {
            return "0m 0s";
        }

        if (days > 0) {
            return days + "d " + hours + "h " + minutes + "m " + seconds + "s";
        }else if (hours > 0) {
            return hours + "h " + minutes + "m " + seconds + "s";
        } else {
            return minutes + "m " + seconds + "s";
        }
    }



    public static String toRoman(long Int) {
        LinkedHashMap<String, Long> roman_numerals = new LinkedHashMap<String, Long>();
        roman_numerals.put("M", 1000L);
        roman_numerals.put("CM", 900L);
        roman_numerals.put("D", 500L);
        roman_numerals.put("CD", 400L);
        roman_numerals.put("C", 100L);
        roman_numerals.put("XC", 90L);
        roman_numerals.put("L", 50L);
        roman_numerals.put("XL", 40L);
        roman_numerals.put("X", 10L);
        roman_numerals.put("IX", 9L);
        roman_numerals.put("V", 5L);
        roman_numerals.put("IV", 4L);
        roman_numerals.put("I", 1L);
        StringBuilder res = new StringBuilder();
        for(Map.Entry<String, Long> entry : roman_numerals.entrySet()){
            long matches = Int/entry.getValue();
            res.append(repeat(entry.getKey(), matches));
            Int = Int % entry.getValue();
        }
        return res.toString();
    }

    public static String repeat(String s, long n) {
        if(s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static int randomNumber(int min, int max) {
        if (max>min) {
            throw new NumberFormatException("Max number is larger than min number");
        }
        return new Random().nextInt(max)+1+min;
    }

}
