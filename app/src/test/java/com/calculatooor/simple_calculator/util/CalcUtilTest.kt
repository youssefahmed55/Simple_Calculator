package com.calculatooor.simple_calculator.util


import org.junit.Assert.*
import org.junit.Test

class CalcUtilTest {
    @Test
    fun `Equation is Empty returns RuntimeException`() {
        //Given empty equation
        val equation = ""

        //When get The result of the equation
        val exception = assertThrows(RuntimeException::class.java) {
            CalcUtil.eval(equation)
        }

        //Then
        assertEquals("Unexpected: \uFFFF", exception.message)

    }

    @Test
    fun `Equation is Only Numbers returns The Same Numbers`() {
        //Given
        val equation = "55144"

        //When get The result of the equation
        val result  =  CalcUtil.eval(equation)

        //Then
        assertEquals("55144.0",result.toString())
    }

    @Test
    fun `Equation is Only One Sign (+) returns RuntimeException`() {
        //Given Only One Sign (+)
        val equation = "+"

        //When get The result of the equation
        val exception = assertThrows(RuntimeException::class.java) {
            CalcUtil.eval(equation)
        }

        //Then
        assertEquals("Unexpected: \uFFFF", exception.message)
    }

    @Test
    fun `Equation is Only One Sign (-) returns RuntimeException`() {
        //Given Only One Sign (-)
        val equation = "-"

        //When get The result of the equation
        val exception = assertThrows(RuntimeException::class.java) {
            CalcUtil.eval(equation)
        }

        //Then
        assertEquals("Unexpected: \uFFFF", exception.message)
    }

    @Test
    fun `Equation is Only One Sign (x) returns RuntimeException`() {
        //Given Only One Sign (×)
        val equation = "×"

        //When get The result of the equation
        val exception = assertThrows(RuntimeException::class.java) {
            CalcUtil.eval(equation)
        }

        //Then
        assertEquals("Unexpected: ×", exception.message)
    }

    @Test
    fun `Equation is Only One Division Sign returns RuntimeException`() {
        //Given Only One Sign (÷)
        val equation = "÷"

        //When get The result of the equation
        val exception = assertThrows(RuntimeException::class.java) {
            CalcUtil.eval(equation)
        }

        //Then
        assertEquals("Unexpected: ÷", exception.message)
    }

    @Test
    fun `Equation is Only One Remainder sign returns RuntimeException`() {
        //Given Only One Sign (%)
        val equation = "%"

        //When get The result of the equation
        val exception = assertThrows(RuntimeException::class.java) {
            CalcUtil.eval(equation)
        }

        //Then
        assertEquals("Unexpected: %", exception.message)
    }

    @Test
    fun `Equation ends with Sign (+) returns RuntimeException`() {
        //Given Equation end with Sign (+)
        val equation = "744+5175+"

        //When get The result of the equation
        val exception = assertThrows(RuntimeException::class.java) {
            CalcUtil.eval(equation)
        }

        //Then
        assertEquals("Unexpected: \uFFFF", exception.message)
    }

    @Test
    fun `Equation ends with Sign (-) returns RuntimeException`() {
        //Given Equation end with Sign (-)
        val equation = "744-5175-"

        //When get The result of the equation
        val exception = assertThrows(RuntimeException::class.java) {
            CalcUtil.eval(equation)
        }

        //Then
        assertEquals("Unexpected: \uFFFF", exception.message)
    }

    @Test
    fun `Equation ends with Sign (x) returns RuntimeException`() {
        //Given Equation end with Sign (×)
        val equation = "744×5175×"

        //When get The result of the equation
        val exception = assertThrows(RuntimeException::class.java) {
            CalcUtil.eval(equation)
        }

        //Then
        assertEquals("Unexpected: \uFFFF", exception.message)
    }

    @Test
    fun `Equation ends with Division Sign returns RuntimeException`() {
        //Given Equation end with Sign (÷)
        val equation = "744÷5175÷"

        //When get The result of the equation
        val exception = assertThrows(RuntimeException::class.java) {
            CalcUtil.eval(equation)
        }

        //Then
        assertEquals("Unexpected: \uFFFF", exception.message)
    }

    @Test
    fun `Equation ends with Remainder Sign returns RuntimeException`() {
        //Given Equation end with Sign (%)
        val equation = "744%5175%"

        //When get The result of the equation
        val exception = assertThrows(RuntimeException::class.java) {
            CalcUtil.eval(equation)
        }

        //Then
        assertEquals("Unexpected: \uFFFF", exception.message)
    }

    @Test
    fun `Equation is two Positive numbers or more with Sign (+) returns Sum of them`() {
        //Given two numbers or more with Sign (+)
        val equation = "2+2+2"

        //When get The result of the equation
        val result = CalcUtil.eval(equation)

        //Then
        assertEquals("6.0", result.toString())
    }

    @Test
    fun `Equation is two Positive numbers or more with Sign (x) returns Multiplication of them`() {
        //Given two numbers or more with Sign (×)
        val equation = "2×2×2"

        //When get The result of the equation
        val result = CalcUtil.eval(equation)

        //Then
        assertEquals("8.0", result.toString())
    }

    @Test
    fun `Equation is two Positive numbers or more with Sign (-) returns Subtract of them`() {
        //Given two numbers or more with Sign (-)
        val equation = "2-2-2"

        //When get The result of the equation
        val result = CalcUtil.eval(equation)

        //Then
        assertEquals("-2.0", result.toString())
    }

    @Test
    fun `Equation is two Positive numbers or more with Division Sign returns Divide of them`() {
        //Given two numbers or more with Sign (÷)
        val equation = "2÷2÷2"

        //When get The result of the equation
        val result = CalcUtil.eval(equation)

        //Then
        assertEquals("0.5", result.toString())
    }

    @Test
    fun `Equation is two Positive numbers or more with Remainder Sign returns Remainder of them`() {
        //Given two numbers or more with Sign (%)
        val equation = "2%2%2"

        //When get The result of the equation
        val result = CalcUtil.eval(equation)

        //Then
        assertEquals("0.0", result.toString())
    }

    @Test
    fun `Equation is one Positive number or more Divide By Zero returns Infinity`() {
        //Given tone number or more Divide By Zero
        val equation = "2+5÷0"

        //When get The result of the equation
        val result = CalcUtil.eval(equation)

        //Then
        assertEquals("Infinity", result.toString())
    }



    @Test
    fun `Equation is two Negative numbers or more with Sign (+) returns Sum of them`() {
        //Given two numbers or more with Sign (+)
        val equation = "-2+-2+-2"

        //When get The result of the equation
        val result = CalcUtil.eval(equation)

        //Then
        assertEquals("-6.0", result.toString())
    }

    @Test
    fun `Equation is two Negative numbers or more with Sign (x) returns Multiply of them`() {
        //Given two numbers or more with Sign (×)
        val equation = "-2×-2×-2"

        //When get The result of the equation
        val result = CalcUtil.eval(equation)

        //Then
        assertEquals("-8.0", result.toString())
    }

    @Test
    fun `Equation is two Negative numbers or more with Sign (-) returns Subtract of them`() {
        //Given two numbers or more with Sign (-)
        val equation = "-2--2--2"

        //When get The result of the equation
        val result = CalcUtil.eval(equation)

        //Then
        assertEquals("2.0", result.toString())
    }

    @Test
    fun `Equation is two Negative numbers or more with Division Sign returns Divide of them`() {
        //Given two numbers or more with Sign (÷)
        val equation = "-2÷-2÷-2"

        //When get The result of the equation
        val result = CalcUtil.eval(equation)

        //Then
        assertEquals("-0.5", result.toString())
    }

    @Test
    fun `Equation is two Negative numbers or more with Remainder Sign returns Remainder of them`() {
        //Given two numbers or more with Sign (%)
        val equation = "-2%-2%-2"

        //When get The result of the equation
        val result = CalcUtil.eval(equation)

        //Then
        assertEquals("-0.0", result.toString())
    }

    @Test
    fun `Equation is one Negative number or more Divide By Zero returns Infinity`() {
        //Given tone number or more Divide By Zero
        val equation = "-2+-5÷0"

        //When get The result of the equation
        val result = CalcUtil.eval(equation)

        //Then
        assertEquals("-Infinity", result.toString())
    }


}