package com.mirego.trikot.foundation

import kotlin.test.Test
import kotlin.test.assertEquals

class TuplesTest {
    @Test
    fun testQuadruple() {
        val quadruple = Quadruple("1", "2", "3", 4)

        quadruple.let { (a, b, c, d) ->
            assertEquals("1", a)
            assertEquals("2", b)
            assertEquals("3", c)
            assertEquals(4, d)
        }

        val (a, b, c, d) = quadruple

        assertEquals("($a, $b, $c, $d)", quadruple.toString())
    }

    @Test
    fun testQuintuple() {
        val quintuple = Quintuple("1", "2", "3", "4", 5)

        quintuple.let { (a, b, c, d, e) ->
            assertEquals("1", a)
            assertEquals("2", b)
            assertEquals("3", c)
            assertEquals("4", d)
            assertEquals(5, e)
        }

        val (a, b, c, d, e) = quintuple

        assertEquals("($a, $b, $c, $d, $e)", quintuple.toString())
    }

    @Test
    fun testSextuple() {
        val sextuple = Sextuple("1", "2", "3", "4", "5", 6)

        sextuple.let { (a, b, c, d, e, f) ->
            assertEquals("1", a)
            assertEquals("2", b)
            assertEquals("3", c)
            assertEquals("4", d)
            assertEquals("5", e)
            assertEquals(6, f)
        }

        val (a, b, c, d, e, f) = sextuple

        assertEquals("($a, $b, $c, $d, $e, $f)", sextuple.toString())
    }

    @Test
    fun testSeptuple() {
        val septuple = Septuple("1", "2", "3", "4", "5", "6", 7)

        septuple.let { (a, b, c, d, e, f, g) ->
            assertEquals("1", a)
            assertEquals("2", b)
            assertEquals("3", c)
            assertEquals("4", d)
            assertEquals("5", e)
            assertEquals("6", f)
            assertEquals(7, g)
        }

        val (a, b, c, d, e, f, g) = septuple

        assertEquals("($a, $b, $c, $d, $e, $f, $g)", septuple.toString())
    }
}
