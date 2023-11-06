package cl.uchile.dcc.citric
package model.entity

import model.entity.Seagull

class SeagullTest extends munit.FunSuite {
  private var seagull: Seagull = _
  private var chicken: Chicken = _
  private var roboBall: RoboBall = _

  override def beforeEach(context: BeforeEach): Unit = {
    seagull = new Seagull()
    chicken = new Chicken()
    roboBall = new RoboBall()
  }

  test("A Seagull must have correctly set its stats") {
    assertEquals(seagull._atkPoints, 1)
    assertEquals(seagull._defPoints, -1)
    assertEquals(seagull._evaPoints, -1)
  }

  test("A Seagull must correctly retrieve bonus stars") {
    assertEquals(seagull.bonus(chicken), 2)
    assertEquals(seagull.bonus(roboBall), 2)
  }
}
