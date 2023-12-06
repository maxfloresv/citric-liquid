package cl.uchile.dcc.citric
package model.state

/** Represents the End Game state, where the game decides the winner.
 *
 * @param context The current controller for this state.
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */

class EndGame(context: GameController) extends GameState(context) {
  this.inEndGame = true
}
