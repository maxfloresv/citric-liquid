package cl.uchile.dcc.citric
package model.norma

class normaLvl6Test extends munit.FunSuite {
  private var normaSix: NormaLvl6 = _

  override def beforeEach(context: BeforeEach): Unit = {
    normaSix = new NormaLvl6()
  }

  test("Norma 6 must have correctly set its objectives") {
    assertEquals(normaSix.normaLevel, 6)
    assertEquals(normaSix.victoriesNeeded, 14)
    assertEquals(normaSix.starsNeeded, 200)
  }
}

