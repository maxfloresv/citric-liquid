package cl.uchile.dcc.citric
package model.observer

/** Uses observer pattern in order to determine the end game.
 * This is the entity that notifies (publishes).
 *
 * @author [[https://github.com/maxfloresv Máximo Flores Valenzuela]]
 */
trait Subject[T] {
  /** Add Observers that receives the information published by this subject
   *
   * @param observer The observer to be added.
   */
  def addObserver(observer: Observer[T]): Unit

  /** Notify an observer associated to this subject.
   *
   * @param value The information to be transmitted.
   */
  def notifyObservers(value: T): Unit
}
