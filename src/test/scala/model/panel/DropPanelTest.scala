package cl.uchile.dcc.citric
package model.panel

import model.entity.PlayerCharacter

import cl.uchile.dcc.citric.model.panel.DropPanel

import scala.util.Random

class DropPanelTest extends munit.FunSuite {
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val randomNumberGenerator: Random = new Random(11)

  private var character: PlayerCharacter = _
  private var dropPanel: DropPanel = _

  override def beforeEach(context: BeforeEach): Unit = {
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      randomNumberGenerator
    )
    dropPanel = new DropPanel()
  }

  /** When falling into a Drop Panel, stars must decrease */
  test("Drop Panel effect must apply correctly") {
    val previousStars = character.stars
    dropPanel.apply(character)
    // Stars taken are always greater than 0.
    assert(previousStars == 0 || previousStars > character.stars)
  }
}
