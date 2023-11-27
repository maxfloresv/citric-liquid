package cl.uchile.dcc.citric
package model.state

class Wait extends State {
  this.inWait = true

  override def evade(): Unit = this.setState(new Combat())

  override def defend(): Unit = this.setState(new Combat())
}
