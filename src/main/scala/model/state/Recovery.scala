package cl.uchile.dcc.citric
package model.state

class Recovery extends State {
  this.inRecovery = true
  override def insufficientRoll(): Unit = this.setState(new Chapter())

  override def sufficientRoll(): Unit = this.setState(new PlayerTurn())
}
