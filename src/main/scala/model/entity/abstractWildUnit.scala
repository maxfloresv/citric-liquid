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

  /** It stars with maxHitPoints */
  var currentHitPoints: Int = maxHitPoints;

  /** All WildUnits start with 0 stars */
  val stars: Int = 0

  /** Their initial panel is unknown */
  val currentPanel: Panel = null

  /** Initially, WildUnits aren't in combat */
  var inCombat: Boolean = false
}
