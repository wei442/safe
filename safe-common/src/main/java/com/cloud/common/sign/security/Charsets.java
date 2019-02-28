package com.cloud.common.sign.security;

import java.nio.charset.Charset;

/**
 *
 * @ClassName: Charsets
 * @Description: 字符集工具
 * @author S.J.
 * @date 2016年7月18日 下午3:28:17
 *
 */
public class Charsets {

	/**
     * 字符集：ISO-8859-1
     */
    public static final String ISO_8859_1 = "ISO-8859-1";

    /**
     * 字符集：US-ASCII
     */
    public static final String US_ASCII = "US-ASCII";

    /**
     * 字符集：UTF-8
     */
    public static final String UTF_8 = "UTF-8";

    /**
     * 字符集：UTF-16
     */
    public static final String UTF_16 = "UTF-16";

    /**
     * 字符集：UTF-16BE
     */
    public static final String UTF_16BE = "UTF-16BE";

    /**
     * 字符集：UTF-16LE
     */
    public static final String UTF_16LE = "UTF-16LE";

    /**
     * 字符集：GBK
     */
    public static final String GBK = "GBK";
    /**
     * 字符集：GB2312
     */
    public static final String GB2312 = "GB2312";

    /**
     * @Title: toCharset
     * @Description: 获取字符集对象
     * @param charset
     * @return Charset
     */
    public static Charset toCharset(final String charset) {
        return charset == null ? Charset.defaultCharset() : Charset.forName(charset);
    }
}
