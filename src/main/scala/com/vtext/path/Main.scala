package com.vtext.path

import scala.io.StdIn._

object Main extends App {

  def readGraph = {
    val paths = Iterator.continually(readLine()).takeWhile(_.nonEmpty).map { s =>
      s.split(" ").toList match {
        case x :: xs => Map(Integer.parseInt(x) -> xs.map(Integer.parseInt))
        case Nil => Map.empty[Int, List[Int]]
      }
    } reduce (_ ++ _)
    Graph(paths)
  }

  def readLimits = {
    val limits = readLine().split(" ").map(Integer.parseInt)
    (limits.head, limits.last)
  }

  println("Digite: <no inicial> <no final>. Por ex: 1 5")
  println("==============")
  val (start, end) = readLimits

  println("Digite: <no> <vizinho> ... <vizinho>, seguido de enter. Para finalizar, pressione enter 2x. Por ex:")
  println("1 2 3 4 \n 2 3 \n 3 1 \n")
  println("==============")

  PathFinder.findPath(readGraph, start, end) match {
    case Some(x) => println(s"Caminho encontrado: (${x.mkString(",")})")
    case _ => println(s"Não existe caminho entre os dois nós!")
  }

}


