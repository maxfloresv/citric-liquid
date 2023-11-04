package cl.uchile.dcc.citric
package model.panel

import model.entity.PlayerCharacter

/** Represents a specific single cell on a board, known as NeutralPanel.
 *
 * This panel doesn't make any effect on the game.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class NeutralPanel extends AbstractPanel {
  /** Applies no effect to the player.
   *
   * @param player The player affected.
   */
  def apply(player: PlayerCharacter): Unit = {}
}
