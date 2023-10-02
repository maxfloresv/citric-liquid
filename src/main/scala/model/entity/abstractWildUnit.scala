package cl.uchile.dcc.citric
package model.entity

import model.panel.Panel

/** Represents common parameters between WildUnits
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
abstract class abstractWildUnit extends Entity {
  /** WildUnits aren't controllable */
  val controllable: Boolean = false

  /** maxHitPoints are 3 for all WildUnits */
  val maxHitPoints: Int = 3

  /** Updates the initial hit points to be the maximum possible */
  setCurrentHitPoints(maxHitPoints)

  /** Initially, WildUnits aren't in combat */
  setCombatStatus(false)
}
