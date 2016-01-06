package com.vtext.path

import scala.annotation.tailrec
import scala.collection.{mutable => m}

case class Graph[T](paths: Map[T, List[T]]) {
  def neighbours(node: T) = paths.getOrElse(node, List.empty)
}

object PathFinder {

  def findPath[T](graph: Graph[T], start: T, end: T): Option[List[T]] = {

    @tailrec
    def inner(stack: List[(T, Int)], path: List[(T, Int)], visited: T*): Option[List[T]] = {
      if(stack.nonEmpty) {
        val (current, depth, newPath) = {
          val (current, depth) = stack.head
          val updatedPath = if(depth > 0) (current, depth) :: path.dropWhile(_._2 >= depth) else path
          (current, depth, updatedPath)
        }
        if(!(current == end)){
          val updatedStack = graph.neighbours(current).filterNot(visited.contains).foldLeft(stack.tail) { (s, n) =>
            (n, depth+1) :: s
          }
          inner(updatedStack, newPath, visited :+ current:_*)
        } else {
          Option(newPath.map(_._1).reverse)
        }
      } else {
        Option.empty
      }
    }

    inner(List((start, 0)), List((start, 0)))

  }

}
