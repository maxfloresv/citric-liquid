package cl.uchile.dcc.citric
package model.objective

import cl.uchile.dcc.citric.model.entity.PlayerCharacter

/** Represents wins, an specific type of objective, which is a stat for the player.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class Wins extends Objective {
  def normaCheck(player: PlayerCharacter): Unit = {
    val norma = player.norma
    norma.normaCheckWins(player)
  }
}
