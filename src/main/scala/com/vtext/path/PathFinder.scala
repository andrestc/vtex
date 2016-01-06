package com.vtext.path

case class Graph[T](paths: Map[T, List[T]]) {
  def neighbours(node: T) = paths.getOrElse(node, List.empty)
}

object PathFinder {

  def findPath[T](graph: Graph[T], start: T, end: T): Option[List[T]] = {
    def inner(current: T, visited: List[T] = List.empty): List[T] = {
      if(current == end) visited :+ current
      else {
        graph.neighbours(current).filterNot(visited.contains) match {
          case x :: xs => (x :: xs).flatMap(n => inner(n, visited :+ current))
          case Nil => List.empty
        }
      }
    }
    Option(inner(start)).filterNot(_.isEmpty)
  }

}
