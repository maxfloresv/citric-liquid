package cl.uchile.dcc.citric
package model.state

import model.entity.PlayerCharacter

import cl.uchile.dcc.citric.exceptions.InvalidTransitionException

/** Represents the head of States. Here, we define all the possible game states.
 *
 * @param context The current controller for this state.
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class GameState protected(val context: GameController) {
  /** The player associated to this State */
  protected var player: PlayerCharacter = _

  /** Whether this entity is in pre-game status */
  protected[model] var inPreGame: Boolean = false

  /** Whether this entity is in chapter status */
  protected[model] var inChapter: Boolean = false

  /** Whether this entity is in combat status */
  protected[model] var inCombat: Boolean = false

  /** Whether this entity is moving through panels or not */
  protected[model] var inMoving: Boolean = false

  /** Whether this entity is in recovery status or not */
  protected[model] var inRecovery: Boolean = false

  /** Whether this entity is waiting for a response in attack */
  protected[model] var inWait: Boolean = false

  /** Whether the player is in its turn or not. */
  protected[model] var inPlayerTurn: Boolean = false

  /** Whether the game ended or not. */
  protected[model] var inEndGame: Boolean = false

  /** Whether the player landed on a panel or not. */
  protected[model] var inLandingPanel: Boolean = false

  /** Triggers if the status provided is invalid */
  private def error(): Unit = {
    throw new InvalidTransitionException("Invalid state")
  }

  /** Triggered when a player lose in combat. */
  def recoveryCombat(): Unit = this.error()

  /** Triggered when a player has to decide a path */
  def choosePath(): Unit = this.error()

  /** Triggered when a player exit movement status. It can be
   * whether: 1) stop in their Home Panel or 2) Run out of movements */
  def stopMovement(): Unit = this.error()

  /** Triggered when a player ran out of movement in the table */
  def outOfMovements(): Unit = this.error()

  /** Triggered when a combat ends */
  def endCombat(): Unit = this.error()

  /** Triggered when a player rolled a dice. */
  def rollDice(): Unit = this.error()

  /** Triggered when a player got a sufficient roll in recovery state. */
  def sufficientRoll(): Unit = this.error()

  /** Triggered when a player didn't get a sufficient roll in recovery state. */
  def insufficientRoll(): Unit = this.error()

  /** Triggered when a player reaches norma 6 */
  def normaSixReached(): Unit = this.error()

  /** Triggered when a new chapter starts */
  def newChapter(): Unit = this.error()

  /** Triggered when a player enters KO status */
  def isKO(): Unit = this.error()

  /** Triggered when a player has to play its turn. */
  def playTurn(): Unit = this.error()

  /** Triggered when a player has to attack. */
  def attack(): Unit = this.error()

  /** Triggered when an entity has to evade. */
  def evade(): Unit = this.error()

  /** Triggered when an entity has to defend. */
  def defend(): Unit = this.error()

  /** Triggered when a panel does some effect on a player. */
  def doEffect(): Unit = this.error()

  /** Triggered when the game starts. */
  def startGame(): Unit = this.error()

  /** Does an specific/state dependent action when reaching a state */
  def doAction(): Unit = { /** Do nothing */ }

  /** Sets a new state for this player.
   *
   * @param state The new state to be set.
   */
  protected def setState(state: GameState): Unit = player.setState(state)

  /** Sets a new entity for this state.
   *
   * @param sPlayer The player associated to this state.
   */
  protected[model] def setEntity(sPlayer: PlayerCharacter): Unit = {
    player = sPlayer
  }
}
