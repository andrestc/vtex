package com.vtex.sum

import scala.io.StdIn._
import SubSetSumList._

object Main extends App {

  print("Digite o valor da soma: ")
  val target = readInt()

  print("Digite os números (separados por espaço em branco): ")
  val numbers = readLine().split(" ").map(Integer.parseInt).toList

  val output = numbers.subSets(target) match {
    case x :: xs => s"Subsets encontrados: ${(x :: xs).map(_.mkString("(", ",", ")")).mkString(",")}"
    case Nil => s"Nenhum subset que some $target encontrado."
  }

  println(output)

}
