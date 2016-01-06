package com.vtext.path

case class Graph[T](paths: Map[T, List[T]]) {
  def neighbours(node: T) = paths.getOrElse(node, List.empty)
}

object PathFinder {

  def findPath[T](graph: Graph[T], start: T, end: T): Option[List[T]] = {
    def inner(curr: T, visited: List[T] = List.empty): List[T] = {
      if(curr == end) visited :+ curr
      else {
        graph.neighbours(curr).filterNot(visited.contains) match {
          case x :: xs => (x :: xs).flatMap(n => inner(n, visited :+ curr))
          case Nil => List.empty
        }
      }
    }
    inner(start) match {
      case x :: xs => Some(x :: xs)
      case Nil => Option.empty
    }
  }

}
