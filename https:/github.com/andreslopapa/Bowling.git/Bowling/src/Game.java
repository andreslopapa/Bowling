import java.util.ArrayList;

public class Game {
	private ArrayList<Turno> turnos;
	private int puntaje;
	private int maxTurnos;
	
	public Game(){
		turnos=new ArrayList<Turno>();
		puntaje=0;
		maxTurnos=10;
	}
	

	
	public int getPuntaje(){
		puntaje=0;
		for(Turno tur:turnos){
			puntaje+=tur.getPuntaje();
		}
		return puntaje;
	}

	
	public void tirar(int pinosTirados){
		int turnoActualIndex=turnos.size()-1;
		Turno tur;
		if(turnos.size()==0 || turnos.get(turnoActualIndex).isComplete()){
			if(turnos.size()==maxTurnos-1){
				tur=new UltimoTurno(turnoActualIndex<0?null:turnos.get(turnoActualIndex),turnoActualIndex<1?null:turnos.get(turnoActualIndex-1));
			}
			else
			{
				tur=new Turno(turnoActualIndex<0?null:turnos.get(turnoActualIndex),turnoActualIndex<1?null:turnos.get(turnoActualIndex-1));
			}
			turnos.add(tur);
		}
		else{
			tur=turnos.get(turnoActualIndex);
		}
		tur.tirar(pinosTirados);
	}
	


}




