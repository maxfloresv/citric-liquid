package cl.uchile.dcc.citric
package model.state

class LandingPanel extends State {
  this.inLandingPanel = true
  override def doEffect(): Unit = this.setState(new Chapter())
}
