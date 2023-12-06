package cl.uchile.dcc.citric
package model.state

/** Represents the Combat State, where a combat takes place in the board.
 *
 * @param context The current controller for this state.
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class Combat(context: GameController) extends GameState(context) {
  this.inCombat = true

  override def endCombat(): Unit = {
    context._state = new LandingPanel(context)
    this.setState(new LandingPanel(context))
  }

  override def attack(): Unit = {
    context._state = new Wait(context)
    this.setState(new Wait(context))
  }

  override def recoveryCombat(): Unit = {
    context._state = new Recovery(context)
    this.setState(new Recovery(context))
  }
}
