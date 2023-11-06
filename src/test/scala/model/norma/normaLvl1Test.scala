package cl.uchile.dcc.citric
package model.norma

class normaLvl1Test extends munit.FunSuite {
  private var normaOne: NormaLvl1 = _

  override def beforeEach(context: BeforeEach): Unit = {
    normaOne = new NormaLvl1()
  }

  test("Norma 1 must have correctly set its objectives") {
    assertEquals(normaOne.normaLevel, 1)
    assertEquals(normaOne.victoriesNeeded, 1)
    assertEquals(normaOne.starsNeeded, 10)
  }
}
