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
      def pushUnvisited(node: T, depth: Int) = {
        graph.neighbours(node).filterNot(visited.contains).foldLeft(stack.tail)( (s,n) => (n, depth) :: s)
      }

      def rewindPath(current: T, depth: Int) = if(depth > 0) {
        (current, depth) :: path.dropWhile(_._2 >= depth)
      } else path

      if(stack.nonEmpty) {
        val (current, depth) = stack.head
        val updatedPath = rewindPath(current, depth)
        if(!(current == end)){
          inner(pushUnvisited(current, depth+1), updatedPath, visited :+ current:_*)
        } else {
          Option(updatedPath.map(_._1).reverse)
        }
      } else {
        Option.empty
      }
    }

    inner(List((start, 0)), List((start, 0)))

  }

}
