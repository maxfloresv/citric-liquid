package cl.uchile.dcc.citric
package model.objective

import cl.uchile.dcc.citric.model.entity.PlayerCharacter

class Stars extends Objective {
  def normaCheck(player: PlayerCharacter): Unit = {
    val norma = player.norma
    norma.normaCheckStars(player)
  }
}
