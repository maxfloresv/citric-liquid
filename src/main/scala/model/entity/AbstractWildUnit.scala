package cl.uchile.dcc.citric
package model.entity

/** Represents common parameters between WildUnits
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
abstract class AbstractWildUnit extends AbstractUnit with WildUnit {
  /** Combats can take place in this game. We must save whether
   * if an entity is in combat or not. */
  protected var _inCombat: Boolean = false

  /** Retrieves the current status of combat for this entity.
   *
   * @return True or False if this entity is in combat.
   */
  override protected[model] def inCombat(): Boolean = _inCombat

  /** Changes current status of combat for this entity.
   *
   * @param status New status to be set.
   */
  protected[model] def inCombat_(status: Boolean): Unit = {
    _inCombat = status
  }

  /** WildUnits aren't controllable */
  val _controllable: Boolean = false

  /** maxHitPoints are 3 for all WildUnits */
  val _maxHitPoints: Int = 3

  /** Updates the initial hit points to be the maximum possible */
  currentHitPoints_(_maxHitPoints)

  /** A Chicken gives 3 bonus stars. */
  def bonusChicken(chicken: Chicken): Int = 3
  /** A RoboBall gives 2 bonus stars. */
  def bonusRoboBall(roboBall: RoboBall): Int = 2
  /** A Seagull gives 2 bonus stars. */
  def bonusSeagull(seagull: Seagull): Int = 2

  protected[model] def handleVictory(entity: Entity): Unit = {
    entity.handleVictoryWildUnit(this)
  }

  /** This is the case WildUnit vs. WildUnit. This mustn't occur. */
  protected[model] def handleVictoryWildUnit(wildUnit: WildUnit): Unit = {
    throw new Exception("WildUnits can't combat between themselves.")
  }

  protected[model] def handleVictoryPlayer(player: PlayerCharacter): Unit = {
    val bonusStars = bonus(this)
    player.stars_(player.stars + stars + bonusStars)
    player.wins_(player.wins + 1)
  }
}
