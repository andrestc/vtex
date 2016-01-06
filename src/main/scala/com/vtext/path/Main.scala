package com.vtext.path

import scala.io.StdIn._

object Main extends App {

  val parser = new Parser

  print("Digite: <no inicial> <no final>. Por ex: 1 5: ")
  val (start, end) = parser.parseLimits(readLine())

  println("\nDigite: <no> <vizinho> ... <vizinho>, seguido de enter. Para finalizar, pressione enter 2x. Por ex:")
  println("1 2 3 4 \n 2 3 \n 3 1 \n")

  PathFinder.findPath(parser.parseGraph(Iterator.continually(readLine())), start, end) match {
    case Some(x) => println(s"Caminho encontrado: (${x.mkString(",")})")
    case _ => println(s"Não existe caminho entre os dois nós!")
  }
}

class Parser {
  def parseGraph(it: Iterator[String]) = {
    val paths = it.takeWhile(_.nonEmpty).map { s =>
      s.split(" ").toList match {
        case x :: xs => Map(Integer.parseInt(x) -> xs.map(Integer.parseInt))
        case Nil => Map.empty[Int, List[Int]]
      }
    } reduce (_ ++ _)
    Graph(paths)
  }

  def parseLimits(s: String) = {
    val limits = s.split(" ").map(Integer.parseInt)
    (limits.head, limits.last)
  }
}

