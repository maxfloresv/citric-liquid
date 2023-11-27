package cl.uchile.dcc.citric
package model.state

class Combat extends State {
  this.inCombat = true

  override def endCombat(): Unit = this.setState(new LandingPanel())

  override def attack(): Unit = this.setState(new Wait())
}
