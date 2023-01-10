package com.joao

object Variables extends App {

  val aValue = 2 // const
//  aValue = 3 compiler error

  var aVariable = 3
  aVariable = 4 //Ok

  var i = 0
  while (i < 10) {
    println("looping!")
    i += 1
  }
  //procedural thinking

  //"iterate"
  (0 until 10).foreach(i => println("right way!"))

  def invokeExternalService(list: List[Int]) = println(list)
  //mutation
  var myList = List(1, 2, 3)
  invokeExternalService(myList)
  myList = myList :+ 4 // new list
  // pass is around
  invokeExternalService(myList)

  // do it right
  val startingList = List(1, 2, 3)
  // use it
  invokeExternalService(startingList)
  val anotherList = startingList :+ 4
  invokeExternalService(anotherList)
}
