package cl.uchile.dcc.citric
package model.norma

import model.entity.PlayerCharacter

import cl.uchile.dcc.citric.model.objective.Objective

/** Represents common functionalities and methods between normas.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
abstract class AbstractNorma extends Norma {
  protected[model] def normaCheckStars(player: PlayerCharacter): Unit = {
    val norma: Norma = player.norma
    if (player.stars > norma.starsNeeded) {
      player.normaClear(norma.nextNorma)
    }
  }

  protected[model] def normaCheckWins(player: PlayerCharacter): Unit = {
    val norma: Norma = player.norma
    if (player.wins > norma.victoriesNeeded) {
      player.normaClear(norma.nextNorma)
    }
  }
}
