package cl.uchile.dcc.citric
package model.entity

import model.entity.RoboBall

class RoboBallTest extends munit.FunSuite {
  private var roboBall: RoboBall = _
  private var chicken: Chicken = _
  private var seagull: Seagull = _

  override def beforeEach(context: BeforeEach): Unit = {
    roboBall = new RoboBall()
    chicken = new Chicken()
    seagull = new Seagull()
  }

  test("A RoboBall must have correctly set its stats") {
    assertEquals(roboBall._atkPoints, -1)
    assertEquals(roboBall._defPoints, 1)
    assertEquals(roboBall._evaPoints, -1)
  }

  test("A RoboBall must correctly retrieve bonus stars") {
    assertEquals(roboBall.bonus(chicken), 2)
    assertEquals(roboBall.bonus(seagull), 2)
  }
}
