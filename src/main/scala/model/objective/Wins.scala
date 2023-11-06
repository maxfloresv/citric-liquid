package cl.uchile.dcc.citric
package model.objective

import cl.uchile.dcc.citric.model.entity.PlayerCharacter

class Wins extends Objective {
  def normaCheck(player: PlayerCharacter): Unit = {
    val norma = player.norma
    norma.normaCheckWins(player)
  }
}
