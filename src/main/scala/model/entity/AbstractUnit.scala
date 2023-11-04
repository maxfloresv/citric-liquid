package cl.uchile.dcc.citric
package model.entity

import model.panel.Panel

abstract class AbstractUnit extends Entity {
  /*
  def controllable: Boolean = _controllable

  def maxHitPoints: Int = _maxHitPoints

  def currentHitPoints: Int = _currentHitPoints

  def currentHitPoints_(hitPoints: Int): Unit = {
    _currentHitPoints = hitPoints
  }

  def atkPoints: Int = _atkPoints

  def defPoints: Int = _defPoints

  def evaPoints: Int = _evaPoints

  def stars: Int = _stars

  def stars_(newStars: Int): Unit = {
    _stars = newStars
  }

  def currentPanel: Panel = _currentPanel

  def currentPanel_(panel: Panel): Unit = {
    _currentPanel = panel
  }

  def inCombat: Boolean = _inCombat

  def inCombat_(status: Boolean): Unit = {
    _inCombat = status
  }*/

  /** Stars are 0 by default */
  protected var _stars = 0

  /** Initially, units aren't in combat. They
   * enter in combat iff they run into a Encounter Panel */
  protected var _inCombat: Boolean = false

  /** Initial panel is unknown */
  protected var _currentPanel: Panel = _
}
