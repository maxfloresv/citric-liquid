package cl.uchile.dcc.citric
package model.events

import cl.uchile.dcc.citric.model.entity.PlayerCharacter

/** This event is dispatched when a Norma Clear is done.
 *
 * @param player The player involved in this Norma Clear.
 */
class NormaClearEvent(val player: PlayerCharacter)
