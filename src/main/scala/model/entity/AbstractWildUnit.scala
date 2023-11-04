package cl.uchile.dcc.citric
package model.entity

import model.panel.Panel

/** Represents common parameters between WildUnits
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
abstract class AbstractWildUnit extends AbstractUnit {
  /** WildUnits aren't controllable */
  val _controllable: Boolean = false

  /** maxHitPoints are 3 for all WildUnits */
  val _maxHitPoints: Int = 3

  /** Updates the initial hit points to be the maximum possible */
  protected var _currentHitPoints: Int = maxHitPoints
}
