package br.com.senai.web;

import java.util.List;
import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.com.senai.model.Mantenedora;

public class MantenedoraDataModel extends ListDataModel<Mantenedora> implements
		SelectableDataModel<Mantenedora> {

	public MantenedoraDataModel() {
	}

	public MantenedoraDataModel(List<Mantenedora> data) {
		super(data);
	}

	public Mantenedora getRowData(int rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<Mantenedora> mantenedoras = (List<Mantenedora>) getWrappedData();

		for (Mantenedora mantenedora : mantenedoras) {
			if (mantenedora.getManIden() == (rowKey))
				return mantenedora;
		}

		return null;
	}

	@Override
	public Object getRowKey(Mantenedora mantenedora) {
		return mantenedora.getManIden();
	}

	@Override
	public Mantenedora getRowData(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}