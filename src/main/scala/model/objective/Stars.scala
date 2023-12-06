package cl.uchile.dcc.citric
package model.objective

import model.entity.PlayerCharacter

/** Represents stars, an specific type of objective, which is a stat for the player.
 * Stars are won throughout the game.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class Stars extends Objective {
  def normaCheck(player: PlayerCharacter): Unit = {
    val norma = player.norma
    norma.normaCheckStars(player)
  }
}
