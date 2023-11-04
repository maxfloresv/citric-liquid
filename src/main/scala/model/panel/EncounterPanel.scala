package cl.uchile.dcc.citric
package model.panel

import model.entity.{Entity, PlayerCharacter}

/** Represents a specific single cell on a board, known as EncounterPanel.
 *
 * In this panel the combats between players and WildUnits take place.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class EncounterPanel extends AbstractPanel {
  /** WildUnit placed in this panel */
  private val wildUnit: Entity = null

  /** Updates if an entity is in combat
   *
   * When an entity falls into an Encounter Panel, their status
   * of combat must change, also if they quit this type of panel.
   *
   * @param player The entity involved in this combat
   */
  protected def apply(player: PlayerCharacter): Unit = {
    player.inCombat_(!player.inCombat)
  }
}
