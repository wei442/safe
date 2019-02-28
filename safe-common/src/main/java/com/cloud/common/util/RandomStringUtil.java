package com.cloud.common.util;

import org.apache.commons.text.RandomStringGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: RandomStringUtil
 * @Description: 随机字符数字处理类
 * @author wei.yong
 * @date 2018-01-30
 */
public class RandomStringUtil {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	 /**
     * <p>Creates a random string whose length is the number of characters
     * specified.</p>
     *
     * <p>Characters will be chosen from the set of Latin alphabetic
     * characters (a-z, A-Z) and the digits 0-9.</p>
     *
     * @param count  the length of random string to create
     * @return the random string
     */
    public static String randomAlphanumeric(final int count) {
        char [][] pairs = {{'a','z'},{'A','Z'},{'0','9'}};
    		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange(pairs).build();
		String randomNumeric = generator.generate(count);
		return randomNumeric;
    }

    /**
     * <p>Creates a random string whose length is between the inclusive minimum and
     * the exclusive maximum.</p>
     *
     * <p>Characters will be chosen from the set of Latin alphabetic
     * characters (a-z, A-Z) and the digits 0-9.</p>
     *
     * @param minLengthInclusive the inclusive minimum length of the string to generate
     * @param maxLengthExclusive the exclusive maximum length of the string to generate
     * @return the random string
     */
    public static String randomAlphanumeric(final int minLengthInclusive, final int maxLengthExclusive) {
    	 	char [][] pairs = {{'a','z'},{'A','Z'},{'0','9'}};
 		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange(pairs).build();
		String randomNumeric = generator.generate(minLengthInclusive, maxLengthExclusive);
		return randomNumeric;
    }

    /**
     * <p>Creates a random string whose length is the number of characters
     * specified.</p>
     *
     * <p>Characters will be chosen from the set of Latin alphabetic
     * characters (a-z, A-Z).</p>
     *
     * @param count  the length of random string to create
     * @return the random string
     */
	public static String randomAlphabetic(final int count) {
		char [][] pairs = {{'a','z'},{'A','Z'}};
        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange(pairs).build();
		String randomNumeric = generator.generate(count);
		return randomNumeric;
    }

	/**
     * <p>Creates a random string whose length is between the inclusive minimum and
     * the exclusive maximum.</p>
     *
     * <p>Characters will be chosen from the set of Latin alphabetic characters (a-z, A-Z).</p>
     *
     * @param minLengthInclusive the inclusive minimum length of the string to generate
     * @param maxLengthExclusive the exclusive maximum length of the string to generate
     * @return the random string
     */
    public static String randomAlphabetic(final int minLengthInclusive, final int maxLengthExclusive) {
        char [][] pairs = {{'a','z'},{'A','Z'}};
        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange(pairs).build();
		String randomNumeric = generator.generate(minLengthInclusive, maxLengthExclusive);
		return randomNumeric;
    }

	/**
     * <p>Creates a random string whose length is the number of characters
     * specified.</p>
     *
     * <p>Characters will be chosen from the set of numeric
     * characters.</p>
     *
     * @param count  the length of random string to create
     * @return the random string
     */
	public static String randomNumeric(final int count) {
		char [][] pairs = {{'0','9'}};
		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange(pairs).build();
		String randomNumeric = generator.generate(count);
		return randomNumeric;
	}

	/**
     * <p>Creates a random string whose length is between the inclusive minimum and
     * the exclusive maximum.</p>
     *
     * <p>Characters will be chosen from the set of \p{Digit} characters.</p>
     *
     * @param minLengthInclusive the inclusive minimum length of the string to generate
     * @param maxLengthExclusive the exclusive maximum length of the string to generate
     * @return the random string
     */
    public static String randomNumeric(final int minLengthInclusive, final int maxLengthExclusive) {
        char [][] pairs = {{'0','9'}};
		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange(pairs).build();
		String randomNumeric = generator.generate(minLengthInclusive, maxLengthExclusive);
		return randomNumeric;
    }


}