package cl.uchile.dcc.citric
package model.panel

import model.entity.Entity

/** Represents a specific single cell on a board, known as EncounterPanel.
 *
 * In this panel the combats between players and WildUnits take place.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class EncounterPanel extends abstractPanel {
  /** Updates if an entity is in combat
   *
   * When an entity falls into an Encounter Panel, their status
   * of combat must change, also if they quit this type of panel.
   *
   * @param entity The entity involved in this combat
   */
  def updateCombatStatus(entity: Entity): Unit = {
    entity.inCombat = !entity.inCombat
  }
}
