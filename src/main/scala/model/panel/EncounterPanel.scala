package cl.uchile.dcc.citric
package model.panel

import model.entity.{Chicken, Entity, PlayerCharacter, RoboBall, Seagull, WildUnit}

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/** Represents a specific single cell on a board, known as EncounterPanel.
 *
 * In this panel the combats between players and WildUnits take place.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class EncounterPanel extends AbstractPanel {
  /** WildUnit placed in this panel. By default we don't know. */
  private var _wildUnit: WildUnit = _

  /** Gets the current WildUnit for this panel. */
  protected[model] def wildUnit: WildUnit = _wildUnit

  /** Sets the current WildUnit for this panel, randomly. */
  protected[model] def wildUnit_(): Unit = {
    val entities: ArrayBuffer[WildUnit] = ArrayBuffer[WildUnit](
      new Chicken(),
      new RoboBall(),
      new Seagull()
    )

    val sizeEntities = entities.length
    // Every entity has the same generateRandomInt method. We took the first.
    val randomNum = entities(0).generateRandomInt(sizeEntities)

    // Chooses a random WildUnit between all the available ones.
    _wildUnit = entities(randomNum - 1)
  }

  /** Updates if an entity is in combat
   *
   * When an entity falls into an Encounter Panel, their status
   * of combat must change, also if they quit this type of panel.
   *
   * @param player The entity involved in this combat
   */
  protected[model] def apply(player: PlayerCharacter): Unit = {
    player.inCombat_(!player.inCombat)
  }
}
