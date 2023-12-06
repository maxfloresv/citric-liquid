package cl.uchile.dcc.citric
package model.state

class GameControllerTest extends munit.FunSuite {
  val name = "Max"
  val maxHp = 10
  val attack = 3
  val defense = 5
  val evasion = 4

  private var controller: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new GameController()
  }

  test("Add players to the game must work correctly") {
    controller.addPlayerCharacter(name, maxHp, attack, defense, evasion)
    assert(controller.playerCharacters.nonEmpty)
    assert(controller.playerCharacters.head.name == "Max")
  }

  test("Game can't start when there aren't 4 players") {
    val players: Seq[(String, Int, Int, Int, Int)] = Seq((name, maxHp, attack, defense, evasion))
    intercept[Exception] {
      controller.startGame(players)
    }
  }

  test("Game starts with 4 players") {
    // For simplicity, their stats are the same with Max
    val names: List[String] = List("Max", "Lady Gaga", "Jon Bellion", "Friday")
    var players: Seq[(String, Int, Int, Int, Int)] = Seq.empty

    for (i <- 0 to 3) {
      val tuple: (String, Int, Int, Int, Int) = (names(i), maxHp, attack, defense, evasion)
      players = tuple +: players
    }

    controller.startGame(players)
    // State is the initial one when starting game
    assert(controller.state.isInstanceOf[PreGame])
  }
}
