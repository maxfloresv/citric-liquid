package cl.uchile.dcc.citric
package model.state

/** Represents the Moving state, where the player is moving on the board.
 *
 * @param context The current controller for this state.
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class Moving(context: GameController) extends GameState(context) {
  this.inMoving = true
  override def stopMovement(): Unit = {
    context._state = new Combat(context)
    this.setState(new Combat(context))
  }

  override def outOfMovements(): Unit = {
    context._state = new Combat(context)
    this.setState(new Combat(context))
  }

  override def choosePath(): Unit = {
    context._state = new Moving(context)
    this.setState(new Moving(context))
  }
}
