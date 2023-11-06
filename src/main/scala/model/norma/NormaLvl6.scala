package cl.uchile.dcc.citric
package model.norma

/** Describes Norma level 6.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class NormaLvl6 extends AbstractNorma {
  val normaLevel: Int = 6
  /** This is the last norma. The requirements doesn't change. */
  val victoriesNeeded: Int = 14
  val starsNeeded: Int = 200
  val nextNorma: Norma = null
}
