package cl.uchile.dcc.citric
package model.objective

import cl.uchile.dcc.citric.model.entity.PlayerCharacter

/** Represents an objective, necessary to be able to compare criterias in norma check.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
trait Objective {
  /** Does a Norma Check for the current Norma through the objective.
   *
   * @param player The player involved in this process.
   */
  protected[model] def normaCheck(player: PlayerCharacter): Unit
}
