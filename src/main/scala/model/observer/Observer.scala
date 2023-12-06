package cl.uchile.dcc.citric
package model.observer

/** Uses observer pattern in order to determine the end game.
 * This is the entity that observes (subscribes).
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
trait Observer[T] {
  /** Updates this observer when a change occurs and a subscriber notifies.
   *
   * @param observable The subject that emitted the information.
   * @param value The information emitted.
   */
  def update(observable: Subject[T], value: T): Unit
}
