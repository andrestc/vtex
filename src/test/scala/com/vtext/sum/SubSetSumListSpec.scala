package com.vtext.sum

import com.vtex.sum.SubSetSumList._
import org.scalatest.{Matchers, FlatSpec}

class SubSetSumListSpec extends FlatSpec with Matchers {

  it should "find all subsets with sum" in {
    List(1, 2, 3, 4, 6).subSets(6) should contain theSameElementsAs List(
      List(1, 2, 3),
      List(2, 4),
      List(6)
    )
  }

  it should "work with repeated numbers" in {
    List(1, 1, 2).subSets(2) should contain theSameElementsAs List(List(1, 1), List(2))
  }

  it should "work with negative numbers" in {
    List(-3, -3, 6).subSets(0) should contain theSameElementsAs List(List(-3, -3, 6))
  }

}
