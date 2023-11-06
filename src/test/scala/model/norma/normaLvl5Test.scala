package cl.uchile.dcc.citric
package model.norma

class normaLvl5Test extends munit.FunSuite {
  private var normaFive: NormaLvl5 = _

  override def beforeEach(context: BeforeEach): Unit = {
    normaFive = new NormaLvl5()
  }

  test("Norma 5 must have correctly set its objectives") {
    assertEquals(normaFive.normaLevel, 5)
    assertEquals(normaFive.victoriesNeeded, 14)
    assertEquals(normaFive.starsNeeded, 200)
  }
}

