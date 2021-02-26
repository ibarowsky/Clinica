package StatePattern;

public class EsitoPos extends Stato{
	@Override
	public void manageState(Tampone tamp, String esito) {
		updateTampone(tamp.getId(),esito);
	}
}
