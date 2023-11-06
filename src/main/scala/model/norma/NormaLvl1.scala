package cl.uchile.dcc.citric
package model.norma

import model.entity.PlayerCharacter

/** Describes Norma level 1.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class NormaLvl1 extends AbstractNorma {
  val normaLevel: Int = 1
  /** This is, by default, the initial norma of all players */
  val victoriesNeeded: Int = 1
  val starsNeeded: Int = 10
  val nextNorma: Norma = new NormaLvl2()
}
