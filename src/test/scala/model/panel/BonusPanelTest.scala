package cl.uchile.dcc.citric
package model.panel

import model.entity.PlayerCharacter
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class BonusPanelTest extends munit.FunSuite {
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val randomNumberGenerator: Random = new Random(11)

  private var character: PlayerCharacter = _
  private var bonusPanel: BonusPanel = _
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
    bonusPanel = new BonusPanel()
    dropPanel = new DropPanel()
  }

  /** When falling into a Bonus Panel, stars must increase */
  test("Bonus Panel effect must apply correctly") {
    val previousStars = character.stars
    bonusPanel.apply(character)
    // Bonus applied is always greater than 0.
    assert(previousStars < character.stars)
  }

  test("ArrayBuffer copy must work correctly") {
    bonusPanel.addCharacter(character)
    assertEquals(bonusPanel.characters, bonusPanel._characters)
    bonusPanel.addNextPanel(dropPanel)
    assertEquals(bonusPanel.nextPanels, bonusPanel._nextPanels)
  }

  test("Player must be added only once") {
    bonusPanel.addCharacter(character)
    val copy: ArrayBuffer[PlayerCharacter] = bonusPanel.characters.clone()
    // Character "testPlayer" was already added before
    bonusPanel.addCharacter(character)
    // Array mustn't change because "testPlayer" is already in it
    assertEquals(bonusPanel.characters, copy)
  }

  test("Player remover must work appropiately") {
    bonusPanel.addCharacter(character)
    bonusPanel.removeCharacter(character)
    val empty = new ArrayBuffer[PlayerCharacter]()
    assertEquals(bonusPanel.characters, empty)
  }

  test("Panel adder/remover should work correctly") {
    bonusPanel.addNextPanel(dropPanel)
    val nextPanels = new ArrayBuffer[Panel]()
    nextPanels += dropPanel
    assertEquals(bonusPanel.nextPanels, nextPanels)

    bonusPanel.removeNextPanel(dropPanel)
    val empty = new ArrayBuffer[Panel]()
    assertEquals(bonusPanel.nextPanels, empty)
  }
}
