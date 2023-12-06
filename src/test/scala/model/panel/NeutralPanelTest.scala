package cl.uchile.dcc.citric
package model.panel

import cl.uchile.dcc.citric.model.entity.PlayerCharacter
import cl.uchile.dcc.citric.model.panel.NeutralPanel
import cl.uchile.dcc.citric.model.state.GameController

import scala.util.Random

class NeutralPanelTest extends munit.FunSuite {
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val ctx: GameController = new GameController()

  private var character: PlayerCharacter = _
  private var neutralPanel: NeutralPanel = _

  override def beforeEach(context: BeforeEach): Unit = {
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      ctx
    )
    neutralPanel = new NeutralPanel()
  }

  test("Neutral Panel effect must apply correctly") {
    // Neutral Panel doesn't do anything.
    neutralPanel.apply(character)
  }
}
