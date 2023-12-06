package cl.uchile.dcc.citric
package model.state

import model.state

/** Represents a Chapter State for the completeness of the game.
 *
 * @param context The current controller for this state.
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class Chapter(context: GameController) extends GameState(context) {
  this.inChapter = true

  override def playTurn(): Unit = {
    context._state = new PlayerTurn(context)
    this.setState(new PlayerTurn(context))
  }

  override def isKO(): Unit = {
    context._state = new Recovery(context)
    this.setState(new Recovery(context))
  }

  override def newChapter(): Unit = {
    context._state = new Chapter(context)
    this.setState(new Chapter(context))
  }

  override def normaSixReached(): Unit = {
    context._state = new EndGame(context)
    this.setState(new EndGame(context))
  }

  override def doAction(): Unit = {
    context.chapters += 1
  }
}
