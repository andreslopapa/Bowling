
public class UltimoTurno extends Turno {
	
	public UltimoTurno(Object turAnt,Object turAntAnt){
		super(turAnt,turAntAnt);
	}
	@Override
	public void tirar(int pinosVolteados){
		
		
		if(tiros.size()==0){
			if(pinosVolteados==10){
				strike=true;
			}
		}
		else if(tiros.size()==1 && (pinosVolteados+tiros.get(0).getPinosVolteados())==10){
			spare=true;
		}
		if(tiros.size()==3 || (!this.isStrike() && !this.isSpare() && tiros.size()==2)  ){
			complete=true;
		}
		
		tiros.add(new Tiro(pinosVolteados));
		if(complete){
			this.actualizaPuntosTurnos();
		}
	}

}
