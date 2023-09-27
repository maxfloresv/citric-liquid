package cl.uchile.dcc.citric
package model.panel

import model.entity.PlayerCharacter

/** Represents a specific single cell on a board, known as DropPanel.
 *
 * This panel take stars from the player when they fall.
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
class DropPanel extends abstractPanel {
  /** Update the stars of a character given that they fell into a
   * Drop Panel. It takes roll * Norma from player's stars.
   *
   * @param character The character involved
   */
  def takeStars(character: PlayerCharacter): Unit = {
    val roll: Int = character.rollDice()
    character.stars -= roll * character.norma
  }
}
