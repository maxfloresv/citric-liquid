package cl.uchile.dcc.citric
package model.norma

/** Describes Norma level 5.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class NormaLvl5 extends AbstractNorma {
  val normaLevel: Int = 5
  val victoriesNeeded: Int = 14
  val starsNeeded: Int = 200
  val nextNorma: Norma = new NormaLvl6()
}
