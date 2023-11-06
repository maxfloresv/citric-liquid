package cl.uchile.dcc.citric
package model.entity

import model.panel.Panel

import scala.util.Random

abstract class AbstractUnit extends Entity {
  def controllable: Boolean = _controllable

  def maxHitPoints: Int = _maxHitPoints

  def currentHitPoints: Int = _currentHitPoints

  /** Hit Points can't be negative */
  def currentHitPoints_(hitPoints: Int): Unit = {
    _currentHitPoints = math.max(0, hitPoints)
  }

  def atkPoints: Int = _atkPoints

  def defPoints: Int = _defPoints

  def evaPoints: Int = _evaPoints

  def stars: Int = _stars

  def stars_(newStars: Int): Unit = {
    _stars = math.max(0, newStars)
  }

  def currentPanel: Panel = _currentPanel

  def currentPanel_(panel: Panel): Unit = {
    _currentPanel = panel
  }

  def inCombat: Boolean = _inCombat

  def inCombat_(status: Boolean): Unit = {
    _inCombat = status
  }

  /** Stars are 0 by default */
  stars_(0)

  /** Initially, units aren't in combat. They
   * enter in combat iff they run into a Encounter Panel */
  inCombat_(false)

  def generateRandomInt(n: Int): Int = {
    val randomNumberGenerator: Random = new Random()
    randomNumberGenerator.nextInt(n) + 1
  }

  /** Handles the attack response depending on this Unit's HP
   * after being attacked by an entity.
   *
   * @param entity The entity that emitted the attack.
   */
  protected[model] def attackResponse(entity: Entity): Unit = {
    if (currentHitPoints > 0) {
      attack(entity)
    } else {
      entity.handleVictory(this)
    }
    // When response is received, the combat ends.
    inCombat_(false)
    entity.inCombat_(false)
  }

  def attack(entity: Entity): Unit = {
    // Combat can't occur if one of the entities isn't in combat.
    if (!inCombat || !entity.inCombat) {
      return
    }

    val rollAtk: Int = generateRandomInt(6)
  }

  def defend(entity: Entity, rollAtk: Int): Unit = {
    val rollDef: Int = generateRandomInt(6)
    val totalAttack = rollAtk + entity.atkPoints
    val totalDefense = rollDef + defPoints
    val totalDamage: Int = math.max(1, totalAttack - totalDefense)
    currentHitPoints_(currentHitPoints - totalDamage)

    attackResponse(entity)
  }

  def evade(entity: Entity, rollAtk: Int): Unit = {
    val rollEva: Int = generateRandomInt(6)

    val totalDamage: Int = rollAtk + entity.atkPoints
    if (rollEva + evaPoints <= totalDamage) {
      currentHitPoints_(currentHitPoints - totalDamage)
    }

    attackResponse(entity)
  }
}