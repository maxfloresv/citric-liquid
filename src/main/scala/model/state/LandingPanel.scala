package cl.uchile.dcc.citric
package model.state

/** Represents the Landing Panel state, where a player lands into a panel.
 *
 * @param context The current controller for this state.
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class LandingPanel(context: GameController) extends GameState(context) {
  this.inLandingPanel = true
  override def doEffect(): Unit = {
    context._state = new Chapter(context)
    this.setState(new Chapter(context))
  }
}
