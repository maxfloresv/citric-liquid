package cl.uchile.dcc.citric
package model.panel

import model.entity.PlayerCharacter

/** Represents a specific single cell on a board, known as DropPanel.
 *
 * This panel take stars from the player when they fall.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class DropPanel extends AbstractPanel {
  /** Update the stars of a player given that they fell into a
   * Drop Panel. It takes roll * Norma from player's stars.
   *
   * @param player The player affected.
   */
  protected def apply(player: PlayerCharacter): Unit = {
    val roll: Int = player.rollDice()
    val taken: Int = roll * player.norma
    player.stars_(player.stars - taken)
  }
}
