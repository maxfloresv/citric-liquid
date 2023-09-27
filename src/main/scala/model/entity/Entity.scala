package cl.uchile.dcc.citric
package model.entity

import cl.uchile.dcc.citric.model.panel.Panel

/** Represents an entity, which can be a Player or WildUnit (enemy)
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
trait Entity {
  /** Whether the entity is controllable by the user or not
   *
   * In the context of a game, there are multiple entities, some of them
   * are controllable, and some of them are not.
   *
   * e. g. WildUnits aren't controllable but Characters are.
   */
  val controllable: Boolean

  /** Indicates the maximum quantity of Hit Points given an entity */
  val maxHitPoints: Int

  /** Indicates Current Hit Points of a given entity
   *
   * In a game, the Hit Points vary depending on combats.
   * In real time hit points are saved on this variable.
   *
   */
  var currentHitPoints: Int

  /** Every entity has ATK, DEF and EVA points.
   *
   * ATK stands for attack. The hit points that they inflict in every attack.
   * DEF stands for defense. It's protection against attacks that affect the player.
   * EVA stands for evasion. It's the capacity of an entity to dodge attacks.
   */
  val atkPoints: Int
  val defPoints: Int
  val evaPoints: Int

  /** Every player have stars that change in combats */
  var stars: Int

  /** Describes the current panel of the entity in the game */
  var currentPanel: Panel

  var inCombat: Boolean
}
