package com.vtext.path

import scala.annotation.tailrec
import scala.collection.{mutable => m}

case class Graph[T](paths: Map[T, List[T]]) {
  def neighbours(node: T) = paths.getOrElse(node, List.empty)
}

object PathFinder {

  def findPath[T](graph: Graph[T], start: T, end: T): Option[List[T]] = {

    @tailrec
    def inner(stack: m.Stack[(T, Int)], path: m.Stack[(T, Int)], visited: T*): Option[List[T]] = {
      if(stack.nonEmpty) {
        val (current, depth) = {
          val (current, depth) = stack.pop
          while (depth > 0 && path.head._2 >= depth) path.pop
          path.push((current, depth))
          (current, depth)
        }
        if(!(current == end)){
          graph.neighbours(current).filterNot(visited.contains).foreach(n => stack.push((n, depth+1)))
          inner(stack, path, visited :+ current:_*)
        } else {
          Option(path.toList.map(_._1).reverse)
        }
      } else {
        None
      }
    }

    inner(m.Stack((start, 0)), m.Stack())

  }

}
