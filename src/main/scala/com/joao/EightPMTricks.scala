package com.joao

object EightPMTricks {

  // 1 - switch on steroids
  val aNumber = 44
  val ordinal = aNumber match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => aNumber + "th" // default
  }

  // 2 - case class deconstruction
  case class Person(name: String, age: Int)
  val jojo = Person("Jojo", 19)

  val jojoGreeting = jojo match {
    case Person(name, age) => s"Hi, my name is $name and I am $age years old"
  }

  // trick #1 - list extractor
  val numberList = List(1, 2, 3, 10)

  val mustHaveThree = numberList match {
    case List(_, _, 3, somethingElse) => s"List has 3rd element 3, so the 4th element is $somethingElse"
  }

  // trick #2 - Haskell-like prepending
  val startsWithOne = numberList match {
    case 1 :: tail => s"list starts with one $tail"
  }

  def process(aList: List[Int]) = aList match {
    case Nil => "list is empty"
    case head :: tail => s"list starts with $head, tail is $tail"
    // head return the first element and tail return all the elements except the first
  }

  // trick #3 - vararg pattern
  val dontCareAboutTheRest = numberList match {
    case List(_, 2, _*) => "I only care about the second number being 2"
    // this match with list of any size
  }

  // trick #4 - other infix patterns
  val mustEndWithTen = numberList match {
    case List (1, 2, _) :+ 10 => "that's right"
  }

  val mustEndWithTen2 = numberList match {
    case List(1, _*) :+ 10 => "I don't care how long the list is, just need to end in 10"
  }

  // trick #5 - type specifiers
  def gimmeAvalue(): Any = 45

  val gimmeTheType = gimmeAvalue() match {
    case _: String => "I have a String"
    case _: Int => "I have an int"
    case _ => "Something else"
  }

  // trick #6 - name binding
  def requestMoreInfo(p: Person): String = s"The person ${p.name} is a good person."

  val jojosInfo = jojo match {
    case p @ Person(name, age) => s"${name}'s info: ${requestMoreInfo(p)}"
  }

  // trick #7 - conditional guards
  val ordinal2 = aNumber match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case n if n % 10 == 1 => n + "st"
    case n if n % 10 == 2 => n + "nt"
    case n if n % 10 == 3 => n + "rt"
    case _ => aNumber + "th"
  }

  // trick #8 - alternative patterns
  val myOptimalList = numberList match {
    case List(1, _*) | List(_, _, 3, _*) => "I like this list"
    case _ => "I hate this list"
  }


  def main(args: Array[String]): Unit = {
    val theList = List(1, 2, 3)
    println(process(theList))
  }

}
