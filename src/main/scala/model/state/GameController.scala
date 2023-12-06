package cl.uchile.dcc.citric
package model.state

import model.entity.{PlayerCharacter}

import cl.uchile.dcc.citric.model.events.NormaClearEvent
import cl.uchile.dcc.citric.model.observer.{Observer, Subject}
import cl.uchile.dcc.citric.model.panel.Panel

/** Represents the Game Controller, where the game is setup.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class GameController extends Observer[NormaClearEvent] {
  // Initial state of the controller
  protected[state] var _state: GameState = new PreGame(this)

  def state(): GameState = _state

  // List of players active in the game
  private[model] var playerCharacters = List.empty[PlayerCharacter]
  // List of game panels
  private var panels = List.empty[Panel]
  // Current chapter. Defaults to 0 in PreGame.
  protected[state] var chapters: Int = 0

  /** Adds a new playerCharacter to the list of players
   *
   * @param name The name of this player.
   * @param maxHp The maximum hit points for this player.
   * @param attack The attack stats for this player.
   * @param defense The defense stats for this player.
   * @param evasion The evasion stats for this player.
   */
  def addPlayerCharacter(
    name: String, maxHp: Int, attack: Int, defense: Int, evasion: Int
  ): Unit = {
    // The player needs the context in order to use State pattern
    val character = new PlayerCharacter(
      name, maxHp, attack, defense, evasion, this
    )
    character.addObserver(this)
    playerCharacters = character :: playerCharacters
  }

  def startGame(playerCharacters: Seq[(String, Int, Int, Int, Int)]): Unit = {
    /** The game MUST have only 4 players */
    if (playerCharacters.size != 4)
      throw new Exception("The game can only start with 4 players.")

    // We add every initial player to the game.
    for ((name, maxHp, attack, defense, evasion) <- playerCharacters) {
      addPlayerCharacter(name, maxHp, attack, defense, evasion)
    }

    // Reset the state to the initial.
    _state = new PreGame(this)
  }

  override def update(
    observable: Subject[NormaClearEvent], event: NormaClearEvent
  ): Unit = {
    // If a player reaches norma lvl 6, the game ends.
    val player = event.player
    val name = player.name
    if (player.norma.normaLevel == 6) {
      println("Game ended! Some player reached norma lvl 6.")
      println("Congratulations, " + name)
      _state = new EndGame(this)
    }
  }
}
