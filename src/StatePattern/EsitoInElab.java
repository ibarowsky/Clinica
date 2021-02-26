package StatePattern;

public class EsitoInElab extends Stato{
	@Override
	public void manageState(Tampone tamp, String esito) {
		if(esito.equals("ela"))
			updateTampone(tamp.getId(),esito);
		else if(esito.equals("pos"))
			tamp.setState(new EsitoPos());
		else if(esito.equals("neg"))
			tamp.setState(new EsitoNeg());
	}
}
