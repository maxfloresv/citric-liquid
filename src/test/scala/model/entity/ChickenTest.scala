package cl.uchile.dcc.citric
package model.entity

import cl.uchile.dcc.citric.model.state.GameController

class ChickenTest extends munit.FunSuite {
  private var chicken: Chicken = _
  private var roboBall: RoboBall = _
  private var seagull: Seagull = _

  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val ctx: GameController = new GameController()

  private var character: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    chicken = new Chicken()
    roboBall = new RoboBall()
    seagull = new Seagull()

    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      ctx
    )
  }

  test("A Chicken must have correctly set its stats") {
    assertEquals(chicken._atkPoints, -1)
    assertEquals(chicken._defPoints, -1)
    assertEquals(chicken._evaPoints, 1)
  }

  test("A Chicken must correctly retrieve bonus stars") {
    assertEquals(chicken.bonus(seagull), 3)
    assertEquals(chicken.bonus(roboBall), 3)
  }

  test("Chickens can't combat with other WildUnits") {
    intercept[Exception] {
      chicken.handleVictoryWildUnit(seagull)
      chicken.handleVictoryWildUnit(roboBall)
    }
  }

  test("Chicken victories' handler must only work in Combat Status") {
    // Initially, chickens aren't in combat status.
    intercept[Exception] {
      // Obs: Here, the character won, and the chicken lost.
      chicken.handleVictory(character)
    }
  }

  test("Chicken must handle correctly victories in combat") {
    // We set a quantity of stars for each entity.
    character.stars_(100)
    chicken.stars_(50)
    // Chicken must be in combat
    chicken.inCombat_(true)

    character.startGame()
    character.playTurn()
    character.rollDice()
    character.stopMovement()
    // From now, character is also in combat.

    val previousPlayerStars = character.stars
    // This chicken will receive the half of the player's stars
    val halfPlayerStars = previousPlayerStars / 2
    val previousChickenStars = chicken.stars

    chicken.handleVictory(character)
    assertEquals(previousPlayerStars - halfPlayerStars, character.stars)
    assertEquals(previousChickenStars + halfPlayerStars, chicken.stars)
    // Now, player is in KO & recovery status, because they lost.
    assertEquals(character.isKO, true)
    assertEquals(character.inRecovery(), true)
  }

  test("Chicken must correctly response to an attack") {
    // Default stars for this player
    character.stars_(100)

    // We "kill" this chicken
    chicken.currentHitPoints_(0)
    // Every WildUnit has bonus stars that they give when they lose.
    // We retrieve them for the chicken.
    val bonusStars = chicken.bonusChicken(chicken)
    val previousPlayerStars = character.stars
    val previousPlayerWins = character.wins
    val chickenStars = chicken.stars

    character.startGame()
    character.playTurn()
    character.rollDice()
    character.stopMovement()
    // From now, the player is in combat

    /** Given that this chicken's HP is now 0, it means that
     * the chicken lost the combat. The result is:
     * Character won against a WildUnit. */
    chicken.attackResponse(character)

    assertEquals(character.stars, previousPlayerStars + bonusStars + chickenStars)
    assertEquals(character.wins, previousPlayerWins + 1)
    assertEquals(character.inCombat(), false)
  }

  test("Chicken must defend correctly") {
    chicken.currentHitPoints_(3)
    val previousChickenHp = chicken.currentHitPoints

    // We set rollAtk to 1 (minimum) to make sure the chicken won't die
    chicken.defend(character, 1)

    // The chicken will receive at most 1 of damage, so newHp must be less
    assert(chicken.currentHitPoints < previousChickenHp)
  }

  test("Chicken must evade correctly") {
    val previousChickenHp = chicken.currentHitPoints

    character.startGame()
    character.playTurn()
    character.rollDice()
    character.stopMovement()
    // From now, the player is in combat.

    chicken.evade(character, 1)
    // In best case scenario, the chicken won't receive damage.
    assert(previousChickenHp >= chicken.currentHitPoints)

    // With maximum roll, we ensure that the chicken will receive damage.
    chicken.evade(character, 6)
    assert(previousChickenHp > chicken.currentHitPoints)
  }

  test("If either a Chicken or an opponent isn't in combat, they can't attack") {
    val previousChickenHp = chicken.currentHitPoints
    chicken.inCombat_(true)
    // Character's default combat status is false
    character.attack(chicken)
    assertEquals(previousChickenHp, chicken.currentHitPoints)

    character.startGame()
    character.playTurn()
    character.rollDice()
    character.stopMovement()
    // From now, character combat status is true
    chicken.inCombat_(false)
    character.attack(chicken)
    assertEquals(previousChickenHp, chicken.currentHitPoints)
  }

  test("A player can't win to a WildUnit if not in combat") {
    intercept[Exception] {
      character.handleVictory(chicken)
    }
  }
}


