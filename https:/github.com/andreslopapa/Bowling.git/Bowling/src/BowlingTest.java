


import org.junit.Assert;
import org.junit.Test;

public class BowlingTest {
Game juego;

	@Test
	public void failAllRolls() {
		//arrange
		startGame();
		
		//act
		tirar(0,20);
		
		//assert
		Assert.assertEquals(0	,juego.getPuntaje());
	}




@Test
public void TirarSiempreUno() {
	//arrange
	startGame();
	
	//act
	tirar(1,20);
	
	//assert
	Assert.assertEquals(20,juego.getPuntaje());
}

@Test
public void UnSpare() {
	//arrange
	startGame();
	
	//act
	juego.tirar(7);
	juego.tirar(3);
	tirar(1,18);
	
	//assert
	Assert.assertEquals(29,juego.getPuntaje());
}

@Test
public void UnSpareAlFinal() {
	//arrange
	startGame();
	
	//act
	tirar(1,18);
	juego.tirar(7);//spare
	juego.tirar(3);
	juego.tirar(1);
	
	//assert
	Assert.assertEquals(29,juego.getPuntaje());
}

@Test
public void UnStrike() {
	//arrange
	startGame();
	
	//act
	juego.tirar(10);//strike
	tirar(1,18);
	
	//assert
	Assert.assertEquals(30,juego.getPuntaje());
}

@Test
public void DosStrike() {
	//arrange
	startGame();
	
	//act
	juego.tirar(10);//strike
	juego.tirar(10);//strike
	tirar(1,16);
	
	//assert
	Assert.assertEquals(49,juego.getPuntaje());
}

@Test
public void DosStrikeAlFinal() {
	//arrange
	startGame();
	
	//act
	this.tirar(1,18);
	juego.tirar(10);//strike
	juego.tirar(10);//strike
	juego.tirar(10);//strike
	
	//assert
	Assert.assertEquals(48,juego.getPuntaje());
}

private void startGame(){
	juego=new Game();
}

private void tirar(int tiroRepetido,int cantTiros){
	for(int i=0;i<cantTiros;++i){
		juego.tirar(tiroRepetido);
	}
}


}