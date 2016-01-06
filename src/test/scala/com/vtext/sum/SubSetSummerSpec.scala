package com.vtext.sum

import com.vtex.sum.SubSetSummer
import org.scalatest.{Matchers, FlatSpec}

class SubSetSummerSpec extends FlatSpec with Matchers {

  it should "find all subsets with sum" in {
    SubSetSummer.sums(List(1, 2, 3, 4, 6), 6) should contain theSameElementsInOrderAs List(
      List(1, 2, 3),
      List(2, 4),
      List(6)
    )
  }

}
