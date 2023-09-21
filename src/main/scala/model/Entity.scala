package cl.uchile.dcc.citric
package model

trait Entity {
  /** Whether the entity is controllable by the user or not
   *
   * In the context of a game, there are multiple entities, some of them
   * are controllable, and some of them are not.
   *
   * e. g. WildUnits aren't controllable but Characters are.
   *
   * @return True or False indicating if the entity is controllable.
   */
  val controllable: Boolean

  /** Indicates the maximum quantity of Hit Points given an entity
   *
   * @return The maximum quantity of Hit Points that an entity has.
   */
  val maxHitPoints: Int

  /** Indicates Current Hit Points of a given entity
   *
   * In a game, the Hit Points vary depending on combats.
   * In real time hit points are saved on this variable.
   *
   * @return Current Hit Points of an entity
   */

  var currentHitPoints: Int

  /**
   *
   *
   *
   *
   */
  val atkPoints: Int

  val defPoints: Int

  val evaPoints: Int

  var isKO: Boolean

  var stars: Int

  var currentPanel: Panel
}
