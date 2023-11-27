package cl.uchile.dcc.citric
package model.state

class Moving extends State {
  this.inMoving = true
  override def stopMovement(): Unit = this.setState(new Combat())

  override def outOfMovements(): Unit = this.setState(new Combat())

  override def choosePath(): Unit = this.setState(new Moving())
}
