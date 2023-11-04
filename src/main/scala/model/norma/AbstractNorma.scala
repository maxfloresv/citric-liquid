package cl.uchile.dcc.citric
package model.norma

import model.entity.PlayerCharacter

/**
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
abstract class AbstractNorma extends Norma {
  protected def normaCheck(character: PlayerCharacter): Boolean = {
    true
  }
}
