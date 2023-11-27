package cl.uchile.dcc.citric
package model.state

class PreGame extends State {
  this.inPreGame = true
  override def startGame(): Unit = this.setState(new Chapter())
}
