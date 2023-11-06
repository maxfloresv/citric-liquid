package cl.uchile.dcc.citric
package model.panel

import model.entity.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** Represents a single cell on a board, known as a Panel.
  *
  * Each panel has its own effect, which can be applied to a character.
  * In the context of the board game, a panel represents a tile or space that a character lands on
  * and experiences an effect (e.g., losing stars, fighting an enemy, etc.).
  * Panels can also be connected to other panels, allowing for the formation of complex board
  * structures.
  *
  * @author [[https://github.com/r8vnhill Ignacio Slater M.]]
  * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
  */
trait Panel {
  /** Array of the characters currently positioned on this panel.
    *
    * In the game, multiple characters might be on the same panel at once, e.g., if multiple players
    * land on the same space.
    */
  protected val _characters: ArrayBuffer[PlayerCharacter]

  /** Getter for character list */
  protected def characters: ArrayBuffer[PlayerCharacter]

  /** An array of panels that are directly connected to this one.
   *
   * In the context of the game, multiple routes or paths may exist, this could represent the
   * possible next steps a player might take after being on this panel.
   *
   * @return a List of Panel instances that are adjacent or connected to this panel.
   */
  protected val _nextPanels: ArrayBuffer[Panel]

  /** Adds a character to the list of characters currently on this panel.
    *
    * This might be invoked when a player moves to this panel or starts their turn on it.
    *
    * @param player The player character to add to this panel.
    */
  protected def addCharacter(player: PlayerCharacter): Unit

  /** Removes a character from the list of characters currently on this panel.
    *
    * This might be invoked when a player moves off this panel.
    *
    * @param player The player character to remove from this panel.
    */
  protected def removeCharacter(player: PlayerCharacter): Unit

  /** Applies effects to a player when reaching a Panel.
   *
   * @param player The player affected.
   */
  protected def apply(player: PlayerCharacter): Unit

  /** Add a next panel to the current panel.
   *
   * @param panel The panel to be added.
   */
  protected def addNextPanel(panel: Panel): Unit

  /** Removes a next panel from the current panel.
   *
   * @param panel The panel to be removed.
   */
  protected def removeNextPanel(panel: Panel): Unit
}
