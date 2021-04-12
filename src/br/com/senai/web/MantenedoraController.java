package br.com.senai.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.senai.model.Mantenedora;
import br.com.senai.persistence.MantenedoraDAO;

@Component("controleMantenedora")
@Scope("session")
public class MantenedoraController implements Serializable {

	@Autowired
	private MantenedoraDAO mantenedoraDao;
	private Mantenedora mantenedora;
	private Mantenedora mantenedoraSel;
	private DataModel listaMantenedora;
	
	public Mantenedora getMantenedoraSel() {
		if(mantenedoraSel == null){
			mantenedoraSel = new Mantenedora();
		}
		return mantenedoraSel;
	}

	public void setMantenedoraSel(Mantenedora mantenedoraSel) {
		this.mantenedoraSel = mantenedoraSel;
	}

	

	public void setListaMantenedora(DataModel listaMantenedora) {
		this.listaMantenedora = listaMantenedora;
	}

	public DataModel getListaMantenedora() {
		List<Mantenedora> lista = mantenedoraDao.getLista(Mantenedora.class,
				"SELECT m FROM Mantenedora m");
		listaMantenedora = new ListDataModel(lista);
		return listaMantenedora;
	}

	public MantenedoraDAO getMantenedoraDao() {
		return mantenedoraDao;
	}

	public void setMantenedoraDao(MantenedoraDAO mantenedoraDao) {
		this.mantenedoraDao = mantenedoraDao;
	}

	public Mantenedora getMantenedora() {
		return mantenedora;
	}

	public void setMantenedora(Mantenedora mantenedora) {
		this.mantenedora = mantenedora;
	}

	public void prepararAdicionarMantenedora(ActionEvent actionEvent) {
		mantenedora = new Mantenedora();
	}

	public void prepararAlterarMantenedora(ActionEvent actionEvent) {
		mantenedora = (Mantenedora) (listaMantenedora.getRowData());
	}

	public void excluirMantenedora() {
		Mantenedora mantTemp = (Mantenedora) (listaMantenedora.getRowData());
		mantenedoraDao.remove(mantTemp);
		
	}

	public void adicionarMantenedora(ActionEvent actionEvent) {
		mantenedoraDao.salvar(mantenedora);
	}

	public void alterarMantenedora(ActionEvent actionEvent) {
		mantenedoraDao.merge(mantenedora);
	}

}
