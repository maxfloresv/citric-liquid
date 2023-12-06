package cl.uchile.dcc.citric
package model.observer

class AbstractSubject[T] extends Subject[T] {
  // List of observers associated to this subject
  private var observers: List[Observer[T]] = List.empty

  override def addObserver(observer: Observer[T]): Unit = {
    observers = observer :: observers
  }

  override def notifyObservers(value: T): Unit = {
    for (observer <- observers) {
      // We update every observer associated to this instance.
      observer.update(this, value)
    }
  }
}
