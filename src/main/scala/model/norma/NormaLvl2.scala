package cl.uchile.dcc.citric
package model.norma

/** Describes Norma level 2.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class NormaLvl2 extends AbstractNorma {
  val normaLevel: Int = 2
  val victoriesNeeded: Int = 3
  val starsNeeded: Int = 30
  val nextNorma: Norma = new NormaLvl3()
}
