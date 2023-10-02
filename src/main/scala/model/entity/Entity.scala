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
  protected val controllable: Boolean

  /** Retrieves if an entity is controllable.
   *
   * @return Whether the entity is controllable or not.
   */
  protected def getControllable: Boolean = controllable

  /** Indicates the maximum quantity of Hit Points for an entity */
  val maxHitPoints: Int

  /** Retrieves the maximum number of hit points that an entity has.
   *
   * @return The maximum hit points of an entity
   */
  def getMaxHitPoints: Int = maxHitPoints

  /** Indicates Current Hit Points of a given entity
   *
   * In a game, the Hit Points vary depending on combats.
   * In real time hit points are saved on this variable.
   */
  private var currentHitPoints: Int = _

  /** Retrieves the current hit points for an entity.
   *
   * @return Hit Points of this entity
   */
  def getCurrentHitPoints: Int = currentHitPoints

  /** Changes the current hit points of this entity.
   *
   * @param hitPoints Hit Points to be set.
   */
  protected def setCurrentHitPoints(hitPoints: Int): Unit = {
    currentHitPoints = hitPoints
  }

  /** Every entity has ATK, DEF and EVA points.
   *
   * ATK stands for attack. The hit points that they inflict in every attack.
   * DEF stands for defense. It's protection against attacks that affect the player.
   * EVA stands for evasion. It's the capacity of an entity to dodge attacks.
   */
  val atkPoints: Int
  val defPoints: Int
  val evaPoints: Int

  /** Getter of attack points.
   *
   * @return Attack Points for this entity.
   */
  def getAtkPoints: Int = atkPoints

  /** Getter of defense points.
   *
   * @return Defense Points for this entity.
   */
  def getDefPoints: Int = defPoints

  /** Getter of evasion points.
   *
   * @return Evasion Points for this entity.
   */
  def getEvaPoints: Int = evaPoints

  /** Every entity have stars that change in combats. Default is 0. */
  private var stars: Int = 0

  /** Getter of stars for an entity.
   *
   * @return Stars for this entity.
   */
  def getStars: Int = stars

  /** Changes the current stars for this entity.
   *
   * @param newStars New stars to be set.
   */
  protected def setStars(newStars: Int): Unit = {
    stars = newStars
  }

  /** Describes the current panel of the entity in the game */
  private var currentPanel: Panel = _

  /** Retrieves the current panel for this entity
   *
   * @return Current panel for this entity.
   */
  def getCurrentPanel: Panel = currentPanel

  /** Changes current panel for this entity.
   *
   * @param panel New panel to be set.
   */
  protected def setCurrentPanel(panel: Panel): Unit = {
    currentPanel = panel
  }

  /** Combats can take place in this game. We must save whether
   * if an entity is in combat or not. */
  private var inCombat: Boolean = _

  /** Retrieves the current status of combat for this entity.
   *
   * @return True or False if this entity is in combat.
   */
  def getCombatStatus: Boolean = inCombat

  /** Changes current status of combat for this entity.
   *
   * @param status New status to be set.
   */
  protected def setCombatStatus(status: Boolean): Unit = {
    inCombat = status
  }
}
