package gu.com

import org.scalatest.flatspec.{AnyFlatSpec}
import org.scalatest.matchers.should.{Matchers}

class MainTest extends AnyFlatSpec with Matchers {
  val partyResults: List[PartyResult] = List(PartyResult(11014, "C"), PartyResult(17803, "L"), PartyResult(4923, "UKIP"), PartyResult(2069, "LD"))

  "extractResults" should "a constituency result" in {
    val input: String = "Cardiff West, 11014, C, 17803, L, 4923, UKIP, 2069, LD"
    val output: ConstituencyResult = ConstituencyResult("Cardiff West", partyResults)
    Main.extractResults(input) should equal (output)
  }

  "convertPartyCode" should "translate the party code into a full name" in {
    val input: String = "C"
    val output: String = "Conservative Party"
    //    val output: List[String] = List("Conservative Party", "Labour Party", "UKIP", "Liberal Democrats")
    Main.convertPartyCode(input) should equal (output)
  }

  "calculatePercentage" should "calculate the share of the vote as a percentage of all the votes cast" in {
    val input: List[PartyResult] = List(PartyResult(25, "C"), PartyResult(75, "L"))

    val output: List[PartyShare] = List(PartyShare("C", 25.0), PartyShare("L", 75.0))

    Main.calculatePercentage(input) should equal (output)

  }
}
