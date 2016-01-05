package com.vtext.path

import org.scalatest.{Matchers, FlatSpec}

class PathFinderSpec extends FlatSpec with Matchers {

  it should "find a path" in {
    val path = PathFinder.findPath(Map(1 -> List(2, 3), 2 -> List(4), 3 -> List(5)), 1, 4)

    path.get should contain theSameElementsInOrderAs List(1, 2, 4)
  }

  it should "return None when there is no path" in pending

  it should "handle cycles when there is a path" in pending

  it should "handle cycles when there is no path" in pending
}
