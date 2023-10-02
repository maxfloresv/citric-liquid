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

  /** Initial norma for every PlayerCharacter is 1. */
  private var norma: Int = 1

  /** Retrieves the Norma of a player.
   *
   * @return Current Norma for this player.
   */
  def getNorma: Int = norma

  /** Changes the player's Norma.
   *
   * @param newNorma Norma to be set.
   */
  protected def setNorma(newNorma: Int): Unit = {
    norma = newNorma
  }

  /** Number of games won are 0 by default. */
  private var wins: Int = 0

  /** Retrieves the number of times the player has won.
   *
   * @return Number of wins for a player.
   */
  def getWins: Int = wins

  /** Changes the number of wins for a player.
   *
   * @param newWins Wins to be set.
   */
  protected def setWins(newWins: Int): Unit = {
    wins = newWins
  }

  /** Initially, the player can't be KO. */
  private var isKO: Boolean = false

  /** Gets the current KO status for the player.
   *
   * @return Whether the player is in KO status or not.
   */
  protected def getKOStatus: Boolean = isKO

  /** Changes the KO status for a player.
   *
   * @param status True or False indicating the new KO status.
   */
  protected def setKOStatus(status: Boolean): Unit = {
    isKO = status
  }

  /** Initially, the player can't be in recovery state.
   * In this state, the player can't play its turn. */
  private var inRecovery: Boolean = false

  /** Gets the recovery status for a player.
   *
   * @return Whether the player is in recovery status or not.
   */
  protected def getRecoveryStatus: Boolean = inRecovery

  /** Changes the recovery status for a player.
   *
   * @param recovery True or False indicating new recovery status.
   */
  protected def setRecoveryStatus(recovery: Boolean): Unit = {
    inRecovery = recovery
  }

  /** Objective can be either 'V' or 'S' which stands for victories
   * and stars respectively. It allows the player to Norma Check. */
  private var objectiveChosen: Char = null

  /** Retrieves the objective of a player.
   *
   * @return Current objective of this player.
   */
  def getObjective: Char = objectiveChosen

  /** Changes the current objective of this player.
   *
   * @param newObjective New objective to be set.
   */
  protected def setObjective(newObjective: Char): Unit = {
    if (newObjective != 'V' && newObjective != 'S') {
      throw new Exception("Objective is either V or S.")
    } else {
      objectiveChosen = newObjective
    }
  }

  /** A player can choose in each turn if they skip their
   * Home Panel or not. Default is true. */
  private var skipHomePanel: Boolean = true

  /** Retrieves current Home Panel skip status for this player.
   *
   * @return True or False if this player decides whether to skip their home panel.
   */
  protected def getSkipStatus: Boolean = skipHomePanel

  /** Changes the current Home Panel skip status for a player.
   *
   * @param status New skip status to be set.
   */
  protected def setSkipStatus(status: Boolean): Unit = {
    skipHomePanel = status
  }

  /** ATK, DEF and EVA points are in the constructor. */
  val atkPoints: Int = attack
  val defPoints: Int = defense
  val evaPoints: Int = evasion

  /** Max hit points for this player is in the constructor. */
  val maxHitPoints: Int = maxHp

  /** Initial Hit Points are maximum possible. */
  setCurrentHitPoints(maxHitPoints)

  /** PlayerCharacter are always controllable. */
  val controllable: Boolean = true

  /** Initially, players aren't in combat. They
   * enter in combat iff they run into a Encounter Panel */
  setCombatStatus(false)
}
