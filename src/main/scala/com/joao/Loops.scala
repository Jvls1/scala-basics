package com.joao

object Loops extends App {

  val x = 3 //constant

  var y = 5 //
  y = 6 //ok

  // imperatively = INSTRUCTIONS
  while (y < 10) {
    println("Don't use it")
    y += 1
  }
  // functionally = EXPRESSIONS
  val result = (y to  10).foreach(_ => println("I'm doing it right"))

  // transform a list
  List(1, 2, 3).map(x => x + 1) // List(2,3,4)
  List(1, 2, 3).flatMap(n => Seq.fill(n)(1)) // List(1, 1, 1, 1, 1, 1)
  List(1, 2, 3).filter(n => n % 42 == 0)
  // fold, find, count, maxBy, sum, reduce

  // foreach fallacy
  List(1, 2, 3).foreach { x => //lambda = function = function object
    println(x)
  }

  // for comprehensions = EXPRESSIONS
  val pairs = for {
    x <- List(1, 2, 3)
    y <- List(4, 5, 6)
  } yield (x, y)

  println(pairs)

  // equivalent code = for comprehension compiles to THIS
  println(List(1, 2, 3).flatMap(x => List(4, 5, 6).map(y => (x, y))))
}
