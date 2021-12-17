package gu.com
import scala.util.Random

//  Calculate the score for a word. The score is the sum of the points for the letters that make up a word.
//     For example: GUARDIAN = 2 + 1 + 1 + 1 + 2 + 1 + 1 + 1 = 10.
//  Assign seven tiles chosen randomly from the English alphabet to a player's rack.
//  In the real game, tiles are taken at random from a 'bag' containing a fixed number of each tile.
//     Assign seven tiles to a rack using a bag containing the above distribution.
//  Find a valid word formed from the seven tiles. A list of valid words can be found in dictionary.txt.
//  Find the longest valid word that can be formed from the seven tiles.
//  Find the highest scoring word that can be formed.
//  Find the highest scoring word if any one of the letters can score triple.
//  For discussion: how would we adapt our solution for a multiplayer environment?


//Point(s)	Letter(s)
//1	E, A, I, O, N, R, T, L, S, U
//2	D, G
//3	B, C, M, P
//4	F, H, V, W, Y
//5	K
//8	J, X
//10	Q, Z

object Main {
  def main(args: Array[String]): Unit = {

  }

  def getPointsForLetter(letter: Char): Int = letter match {
    case x if List('E', 'A', 'I', 'O', 'N', 'R', 'T', 'L', 'S', 'U').contains(x) => 1
    case x if List('D', 'G').contains(x) => 2
    case x if List('B', 'C', 'M', 'P').contains(x) => 3
    case x if List('F', 'H', 'V', 'W', 'Y').contains(x) => 4
    case x if List('K').contains(x) => 5
    case x if List('J', 'X').contains(x) => 8
    case x if List('Q', 'Z').contains(x) => 10
    case _ => 0
  }

  def getPointsForWord(word: String): Int = word.map(getPointsForLetter).sum

  def getRandomTiles(): List[Char] = {
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("")
    val random = Random
    // val z = List.fill(1000)(10000).map(scala.util.Random.nextInt)
    List.fill(7)(alphabet.length-1).map(alphabet(random.nextInt(alphabet.length - 1)))
//    val one = alphabet(random.nextInt(alphabet.length))
  }
}
