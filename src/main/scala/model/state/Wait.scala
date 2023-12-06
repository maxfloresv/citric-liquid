package cl.uchile.dcc.citric
package model.state

/** Represents the Wait State, where the player is waiting for a response in attack.
 *
 * @param context The current controller for this state.
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class Wait(context: GameController) extends GameState(context) {
  this.inWait = true

  override def evade(): Unit = {
    context._state = new Combat(context)
    this.setState(new Combat(context))
  }

  override def defend(): Unit = {
    context._state = new Combat(context)
    this.setState(new Combat(context))
  }
}
