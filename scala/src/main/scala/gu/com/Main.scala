package gu.com

//A result will consist of:
//
//A constituency
//A repeating set of pairs with the party code and the votes cast
//So for example:
//
//Cardiff West, 11014, C, 17803, L, 4923, UKIP, 2069, LD
//Islington South & Finsbury, 22547, L, 9389, C, 4829, LD, 3375, UKIP, 3371, G, 309, Ind
//We want to transform this into a standard result that shows:
//
//the constituency name
//translates the party code into a full name
//shows the share of the vote as a percentage of all the votes cast
//Codes
//C - Conservative Party
//L - Labour Party
//UKIP - UKIP
//LD - Liberal Democrats
//G - Green Party
//Ind - Independent
//SNP - SNP

case class PartyResult(votes: Int, partyCode: String)

case class ConstituencyResult(constituencyName: String, results: List[PartyResult])

case class PartyShare(partyCode: String, percentage: Double)

object Main {
  def main(args: Array[String]): Unit = {
    
  }
  def whereWeLive = "Earth"

  def extractResults(constituencyVotes: String): ConstituencyResult = {
    //Cardiff West, 11014, C, 17803, L, 4923, UKIP, 2069, LD
    val list = constituencyVotes.split(", ").toList
    val constituencyName = list.head
    val results = list.tail
    val partyResults: List[PartyResult] = results.grouped(2).toList.map(r => PartyResult(r.head.toInt, r.last))
    ConstituencyResult(constituencyName, partyResults)
  }

  def convertPartyCode(partyCode: String): String = partyCode match {
    case "C" => "Conservative Party"
    case "L" => "Labour Party"
    case "UKIP" => "UKIP"
    case "LD" => "Liberal Democrats"
    case "G" => "Green Party"
    case "Ind" => "Independent"
    case "SNP" => "SNP"
    case _ => "Error"
  }

  def calculatePercentage(partyResults: List[PartyResult]): List[PartyShare] = {
    // List(PartyResult(25, "C"), PartyResult(75, "L"))
    val total = partyResults.map(r => r.votes).sum
    partyResults.map(r => PartyShare(r.partyCode, r.votes / total))
  }
}
