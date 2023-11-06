package cl.uchile.dcc.citric
package model.norma

/** Describes Norma level 3.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class NormaLvl3 extends AbstractNorma {
  val normaLevel: Int = 3
  val victoriesNeeded: Int = 6
  val starsNeeded: Int = 70
  val nextNorma: Norma = new NormaLvl4()
}
