package com.calculatooor.simple_calculator.views

import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performClick
import com.calculatooor.simple_calculator.ui.theme.Simple_CalculatorTheme
import org.junit.Rule
import org.junit.Test

class MainScreenKtTest{

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun enterOnlyNumbers_showsOnlyTheSameNumbers() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }

        composeTestRule.onNode(hasText("1") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("3") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("4") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("5") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("RESULT")).assertExists("12345.0")

    }

    @Test
    fun enterOnlyPlusSign_showsError() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }

        composeTestRule.onNode(hasText("+") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("ERROR")).assertExists("Unexpected: \uFFFF")

    }

    @Test
    fun enterOnlySubtractSign_showsError() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }

        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("ERROR")).assertExists("Unexpected: \uFFFF")

    }

    @Test
    fun enterOnlyMultiplySign_showsError() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }

        composeTestRule.onNode(hasText("×") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("ERROR")).assertExists("Unexpected: \uFFFF")

    }

    @Test
    fun enterOnlyDivisionSign_showsError() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }

        composeTestRule.onNode(hasText("÷") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("ERROR")).assertExists("Unexpected: \uFFFF")

    }

    @Test
    fun enterOnlyRemainderSign_showsError() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }

        composeTestRule.onNode(hasText("%") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("ERROR")).assertExists("Unexpected: \uFFFF")

    }

    @Test
    fun enterEquationEndsWithPlusSign_showsError() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }
        composeTestRule.onNode(hasText("7") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("+") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("7") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("+") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("ERROR")).assertExists("Unexpected: \uFFFF")

    }

    @Test
    fun enterEquationEndsWithSubtractSign_showsError() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }

        composeTestRule.onNode(hasText("7") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("7") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("ERROR")).assertExists("Unexpected: \uFFFF")

    }

    @Test
    fun enterEquationEndsWithMultiplySign_showsError() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }

        composeTestRule.onNode(hasText("7") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("×") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("7") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("×") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("ERROR")).assertExists("Unexpected: \uFFFF")

    }

    @Test
    fun enterEquationEndsWithDivisionSign_showsError() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }

        composeTestRule.onNode(hasText("7") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("÷") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("7") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("÷") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("ERROR")).assertExists("Unexpected: \uFFFF")

    }

    @Test
    fun enterEquationEndsWithRemainderSign_showsError() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }

        composeTestRule.onNode(hasText("7") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("%") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("7") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("%") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("ERROR")).assertExists("Unexpected: \uFFFF")

    }

    @Test
    fun enterTwoPositiveNumbersOrMoreWithPlusSign_showsSumOfThem() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }


        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("+") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("+") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("RESULT")).assertExists("6.0")

    }

    @Test
    fun enterTwoPositiveNumbersOrMoreWithSubtractionSign_showsSubtractOfThem() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }


        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("RESULT")).assertExists("-2.0")

    }

    @Test
    fun enterTwoPositiveNumbersOrMoreWithMultiplicationSign_showsMultiplyOfThem() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }


        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("×") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("×") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("RESULT")).assertExists("8.0")

    }

    @Test
    fun enterTwoPositiveNumbersOrMoreWithDivisionSign_showsDivideOfThem() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }


        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("÷") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("÷") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("RESULT")).assertExists("0.5")

    }

    @Test
    fun enterTwoPositiveNumbersOrMoreWithRemainderSign_showsRemainderOfThem() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }


        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("%") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("%") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("RESULT")).assertExists("0.0")

    }



    @Test
    fun enterTwoNegativeNumbersOrMoreWithPlusSign_showsSumOfThem() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }

        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("+") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("+") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("RESULT")).assertExists("-6.0")

    }

    @Test
    fun enterTwoNegativeNumbersOrMoreWithSubtractionSign_showsSubtractOfThem() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }

        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("RESULT")).assertExists("2.0")

    }

    @Test
    fun enterTwoNegativeNumbersOrMoreWithMultiplicationSign_showsMultiplyOfThem() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }

        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("×") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("×") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("RESULT")).assertExists("-8.0")

    }

    @Test
    fun enterTwoNegativeNumbersOrMoreWithDivisionSign_showsDivideOfThem() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }

        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("÷") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("÷") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("RESULT")).assertExists("-0.5")

    }

    @Test
    fun enterTwoNegativeNumbersOrMoreWithRemainderSign_showsRemainderOfThem() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }

        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("%") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("%") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("RESULT")).assertExists("-0.0")

    }

    @Test
    fun enterTwoPositiveNumbersOrMoreDivideByZero_showsInfinity() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }


        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("+") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("5") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("÷") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("0") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("RESULT")).assertExists("Infinity")

    }

    @Test
    fun enterTwoNegativeNumbersOrMoreDivideByZero_showsInfinity() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }

        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("+") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("-") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("5") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("÷") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("0") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("=") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("RESULT")).assertExists("-Infinity")

    }

    @Test
    fun enterNumbersAndClickOnAC_showsEmptyResultOrText() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }

        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("6") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("7") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("4") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("5") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("5") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("0") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("AC") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("RESULT")).assertExists("")
        composeTestRule.onNode(hasTestTag("ERROR")).assertExists("")
    }

    @Test
    fun enterNumbersAndClickOnC_removesLastCharacter() {

        composeTestRule.setContent {
            Simple_CalculatorTheme {
                MainScreen()
            }
        }

        composeTestRule.onNode(hasText("2") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("6") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("7") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("4") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("5") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("5") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("0") and hasClickAction()).performClick()
        composeTestRule.onNode(hasText("C") and hasClickAction()).performClick()
        composeTestRule.onNode(hasTestTag("RESULT")).assertExists("267455")
        composeTestRule.onNode(hasTestTag("ERROR")).assertExists("")
    }




}