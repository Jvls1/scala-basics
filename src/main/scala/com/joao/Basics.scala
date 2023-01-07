package com.joao

object Basics extends App {
  // defining a value
  val myAge: Int = 19 // const int meaningOfLife = 42;

  // Int, Boolean, Char, Double, Float, String
  val aBoolean = false // type is optional

  // strings and string operations
  val aString = "Hello World"
  val aComposedString = "Hello" + " " + "World"
  val anInterpolatedString = s"I have $myAge years old"

  // expressions = structures that can be reduced to a value
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if (myAge > 43) 56 else 999 // in other languages: myAge > 43 ? 56 : 999
  println(ifExpression) // 999
  val chainedIfExpression =
    if (myAge > 43) 56
    else if (myAge < 0) -2
    else if (myAge > 999) 78
    else 0

  // code blocks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 67

    // value of block is the value of the last expression
    aLocalValue + 3
  }

  // define a function
  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  // recursive functions
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)

  /*
    factorial(5) = 5 * factorial(4) = 5 * 24 = 120
    factorial(4) = 4 * factorial(3) = 4 * 6
    factorial(3) = 3 * factorial(2) = 3 * 2
    factorial(2) = 2 * factorial(1) = 2 * 1
    factorial(1) = 1
   */

  // In Scala we don't use loops or iteration, we use RECURSION!

  // the Unit type = no meaningful value === "void" in other languages
  // type of SIDE EFFECTS
  println("I'm learning Scala") // System.out.println, printf, print, console.log

  def myUnitReturningFunction(): Unit = {
    println("I'm returning Unit")
  }


  val theUnit = ()
}
