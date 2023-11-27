package cl.uchile.dcc.citric
package model.state

import model.entity.PlayerCharacter

import cl.uchile.dcc.citric.exceptions.InvalidTransitionException

class State {
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

  protected[model] var inPlayerTurn: Boolean = false

  protected[model] var inEndGame: Boolean = false

  protected[model] var inLandingPanel: Boolean = false

  /** Triggers if the status provided is invalid */
  private def error(): Unit = {
    throw new InvalidTransitionException("Invalid state")
  }

  /** Triggered when a player has to decide a path */
  def choosePath(): Unit = this.error()

  /** Triggered when a player exit movement status. It can be
   * whether: 1) stop in their Home Panel or 2) Run out of movements */
  def stopMovement(): Unit = this.error()

  /** Triggered when a player ran out of movement in the table */
  def outOfMovements(): Unit = this.error()

  /** Triggered when a combat ends */
  def endCombat(): Unit = this.error()

  def rollDice(): Unit = this.error()

  def sufficientRoll(): Unit = this.error()

  def insufficientRoll(): Unit = this.error()

  def normaSixReached(): Unit = this.error()

  def newChapter(): Unit = this.error()

  def isKO(): Unit = this.error()

  def playTurn(): Unit = this.error()

  def attack(): Unit = this.error()

  def evade(): Unit = this.error()

  def defend(): Unit = this.error()

  def doEffect(): Unit = this.error()

  def startGame(): Unit = this.error()

  protected def setState(state: State): Unit = player.setState(state)

  protected[model] def setEntity(sPlayer: PlayerCharacter): Unit = {
    player = sPlayer
  }
}
