package com.vtex.sum

import scala.io.StdIn._

object Main extends App {

  print("Digite o valor da soma: ")

  val target = readInt()

  print("\nDigite os números (separados por espaço em branco): ")

  val numbers = readLine().split(" ").map(Integer.parseInt).toList

  println(SubSetSummer.sums(numbers, target).map(_.mkString("(", ",", ")")).mkString("\n"))

}
