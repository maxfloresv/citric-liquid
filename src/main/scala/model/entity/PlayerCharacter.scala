package cl.uchile.dcc.citric
package model.entity

import cl.uchile.dcc.citric.model.panel.Panel

import scala.util.Random

/** The `PlayerCharacter` class represents a character or avatar in the game, encapsulating
  * several attributes such as health points, attack strength, defense capability,
  * and evasion skills. Each player has a unique name, and throughout the game,
  * players can collect stars, roll dice, and progress in levels known as 'norma'.
  * This class not only maintains the state of a player but also provides methods
  * to modify and interact with these attributes.
  *
  * For instance, players can:
 *
  * - Increase or decrease their star count.
 *
  * - Roll a dice, a common action in many board games.
 *
  * - Advance their norma level.
  *
  * Furthermore, the `Player` class has a utility for generating random numbers,
  * which is primarily used for simulating dice rolls. By default, this utility is
  * an instance of the `Random` class but can be replaced if different random
  * generation behaviors are desired.
  *
  * @param name The name of the player. This is an identifier and should be unique.
  * @param maxHp The maximum health points a player can have. It represents the player's endurance.
  * @param attack The player's capability to deal damage to opponents.
  * @param defense The player's capability to resist or mitigate damage from opponents.
  * @param evasion The player's skill to completely avoid certain attacks.
  * @param randomNumberGenerator A utility to generate random numbers. Defaults to a new `Random`
  *                              instance.
  *
  * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
  * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
  * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
  * @author [[https://github.com/Seivier/ Vicente González B.]]
  * @author [[https://github.com/maxfloresv/ Máximo Flores Valenzuela]]
  */
class PlayerCharacter(val name: String,
              val maxHp: Int,
              val attack: Int,
              val defense: Int,
              val evasion: Int,
              val randomNumberGenerator: Random = new Random()) extends Entity {

  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }

  /** Initial norma for every PlayerCharacter is 1 */
  var norma: Int = 1

  /** Either stars and wins are 0 by default */
  var stars: Int = 0
  var wins: Int = 0

  /** Initially, the player can't be KO nor in recovery state  */
  var isKO: Boolean = false
  var inRecovery: Boolean = false

  /**
   * Objective can be either 'V' or 'S' which stands for victories
   * and stars respectively.
   */
  var objectiveChosen: Char = null

  var skipHomePanel: Boolean = false

  /** ATK, DEF and EVA points are unknown at this point */
  val atkPoints = 0
  val defPoints = 0
  val evaPoints = 0

  val maxHitPoints: Int = maxHp
  var currentHitPoints: Int = maxHitPoints

  /** PlayerCharacter are always controllable */
  val controllable: Boolean = true

  /** Initial Panel is unknown */
  var currentPanel: Panel = null

  /** Initially, players aren't in combat. They
   * enter in combat iff they run into a Encounter Panel */
  var inCombat: Boolean = false

  /** Update the wins of the character */
  def updateWins(n: Int): Unit = {
    wins += n
  }
}
