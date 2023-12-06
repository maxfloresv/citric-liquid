package cl.uchile.dcc.citric
package model.entity

/** Represents a WildUnit. WildUnits are entities that appear in specific
 * areas of the game, like encounter panels. They are not controllable.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
trait WildUnit extends Entity {
  /** Each WildUnit give a star bonus when they die. This bonus has
   * to be sum to the player's stars.
   *
   * @param wildUnit The WildUnit that will give the bonus.
   * @return An integer indicating the bonus given by this WildUnit.
   */
  def bonus(wildUnit: WildUnit): Int

  /** Each Chicken gives a bonus of stars when they die.
   *
   * @param chicken A Chicken WildUnit.
   * @return The bonus given by a Chicken.
   */
  def bonusChicken(chicken: Chicken): Int

  /** Each RoboBall gives a bonus of stars when they die.
   *
   * @param roboBall A RoboBall WildUnit.
   * @return The bonus given by a RoboBall.
   */
  def bonusRoboBall(roboBall: RoboBall): Int

  /** Each Seagull gives a bonus of stars when they die.
   *
   * @param seagull A Seagull WildUnit.
   * @return The bonus given by a Seagull.
   */
  def bonusSeagull(seagull: Seagull): Int
}
