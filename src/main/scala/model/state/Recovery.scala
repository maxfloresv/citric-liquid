package cl.uchile.dcc.citric
package model.state

import model.state

/** Represents the Recovery State, when a player is defeated in a combat.
 *
 * @param context The current controller for this state.
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class Recovery(context: GameController) extends GameState(context) {
  this.inRecovery = true
  override def insufficientRoll(): Unit = {
    context._state = new Chapter(context)
    this.setState(new Chapter(context))
  }

  override def sufficientRoll(): Unit = {
    context._state = new PlayerTurn(context)
    this.setState(new PlayerTurn(context))
  }

  override def doAction(): Unit = {
    // If entered the recovery status, the player is also in KO
    player.isKO_(true)
  }
}
