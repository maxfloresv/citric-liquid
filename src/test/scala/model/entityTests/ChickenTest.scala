package cl.uchile.dcc.citric
package model.entityTests

import model.entity.Chicken

class ChickenTest extends munit.FunSuite {
  private var chicken: Chicken = _

  override def beforeEach(context: BeforeEach): Unit = {
    chicken = new Chicken()
  }

  assertEquals(chicken._atkPoints, -1)
  assertEquals(chicken._defPoints, -1)
  assertEquals(chicken._evaPoints, 1)
}


