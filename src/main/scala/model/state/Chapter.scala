package cl.uchile.dcc.citric
package model.state

class Chapter extends State {
  this.inChapter = true

  override def playTurn(): Unit = this.setState(new PlayerTurn())

  override def isKO(): Unit = this.setState(new Recovery())

  override def newChapter(): Unit = this.setState(new Chapter())

  override def normaSixReached(): Unit = this.setState(new EndGame())
}
