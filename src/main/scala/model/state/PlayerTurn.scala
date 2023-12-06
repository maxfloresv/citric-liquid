package cl.uchile.dcc.citric
package model.state

/** Represents the Player Turn state, where the player has to roll a dice.
 *
 * @param context The current controller for this state.
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class PlayerTurn(context: GameController) extends GameState(context) {
  this.inPlayerTurn = true
  override def rollDice(): Unit = {
    context._state = new Moving(context)
    this.setState(new Moving(context))
  }

  override def doAction(): Unit = {
    // Every new player turn, we sum this count to its stars.
    player.stars_(player.stars + context.chapters / 5 + 1)
  }
}
