package cl.uchile.dcc.citric
package model.norma

class normaLvl4Test extends munit.FunSuite {
  private var normaFour: NormaLvl4 = _

  override def beforeEach(context: BeforeEach): Unit = {
    normaFour = new NormaLvl4()
  }

  test("Norma 4 must have correctly set its objectives") {
    assertEquals(normaFour.normaLevel, 4)
    assertEquals(normaFour.victoriesNeeded, 10)
    assertEquals(normaFour.starsNeeded, 120)
  }
}

