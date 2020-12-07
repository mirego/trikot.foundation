package com.mirego.trikot.foundation

/**
 * Represents a group of four (4) values
 *
 * There is no meaning attached to values in this class, it can be used for any purpose.
 * Quadruple exhibits value semantics, i.e. two quadruples are equal if all four components are
 * equal.
 *
 * @param A type of the first value.
 * @param B type of the second value.
 * @param C type of the third value.
 * @param D type of the third value.
 * @property first First value.
 * @property second Second value.
 * @property third Third value.
 * @property fourth Fourth value.
 */
data class Quadruple<out A, out B, out C, out D>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D
) {
    /**
     * Returns string representation of the [Triple] including its [first], [second], [third] and
     * [fourth] values.
     */
    override fun toString(): String = "($first, $second, $third, $fourth)"
}

/**
 * Represents a group of five (5) values
 *
 * There is no meaning attached to values in this class, it can be used for any purpose.
 * Quintuple exhibits value semantics, i.e. two quintuples are equal if all five components are
 * equal.
 *
 * @param A type of the first value.
 * @param B type of the second value.
 * @param C type of the third value.
 * @param D type of the fourth value.
 * @param E type of the fifth value.
 * @property first First value.
 * @property second Second value.
 * @property third Third value.
 * @property fourth Fourth value.
 * @property fifth Fifth value.
 */
data class Quintuple<out A, out B, out C, out D, out E>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E
) {
    /**
     * Returns string representation of the [Triple] including its [first], [second], [third],
     * [fourth] and [fifth] values.
     */
    override fun toString(): String = "($first, $second, $third, $fourth, $fifth)"
}

/**
 * Represents a group of six (6) values
 *
 * There is no meaning attached to values in this class, it can be used for any purpose.
 * Sextuple exhibits value semantics, i.e. two sextuples are equal if all six components are
 * equal.
 *
 * @param A type of the first value.
 * @param B type of the second value.
 * @param C type of the third value.
 * @param D type of the fourth value.
 * @param E type of the fifth value.
 * @param F type of the sixth value.
 * @property first First value.
 * @property second Second value.
 * @property third Third value.
 * @property fourth Fourth value.
 * @property fifth Fifth value.
 * @property sixth Sixth value.
 */
data class Sextuple<out A, out B, out C, out D, out E, out F>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E,
    val sixth: F
) {
    /**
     * Returns string representation of the [Triple] including its [first], [second], [third],
     * [fourth], [fifth] and [sixth] values.
     */
    override fun toString(): String = "($first, $second, $third, $fourth, $fifth, $sixth)"
}

/**
 * Represents a group of seven (7) values
 *
 * There is no meaning attached to values in this class, it can be used for any purpose.
 * Septuple exhibits value semantics, i.e. two septuples are equal if all seven components are
 * equal.
 *
 * @param A type of the first value.
 * @param B type of the second value.
 * @param C type of the third value.
 * @param D type of the fourth value.
 * @param E type of the fifth value.
 * @param F type of the sixth value.
 * @param G type of the seventh value.
 * @property first First value.
 * @property second Second value.
 * @property third Third value.
 * @property fourth Fourth value.
 * @property fifth Fifth value.
 * @property sixth Sixth value.
 * @property seventh Seventh value.
 */
data class Septuple<out A, out B, out C, out D, out E, out F, out G>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E,
    val sixth: F,
    val seventh: G
) {
    /**
     * Returns string representation of the [Triple] including its [first], [second], [third],
     * [fourth], [fifth], [sixth], and [seventh] values.
     */
    override fun toString(): String = "($first, $second, $third, $fourth, $fifth, $sixth, $seventh)"
}
