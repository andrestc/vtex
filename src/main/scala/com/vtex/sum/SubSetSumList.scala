package com.vtex.sum

import scala.annotation.tailrec

class SubSetSumList(numbers: List[Int]) {

  lazy val sorted = numbers.sorted
  lazy val size = sorted.size

  def subSets(targetSum: Int): List[List[Int]] = {
    @tailrec
    def bT(stack: List[(List[Int], List[Int])], results: List[List[Int]] = List.empty): List[List[Int]] = {

      def pushCombinations(stack: List[(List[Int], List[Int])], current: List[Int], pool: List[Int]) = {
        pool.view.zipWithIndex.map { case (n, i) =>
          (current :+ n, pool.slice(i+1, pool.size))
        }.toList ++ stack
      }

      if(stack.nonEmpty) {
        val (current, pool) = stack.head
        val currentSum = current.sum

        currentSum match {
          case sum if sum > targetSum => bT(stack.tail, results)
          case sum if sum == targetSum => bT(stack.tail, results :+ current)
          case sum if sum < targetSum => bT(pushCombinations(stack.tail, current, pool), results)
        }
      } else {
        results
      }

    }

    bT(sorted.view.zipWithIndex.map { case (n, i) =>
      (List(n), sorted.slice(i+1, size))
    }.toList)
  }

}


object SubSetSumList {

  implicit def listToSubSetSumList(l: List[Int]): SubSetSumList = new SubSetSumList(l)

}
