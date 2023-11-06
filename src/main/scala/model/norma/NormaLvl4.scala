package cl.uchile.dcc.citric
package model.norma

/** Describes Norma level 4.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class NormaLvl4 extends AbstractNorma {
  val normaLevel: Int = 4
  val victoriesNeeded: Int = 10
  val starsNeeded: Int = 120
  val nextNorma: Norma = new NormaLvl5()
}
