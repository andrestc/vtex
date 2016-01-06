package com.vtext.path

import org.scalatest.{Matchers, FlatSpec}

class PathFinderSpec extends FlatSpec with Matchers {

  val graph = Map(1 -> List(2, 3), 2 -> List(4), 3 -> List(5))
  val cycledGraph = Map(1 -> List(2, 3), 2 -> List(3, 4), 4 -> List(5), 6 -> List(7))

  it should "find a path" in {
    PathFinder.findPath(graph, 1, 4).get should contain theSameElementsInOrderAs List(1, 2, 4)
  }

  it should "return None when there is no path" in {
    PathFinder.findPath(graph, 4, 5) should not be defined
  }

  it should "return None when start doesn't have adjacent nodes" in {
    PathFinder.findPath(graph, 5, 1) should not be defined
  }

  it should "return None if start node doesn't exist" in {
    PathFinder.findPath(graph, 10, 1) should not be defined
  }

  it should "handle cycles when there is a path" in {
    PathFinder.findPath(cycledGraph, 1, 5).get should contain theSameElementsInOrderAs List(1, 2, 4, 5)
  }

  it should "handle cycles when there is no path" in {
    PathFinder.findPath(cycledGraph, 1, 6) should not be defined
  }
}
