package cl.uchile.dcc.citric
package model.panel

import model.entity.PlayerCharacter

/** Represents a specific single cell on a board, known as BonusPanel.
 *
 * This panel give stars to the player when they fall.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class BonusPanel extends AbstractPanel {
  /** Updates the stars of a player given that they fell into a
   * Bonus Panel.
   *
   * @param player The player affected.
   */
  protected def apply(player: PlayerCharacter): Unit = {
    val roll: Int = player.rollDice()
    val toGive = math.min(roll * player.norma, roll * 3)
    player.stars_(player.stars + toGive)
  }
}
