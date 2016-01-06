package com.vtext.path

object PathFinder {

  def findPath(paths: Map[Int, List[Int]], start: Int, end: Int): Option[List[Int]] = {
    def inner(curr: Int, visited: List[Int] = List.empty): List[Int] = {
      if(curr == end) visited :+ curr
      else {
        paths.getOrElse(curr, List.empty).filterNot(visited.contains) match {
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
