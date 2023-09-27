package cl.uchile.dcc.citric
package model.entity

/** Represents a specific WildUnit, known as Chicken.
 *
 * Their stats are described below. This character isn't controllable.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class Chicken extends abstractWildUnit {
  val atkPoints: Int = -1
  val defPoints: Int = -1
  val evaPoints: Int = 1
}
