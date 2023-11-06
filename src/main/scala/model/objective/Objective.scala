package cl.uchile.dcc.citric
package model.objective

import cl.uchile.dcc.citric.model.entity.PlayerCharacter

trait Objective {
  /** Does a Norma Check for the current Norma through the objective.
   *
   * @param player The player involved in this process.
   */
  protected[model] def normaCheck(player: PlayerCharacter): Unit
}
