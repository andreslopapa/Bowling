import java.util.ArrayList;

public class Turno {

	protected ArrayList<Tiro> tiros=new ArrayList<Tiro>();
	private Tiro tirSiguiente;
	private Tiro tirSigSiguiente;
	protected Turno turnoAntAnterior;
	protected Turno turnoAnterior;
	protected int puntaje;
	protected boolean strike;
	protected boolean spare;
	protected boolean complete=false;
	
	public Turno(Object turAnt,Object turAntAnt){
		turnoAnterior=turAnt!=null?(Turno)turAnt:null;
		turnoAntAnterior=turAnt!=null?(Turno)turAntAnt:null;
	}
	public Turno(){}
	
	public void actualizaPuntosTurnos(){
		if(turnoAntAnterior!=null && turnoAntAnterior.isStrike() && turnoAnterior.isStrike()){
			turnoAntAnterior.setTirSigSiguiente(new Tiro(this.getPuntajePrimerTiro()));
		}
		if(turnoAnterior!=null){
		
			if(turnoAnterior.isStrike()){
				if(this.isStrike()){
					turnoAnterior.setTirSiguiente(new Tiro(this.getPuntajePrimerTiro()));
				}
				else{
					turnoAnterior.setTirSiguiente(new Tiro(this.getPuntajePrimerTiro()));
					turnoAnterior.setTirSigSiguiente(new Tiro(this.getPuntajeSegundoTiro()));
				}
			}
			else if(turnoAnterior.isSpare()){
					turnoAnterior.setTirSiguiente(new Tiro(this.getPuntajePrimerTiro()));
			}
			
			
		}
	}
	public void tirar(int pinosVolteados){
		
		if(tiros.size()==1){
			complete=true;
			if((pinosVolteados+tiros.get(0).getPinosVolteados())==10){
				spare=true;
			}
		}
		else{
			if(pinosVolteados==10){
				strike=true;
				complete=true;
			}
		}
		tiros.add(new Tiro(pinosVolteados));
		if(complete){
			this.actualizaPuntosTurnos();
		}
	}
	
	public int getPuntajePrimerTiro(){
		return tiros.get(0).getPinosVolteados();
	}
	public int getPuntajeSegundoTiro(){
		return tiros.get(1).getPinosVolteados();
	}
	
	public int getPuntajeTirosTurno(){
		puntaje=0;
		for(Tiro tiro:tiros){
			puntaje+=tiro.getPinosVolteados();
		}
		
		return puntaje;
	}
	
	public int getPuntaje(){
		this.getPuntajeTirosTurno();
		puntaje+=tirSiguiente==null?0:tirSiguiente.getPinosVolteados();
		puntaje+=tirSigSiguiente==null?0:tirSigSiguiente.getPinosVolteados();
		
		return puntaje;
	}
	
//	public int getPuntaje(){
//		
//		puntaje=0;
//		puntaje+=this.getPuntaje();
//		puntaje+=tirSiguiente==null?0:tirSiguiente.getPinosVolteados();
//		puntaje+=tirSigSiguiente==null?0:tirSigSiguiente.getPinosVolteados();
////		if(this.isSpare()){
////			puntaje+=turSig.getPuntajePrimerTiro();
////		}
////		if(this.isStrike()){
////			if(turSig.isStrike()){
////				puntaje+=turSig.getPuntaje()+turSigSig.getPuntajePrimerTiro();
////			}
////			else{
////				puntaje+=turSig.getPuntaje();
////			}
////		}
//		return puntaje;
//	}
	
	public boolean isStrike(){
		return strike;
	}
	

	public boolean isSpare(){
		return spare;
	}
	
	public boolean isComplete(){
		return complete;
	}
	public Tiro getTirSiguiente() {
		return tirSiguiente;
	}
	public void setTirSiguiente(Tiro tirSiguiente) {
		this.tirSiguiente = tirSiguiente;
	}
	public Tiro getTirSigSiguiente() {
		return tirSigSiguiente;
	}
	public void setTirSigSiguiente(Tiro tirSigSiguiente) {
		this.tirSigSiguiente = tirSigSiguiente;
	}
}



