package cl.uchile.dcc.citric
package model.norma

import model.entity.PlayerCharacter

/** Norma is the level system of the game. You can level up by completing
 * objectives such as victories or stars.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
trait Norma {
  /** Identifies the Norma level to associate it with objectives */
  protected val normaLevel: Int
  /** How many victories are needed to surpass this Norma level */
  protected val victoriesNeeded: Int
  /** How many stars are needed to surpass this Norma level */
  protected val starsNeeded: Int

  /** When the player falls into a Home Panel (or pass if it's their own)
   *  the game internally checks if they meet the objectives to level up.
   *  This is called "Norma Check".
   *
   *  This function updates the norma level of the player.
   *
   * @param character The character involved in this Norma Check.
   * @return True or False indicating if they met the requirements.
   */
  protected def normaCheck(character: PlayerCharacter): Boolean
}
