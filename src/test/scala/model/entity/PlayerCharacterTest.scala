package cl.uchile.dcc.citric
package model

import model.entity.{Chicken, PlayerCharacter}

import cl.uchile.dcc.citric.model.norma.{NormaLvl1, NormaLvl2, NormaLvl3, NormaLvl5}
import cl.uchile.dcc.citric.model.objective.{Stars, Wins}

import scala.util.Random

class PlayerCharacterTest extends munit.FunSuite {
  /*
  REMEMBER: It is a good practice to use constants for the values that are used in multiple
  tests, so you can change them in a single place.
  This will make your tests more readable, easier to maintain, and less error-prone.
  */
  private val name = "testPlayer"
  private val nameSecond = "testPlayer2"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  /* Add any other constants you need here... */

  /*
  This is the object under test.
  We initialize it in the beforeEach method so we can reuse it in all the tests.
  This is a good practice because it will reset the object before each test, so you don't have
  to worry about the state of the object between tests.
  */
  private var character: PlayerCharacter = _  // <- x = _ is the same as x = null
  private var secondCharacter: PlayerCharacter = _
  private var chicken: Chicken = _

  // This method is executed before each `test(...)` method.
  private var randomNumberGenerator: Random = _
  override def beforeEach(context: BeforeEach): Unit = {
    randomNumberGenerator = new Random(11)
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      randomNumberGenerator
    )
    chicken = new Chicken()
  }

  test("A character should have correctly set their attributes") {
    assertEquals(character.name, name)
    assertEquals(character.maxHp, maxHp)
    assertEquals(character.attack, attack)
    assertEquals(character.defense, defense)
    assertEquals(character.evasion, evasion)
  }

  // Two ways to test randomness (you can use any of them):

  // 1. Test invariant properties, e.g. the result is always between 1 and 6.
  test("A character should be able to roll a dice") {
    for (_ <- 1 to 10) {
      assert(character.generateRandomInt(6) >= 1 && character.generateRandomInt(6) <= 6)
    }
  }

  /** Initial norma level for every player is 1 */
  test("Initial norma for a player must be correct") {
    assert(character.norma.isInstanceOf[NormaLvl1])
  }

  test("Setter for norma (normaClear) must work correctly") {
    character.normaClear(new NormaLvl5())
    assert(character.norma.isInstanceOf[NormaLvl5])
  }

  /** Initial wins for every player is 0 */
  test("Initial wins for a player must be correct") {
    assertEquals(character.wins, 0)
  }

  test("Setter for wins must work correctly") {
    character.wins_(50)
    assertEquals(character.wins, 50)
  }

  /** Initially, a player can't be in KO status */
  test("Initial KO state for a player must be correct") {
    assertEquals(character.isKO, false)
  }

  test("Setter for KO status must work correctly") {
    character.isKO_(true)
    assertEquals(character.isKO, true)
  }

  /** Initial recovery status is false for every player */
  test("Initial recovery state for a player must be correct") {
    assertEquals(character.inRecovery, false)
  }

  test("Setter for recovery state must work correctly") {
    character.inRecovery_(true)
    assertEquals(character.inRecovery, true)
  }

  /** Initial objective for every player is unknown. Marked as null. */
  test("Initial objective for a player must be correct") {
    assertEquals(character.objective, null)
  }

  // There are two cases here:
  /** 1) The objective is either Stars or Wins which is correct. */
  test("Setter for objective must work correctly") {
    character.objective_(new Stars())
    assert(character.objective.isInstanceOf[Stars])
    character.objective_(new Wins())
    assert(character.objective.isInstanceOf[Wins])
  }

  /** By default, this setting is true */
  test("Initial skipHomePanel setting for a player must be correct") {
    assertEquals(character.skipHomePanel, true)
  }

  test("Setter for skipHomePanel must work correctly") {
    character.skipHomePanel_(false)
    assertEquals(character.skipHomePanel, false)
  }

  test("Attacks works as it should") {
    // Attack mustn't throw an exception
    character.attack(chicken)
    // And it should change character's combat status to false
    assertEquals(character.inCombat, false)
  }

  test("Player vs. player victory should be handled correctly") {
    secondCharacter = new PlayerCharacter(
      nameSecond,
      maxHp,
      attack,
      defense,
      evasion,
      randomNumberGenerator
    )

    /** Previous setup of wins and stars */
    character.wins_(50)
    character.stars_(100)
    secondCharacter.stars_(150)

    /** Winner is character. Loser is secondCharacter. */
    val previousWinnerWins = character.wins
    val previousWinnerStars = character.stars
    val previousLoserStars = secondCharacter.stars
    val halfLoserStars = previousLoserStars / 2

    // We apply the handle (Double Dispatch)
    character.handleVictory(secondCharacter)

    /** Loser gives half of their stars to the winner.
     * Winner increases its victories by 2. Loser enter KO & recovery status */
    assertEquals(character.stars, previousWinnerStars + halfLoserStars)
    assertEquals(character.wins, previousWinnerWins + 2)
    assertEquals(secondCharacter.stars, previousLoserStars - halfLoserStars)
    assertEquals(secondCharacter.isKO, true)
    assert(secondCharacter.inRecovery, true)
  }

  test("Norma Check method must work correctly") {
    /** Test by Stars */
    character.objective_(new Stars())
    // Only 10 stars are required to Norma Check.
    character.stars_(15)
    character.normaCheck()
    // Player has to Norma Clear because they met the criteria
    assert(character.norma.isInstanceOf[NormaLvl2])

    /** Test by Wins */
    character.objective_(new Wins())
    // They need 3 wins to Norma Check from level 2
    character.wins_(1)
    character.normaCheck()
    // Player doesn't have to Norma Clear. They didn't met the requirements.
    assert(character.norma.isInstanceOf[NormaLvl2])

    /** Test by Wins meeting criteria */
    character.wins_(10)
    character.normaCheck()
    assert(character.norma.isInstanceOf[NormaLvl3])
  }
}
