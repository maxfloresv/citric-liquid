package cl.uchile.dcc.citric
package model.panel

import cl.uchile.dcc.citric.model.entity.{PlayerCharacter, WildUnit}
import cl.uchile.dcc.citric.model.panel.EncounterPanel

import scala.util.Random

class EncounterPanelTest extends munit.FunSuite {
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val randomNumberGenerator: Random = new Random(11)

  private var character: PlayerCharacter = _
  private var encounterPanel: EncounterPanel = _

  override def beforeEach(context: BeforeEach): Unit = {
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      randomNumberGenerator
    )
    encounterPanel = new EncounterPanel()
  }

  /** When falling into a Encounter Panel, combat status is changed */
  test("Encounter Panel effect must apply correctly") {
    val previousCombat = character.inCombat
    encounterPanel.apply(character)
    // Bonus applied is always greater than 0.
    assert(previousCombat == !character.inCombat)
  }

  test("WildUnit getter/setter should work correctly") {
    encounterPanel.wildUnit_()
    val unit: WildUnit = encounterPanel.wildUnit
    assert(unit.isInstanceOf[WildUnit])
  }
}
