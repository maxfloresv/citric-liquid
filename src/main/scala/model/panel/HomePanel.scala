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
class HomePanel extends abstractPanel {
  /** Owner of this HomePanel.
   *
   * Every HomePanel has an owner to differentiate actions
   * when players fall in these panels. Initially, the owner is unknown
   */
  val owner: PlayerCharacter = null

  /** Gives HP to the current entity in this panel.
   *
   * This might be invoked when a player moves off this panel.
   *
   * @param entity The player character to remove from this panel.
   */
  def giveHp(entity: PlayerCharacter, n: Int): Unit = {
    entity.currentHitPoints += n
  }

  /** Checks if a player meets Norma level-up requirements.
   *
   * This conditions are check when players fall into this panel.
   *
   * @param character The player character to remove from this panel.
   */
  def normaCheck(character: PlayerCharacter): Boolean = {
    val norma = character.norma
    val objectiveChosen = character.objectiveChosen

    if (norma == 2) {
      if (objectiveChosen == 'V')
        character.wins >= 1
      else
        character.stars >= 10
    } else if (norma == 3) {
      if (objectiveChosen == 'V')
        character.wins >= 3
      else
        character.stars >= 30
    } else if (norma == 4) {
      if (objectiveChosen == 'V')
        character.wins >= 6
      else
        character.stars >= 70
    } else if (norma == 5) {
      if (objectiveChosen == 'V')
        character.wins >= 10
      else
        character.stars >= 120
    } else if (norma == 6) {
      if (objectiveChosen == 'V')
        character.wins >= 14
      else
        character.stars >= 200
    } else {
      // Player's norma can't be greater than 6
      throw new Exception("Norma can't be greater than 6")
      false
    }
  }

  /** Update a PlayerCharacter's norma
   *
   * If all conditions to Norma Clear are met, the player's norma increases by 1
   *
   * @param character The player character to remove from this panel.
   */
  def updateNorma(character: PlayerCharacter): Unit = {
    character.norma += 1
  }
}
