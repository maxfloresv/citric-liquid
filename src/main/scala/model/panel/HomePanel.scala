package cl.uchile.dcc.citric
package model.panel

import model.entity.PlayerCharacter

/** Represents a specific single cell on a board, known as HomePanel.
 *
 * Every player has a personal HomePanel. A owner of a HomePanel can
 * decide between stop their turn in the HomePanel (independent if more
 * movements are available) in which case the panel activates. If the player
 * doesn't own the HomePanel, then it will activate only if it moves exactly
 * to this panel when ending their turn.
 *
 * When active, the player will recover 1HP and Norma requirements will be check.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class HomePanel(_owner: PlayerCharacter) extends AbstractPanel {
  /** Retrieves who owns this Home Panel.
   *
   * @return Owner of this Home Panel.
   */
  def owner: PlayerCharacter = _owner

  /** Gives 1 HP to the current entity in this panel.
   *
   * This might be invoked when a player moves off this panel.
   *
   * @param player The player character to remove from this panel.
   */
  protected[model] def apply(player: PlayerCharacter): Unit = {
    player.currentHitPoints_(player.currentHitPoints + 1)
  }

  /** Checks the norma requirements comparing the criteria chosen by the player.
   *
   * @param player The player to be checked.
   */
  protected[model] def normaCheck(player: PlayerCharacter): Unit = {
    player.normaCheck()
  }
}