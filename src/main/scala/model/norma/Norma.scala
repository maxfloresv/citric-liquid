package cl.uchile.dcc.citric
package model.norma

import model.entity.PlayerCharacter

import cl.uchile.dcc.citric.model.objective.Objective

/** Norma is the level system of the game. You can level up by completing
 * objectives such as victories or stars.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
trait Norma {
  /** Identifies the Norma level to associate it with objectives */
  val normaLevel: Int
  /** How many victories are needed to surpass this Norma level */
  val victoriesNeeded: Int
  /** How many stars are needed to surpass this Norma level */
  val starsNeeded: Int

  /** Norma Check by the objective Stars.
   *
   * @param player The player which is in this process.
   */
  protected[model] def normaCheckStars(player: PlayerCharacter): Unit

  /** Norma Check by the objective Wins.
   *
   * @param player The player which is in this process.
   */
  protected[model] def normaCheckWins(player: PlayerCharacter): Unit

  /** Next Norma to each level */
  val nextNorma: Norma
}
