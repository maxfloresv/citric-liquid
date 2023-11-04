package cl.uchile.dcc.citric
package model.entity

import cl.uchile.dcc.citric.model.panel.Panel

/** Represents an entity, which can be a Player or WildUnit (enemy)
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
trait Entity {
  /** In the context of a game, there are multiple entities, some of them
   * are controllable, and some of them are not.
   *
   * Example: WildUnits aren't controllable but Characters are.
   */
  protected val _controllable: Boolean

  /** Retrieves if an entity is controllable.
   *
   * @return Whether the entity is controllable or not.
   */
  def controllable: Boolean = _controllable

  /** Indicates the maximum quantity of Hit Points for an entity */
  protected val _maxHitPoints: Int

  /** Retrieves the maximum number of hit points that an entity has.
   *
   * @return The maximum hit points of an entity
   */
  def maxHitPoints: Int = _maxHitPoints

  /** Indicates Current Hit Points of a given entity
   *
   * In a game, the Hit Points vary depending on combats.
   * In real time hit points are saved on this variable.
   */
  private var _currentHitPoints: Int = _

  /** Retrieves the current hit points for an entity */
  def currentHitPoints: Int = _currentHitPoints

  /** Changes the current hit points of this entity.
   *
   * @param hitPoints Hit Points to be set.
   */
  def currentHitPoints_(hitPoints: Int): Unit = {
    _currentHitPoints = hitPoints
  }

  /** Every entity has ATK, DEF and EVA points.
   *
   * ATK stands for attack. The hit points that they inflict in every attack.
   * DEF stands for defense. It's protection against attacks that affect the player.
   * EVA stands for evasion. It's the capacity of an entity to dodge attacks.
   */
  protected val _atkPoints: Int
  protected val _defPoints: Int
  protected val _evaPoints: Int

  /** Getter of attack points.
   *
   * @return Attack Points for this entity.
   */
  def atkPoints: Int = _atkPoints

  /** Getter of defense points.
   *
   * @return Defense Points for this entity.
   */
  def defPoints: Int = _defPoints

  /** Getter of evasion points.
   *
   * @return Evasion Points for this entity.
   */
  def evaPoints: Int = _evaPoints

  /** Every entity have stars that change in combats. */
  private var _stars: Int = _

  /** Getter of stars for an entity.
   *
   * @return Stars for this entity.
   */
  def stars: Int = _stars

  /** Changes the current stars for this entity.
   *
   * @param newStars New stars to be set.
   */
  def stars_(newStars: Int): Unit = {
    _stars = newStars
  }

  /** Describes the current panel of the entity in the game */
  private var _currentPanel: Panel = _

  /** Retrieves the current panel for this entity
   *
   * @return Current panel for this entity.
   */
  def currentPanel: Panel = _currentPanel

  /** Changes current panel for this entity.
   *
   * @param panel New panel to be set.
   */
  def currentPanel_(panel: Panel): Unit = {
    _currentPanel = panel
  }

  /** Combats can take place in this game. We must save whether
   * if an entity is in combat or not. */
  private var _inCombat: Boolean = _

  /** Retrieves the current status of combat for this entity.
   *
   * @return True or False if this entity is in combat.
   */
  def inCombat: Boolean = _inCombat

  /** Changes current status of combat for this entity.
   *
   * @param status New status to be set.
   */
  def inCombat_(status: Boolean): Unit = {
    _inCombat = status
  }
}
