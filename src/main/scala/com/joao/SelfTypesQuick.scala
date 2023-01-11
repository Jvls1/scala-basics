package com.joao

object SelfTypesQuick extends App {

  trait Edible

  // hierarchy #1
  trait Person {
    def hasAllergiesTo(thing: Edible): Boolean
  }

  trait Child extends Person
  trait Adult extends Person

  // hierarchy #2
  trait Diet { this: Person => // self-type: whoever extends Diet MUST ALSO extend Person
    def eat(thing: Edible): Boolean =
      if (this.hasAllergiesTo(thing)) false
      else true
  }

  trait Carnivore extends Diet with Person
  trait Vegetarian extends Diet with Person

  class VegetarianAthlete extends Vegetarian with Adult {
    override def hasAllergiesTo(thing: Edible) = false
  }

  // PROBLEM: Diet must be applicable to Persons only
//  class VegetarianAthlete extends Vegetarian with Adult //enforce at compile time

  // Option #1 - enforce a subtype relationship

//  // hierarchy #1
//  trait Person {
//    def hasAllergiesTo(thing: Edible): Boolean
//  }
//
//  trait Child extends Person
//  trait Adult extends Person
//
//  // hierarchy #2
//  trait Diet extends Person {
//    def eat(thing: Edible): Boolean =
//      if (this.hasAllergiesTo(thing)) false
//      else false
//  }
//
//  trait Carnivore extends Diet
//  trait Vegetarian extends Diet

  // Option #2 - add a type argument
  // hierarchy #2
//  trait Diet[T <: Person] {
//    def eat(thing: Edible): Boolean
//  }
//
//  trait Carnivore[T <: Person] extends Diet[T]
//
//  trait Vegetarian[T <: Person] extends Diet[T]

  // Option #3 - self type

//  trait Diet {
//    this: Person => // self-type: whoever extends Diet MUST ALSO extend Person
//    def eat(thing: Edible): Boolean =
//      if (this.hasAllergiesTo(thing)) false
//      else true
//  }
//
//  trait Carnivore extends Diet with Person
//
//  trait Vegetarian extends Diet with Person
//
//  class VegetarianAthlete extends Vegetarian with Adult {
//    override def hasAllergiesTo(thing: Edible) = false
//  }

  // inheritance vs self-types
  trait Animal
  trait Dog extends Animal // a Dog IS AN Animal

  trait Diet2 { self: Person => // a diet REQUIRES a Person

  }
}
