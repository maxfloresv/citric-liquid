package cl.uchile.dcc.citric
package model.state

class PlayerTurn extends State {
  this.inPlayerTurn = true
  override def rollDice(): Unit = this.setState(new Moving())
}
