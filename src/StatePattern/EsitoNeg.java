package StatePattern;

public class EsitoNeg extends Stato{
	@Override
	public void manageState(Tampone tamp, String esito) {
		updateTampone(tamp.getId(),esito);
	}
}
