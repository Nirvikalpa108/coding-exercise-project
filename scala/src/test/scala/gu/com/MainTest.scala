package gu.com

import org.scalatest.flatspec.{AnyFlatSpec}
import org.scalatest.matchers.should.{Matchers}

class MainTest extends AnyFlatSpec with Matchers {

  "getPointsForLetter" should "return the correct point values" in {
    Main.getPointsForLetter('E') should equal(1)
    Main.getPointsForLetter('D') should equal(2)
    Main.getPointsForLetter('C') should equal(3)
    Main.getPointsForLetter('@') should equal(0)
  }

  "getPointsForWord" should "return the correct point value" in {
    Main.getPointsForWord("GUARDIAN") should equal(10)
  }


}
