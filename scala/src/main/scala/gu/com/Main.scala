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

case class ConstiuencyResult(constituencyName: String, results: List[PartyResult])



object Main {
  def main(args: Array[String]): Unit = {
    
  }
  def whereWeLive = "Earth"

  def extractResults(constituancyVotes: String): ConstituencyResult = ???
}
