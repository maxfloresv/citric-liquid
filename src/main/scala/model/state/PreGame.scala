package cl.uchile.dcc.citric
package model.state

import model.state

/** Represents the Pre Game state, where the game don't start yet.
 *
 * @param context The current controller for this state.
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class PreGame(context: GameController) extends GameState(context) {
  this.inPreGame = true
  override def startGame(): Unit = {
    context._state = new Chapter(context)
    this.setState(new Chapter(context))
  }
}
