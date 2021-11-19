package gu.com

import org.scalatest.flatspec.{AnyFlatSpec}
import org.scalatest.matchers.should.{Matchers}

class MainTest extends AnyFlatSpec with Matchers {
  "extractResults" should "a constituency result" in {
    val input: String = "Cardiff West, 11014, C, 17803, L, 4923, UKIP, 2069, LD"
    val partyResults: List[PartyResult] = List(PartyResult(11014, "C"), PartyResult(17803, "L"), PartyResult(4923, "UKIP"), PartyResult(2069, "LD"))
    val output: ConstituencyResult = ConstituencyResult("Cardiff West", partyResults)
    Main.extractResults(input) should equal (output)
  }
}
