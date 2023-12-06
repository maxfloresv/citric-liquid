package cl.uchile.dcc.citric
package model.entity

import scala.util.Random
import model.entity.{Chicken, PlayerCharacter, RoboBall, Seagull}

import cl.uchile.dcc.citric.model.panel.{EncounterPanel, HomePanel, Panel}
import cl.uchile.dcc.citric.model.state.GameController

class EntitiesTest extends munit.FunSuite {
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val ctx: GameController = new GameController()

  private var character: PlayerCharacter = _
  private var chicken: Chicken = _
  private var roboBall: RoboBall = _
  private var seagull: Seagull = _

  override def beforeEach(context: BeforeEach): Unit = {
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      ctx
    )
    chicken = new Chicken()
    roboBall = new RoboBall()
    seagull = new Seagull()
  }

  /** Remember: WildUnits aren't controllable */
  test("Entities must have correct controllable property") {
    assertEquals(character.controllable, true)
    assertEquals(chicken.controllable, false)
    assertEquals(roboBall.controllable, false)
    assertEquals(seagull.controllable, false)
  }

  /** maxHp for player is defined above. maxHp for each WU is 3. */
  test("Entities must have maxHp set correctly") {
    assertEquals(character.maxHitPoints, 10)
    assertEquals(chicken.maxHitPoints, 3)
    assertEquals(roboBall.maxHitPoints, 3)
    assertEquals(seagull.maxHitPoints, 3)
  }

  /** Initially, currentHp = maxHp */
  test("Entities must have initial currentHp set correctly") {
    assertEquals(character.currentHitPoints, 10)
    assertEquals(chicken.currentHitPoints, 3)
    assertEquals(roboBall.currentHitPoints, 3)
    assertEquals(seagull.currentHitPoints, 3)
  }

  test("Setter of currentHp must work correctly") {
    character.currentHitPoints_(5)
    assertEquals(character.currentHitPoints, 5)
    chicken.currentHitPoints_(1)
    assertEquals(chicken.currentHitPoints, 1)
    roboBall.currentHitPoints_(2)
    assertEquals(roboBall.currentHitPoints, 2)
    seagull.currentHitPoints_(0)
    assertEquals(seagull.currentHitPoints, 0)
  }

  /** Note that WildUnit's ATK, DEF and EVA stats are already tested
   * in ChickenTest, RoboBallTest and SeagullTest */
  test("Attack Points must be set correctly for each entity") {
    assertEquals(character.atkPoints, 1)
  }

  test("Defense Points must be set correctly for each entity") {
    assertEquals(character.defPoints, 1)
  }

  test("Evasion Points must be set correctly for each entity") {
    assertEquals(character.evaPoints, 1)
  }

  /** Default stars are 0 */
  test("Stars quantity must be correctly retrieved for each entity") {
    assertEquals(character.stars, 0)
    assertEquals(chicken.stars, 0)
    assertEquals(roboBall.stars, 0)
    assertEquals(seagull.stars, 0)
  }

  test("Setter for stars must work correctly") {
    character.stars_(10)
    assertEquals(character.stars, 10)
  }

  /** Initially, the panel for each entity is unknown */
  test("Initial panel of each entity must be set correctly") {
    assertEquals(character.currentPanel, null)
    assertEquals(chicken.currentPanel, null)
    assertEquals(roboBall.currentPanel, null)
    assertEquals(seagull.currentPanel, null)
  }

  /** WildUnits only spawn in Encounter Panels */
  test("Setter for panel must work correctly") {
    val characterPanel: Panel = new HomePanel(character)
    val wildPanel: Panel = new EncounterPanel()
    character.currentPanel_(characterPanel)
    assertEquals(character.currentPanel, characterPanel)
    chicken.currentPanel_(wildPanel)
    assertEquals(chicken.currentPanel, wildPanel)
  }

  /** Initially, none of the entities is in combat */
  test("Initial combat status must be set correctly") {
    assertEquals(character.inCombat(), false)
    assertEquals(chicken.inCombat(), false)
    assertEquals(roboBall.inCombat(), false)
    assertEquals(seagull.inCombat(), false)
  }

  test("Setter for combat status must work correctly") {
    character.startGame()
    character.playTurn()
    character.rollDice()
    character.stopMovement()
    assertEquals(character.inCombat(), true)
    chicken.inCombat_(true)
    assertEquals(chicken.inCombat(), true)
  }
}
