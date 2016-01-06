package com.vtext.sum

import com.vtex.sum.SubSetSummer
import org.scalatest.{Matchers, FlatSpec}

class SubSetSummerSpec extends FlatSpec with Matchers {

  it should "find all subsets with sum" in {
    SubSetSummer.sums(List(1, 2, 3, 4, 6), 6) should contain theSameElementsAs List(
      List(1, 2, 3),
      List(2, 4),
      List(6)
    )
  }

  it should "work with repeated numbers" in {
    SubSetSummer.sums(List(1, 1, 2), 2) should contain theSameElementsAs List(List(1, 1), List(2))
  }

  it should "work with negative numbers" in {
    SubSetSummer.sums(List(-3, -3, 6), 0) should contain theSameElementsAs List(List(-3, -3, 6))
  }

}
