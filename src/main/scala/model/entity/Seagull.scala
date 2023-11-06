package cl.uchile.dcc.citric
package model.entity

/** Represents a specific WildUnit, known as Seagull.
 *
 * Their stats are described below. This character isn't controllable.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class Seagull extends AbstractWildUnit {
  val _atkPoints: Int = 1
  val _defPoints: Int = -1
  val _evaPoints: Int = -1

  def bonus(wildUnit: WildUnit): Int = wildUnit.bonusSeagull(this)
}
