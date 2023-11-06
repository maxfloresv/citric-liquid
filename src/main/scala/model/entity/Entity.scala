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
  def controllable: Boolean

  /** Indicates the maximum quantity of Hit Points for an entity */
  protected val _maxHitPoints: Int

  /** Retrieves the maximum number of hit points that an entity has.
   *
   * @return The maximum hit points of an entity
   */
  def maxHitPoints: Int

  /** Indicates Current Hit Points of a given entity
   *
   * In a game, the Hit Points vary depending on combats.
   * In real time hit points are saved on this variable.
   */
  protected var _currentHitPoints: Int = _

  /** Retrieves the current hit points for an entity */
  def currentHitPoints: Int

  /** Changes the current hit points of this entity.
   *
   * @param hitPoints Hit Points to be set.
   */
  def currentHitPoints_(hitPoints: Int): Unit

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
  def atkPoints: Int

  /** Getter of defense points.
   *
   * @return Defense Points for this entity.
   */
  def defPoints: Int

  /** Getter of evasion points.
   *
   * @return Evasion Points for this entity.
   */
  def evaPoints: Int

  /** Every entity have stars that change in combats. */
  protected var _stars: Int = _

  /** Getter of stars for an entity.
   *
   * @return Stars for this entity.
   */
  def stars: Int

  /** Changes the current stars for this entity.
   *
   * @param newStars New stars to be set.
   */
  def stars_(newStars: Int): Unit

  /** Describes the current panel of the entity in the game.
   * Initial panel is unknown */
  protected var _currentPanel: Panel = _

  /** Retrieves the current panel for this entity
   *
   * @return Current panel for this entity.
   */
  def currentPanel: Panel

  /** Changes current panel for this entity.
   *
   * @param panel New panel to be set.
   */
  def currentPanel_(panel: Panel): Unit

  /** Combats can take place in this game. We must save whether
   * if an entity is in combat or not. */
  protected var _inCombat: Boolean = _

  /** Retrieves the current status of combat for this entity.
   *
   * @return True or False if this entity is in combat.
   */
  def inCombat: Boolean

  /** Changes current status of combat for this entity.
   *
   * @param status New status to be set.
   */
  def inCombat_(status: Boolean): Unit

  /** Performs an attack in a combat.
   *
   * @param entity The entity to attack.
   */
  def attack(entity: Entity): Unit

  /** Defends this entity from an external attack.
   *
   * @param entity The entity that emitted the attack.
   */
  def defend(entity: Entity, rollAtk: Int): Unit

  /** Allows this entity to evade external attacks.
   *
   * @param entity The entity that emitted the attack.
   */
  def evade(entity: Entity, rollAtk: Int): Unit

  /** Generates a random number that can be useful in multiple
   * situations, like rolling a dice with a arbitrary number of faces.
   *
   * @param n The max number to be generated. Range is {1, ..., n}
   * @return An integer indicating the random number.
   */
  def generateRandomInt(n: Int): Int

  /** Handles victory for an entity in a combat.
   *
   * @param entity The entity that won the combat.
   */
  protected[model] def handleVictory(entity: Entity): Unit

  /** Handles victory for a player character in a combat.
   *
   * @param player The player that won the combat.
   */
  protected[model] def handleVictoryPlayer(player: PlayerCharacter): Unit

  /** Handles victory for a WildUnit in a Player-WildUnit combat.
   *
   * @param wildUnit The WildUnit that won this combat.
   */
  protected[model] def handleVictoryWildUnit(wildUnit: WildUnit): Unit
}
