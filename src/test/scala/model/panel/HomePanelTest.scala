package cl.uchile.dcc.citric
package model.panel

import cl.uchile.dcc.citric.model.entity.PlayerCharacter
import cl.uchile.dcc.citric.model.norma.NormaLvl1
import cl.uchile.dcc.citric.model.objective.Stars
import cl.uchile.dcc.citric.model.panel.HomePanel
import cl.uchile.dcc.citric.model.state.GameController

import scala.util.Random

class HomePanelTest extends munit.FunSuite {
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val ctx: GameController = new GameController()

  private var character: PlayerCharacter = _
  private var homePanel: HomePanel = _

  override def beforeEach(context: BeforeEach): Unit = {
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      ctx
    )
    homePanel = new HomePanel(character)
  }

  /** We know that the owner is the dummy player created */
  test("Getter for Panel owner must work correctly") {
    // We are assuming that two players can't have same username
    assertEquals(homePanel.owner.name, character.name)
  }

  /** When falling into a Home Panel, HP increases 1 */
  test("Home Panel effect must apply correctly") {
    val previousHp = character.currentHitPoints
    homePanel.apply(character)
    // HP is always increased by 1
    assert(character.currentHitPoints == previousHp + 1)
  }

  test("Home Panel norma check must work correctly") {
    character.objective_(new Stars())
    homePanel.normaCheck(character)
    // The player doesn't meet the criteria
    assert(character.norma.isInstanceOf[NormaLvl1])
  }
}
