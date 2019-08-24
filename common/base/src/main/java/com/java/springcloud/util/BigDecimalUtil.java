package com.java.springcloud.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * BigDecimalUtil
 *
 * @author TONE
 * @date 2019/8/9
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BigDecimalUtil {
    /**
     * Add big decimal.
     *
     * @param v1 the v 1
     * @param v2 the v 2
     *
     * @return the big decimal
     */
    public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
        return v1.add(v2);
    }

    /**
     * Sub big decimal.
     *
     * @param v1 the v 1
     * @param v2 the v 2
     *
     * @return the big decimal
     */
    public static BigDecimal sub(BigDecimal v1, BigDecimal v2) {
        return v1.subtract(v2);
    }


    /**
     * Mul big decimal.
     *
     * @param v1 the v 1
     * @param v2 the v 2
     *
     * @return the big decimal
     */
    public static BigDecimal mul(BigDecimal v1, BigDecimal v2) {
        return v1.multiply(v2);
    }

    /**
     * Div big decimal.
     *
     * @param v1 the v 1
     * @param v2 the v 2
     *
     * @return the big decimal
     */
    public static BigDecimal div(BigDecimal v1, BigDecimal v2) {
        return v1.divide(v2, 2, BigDecimal.ROUND_HALF_UP);
    }

}
