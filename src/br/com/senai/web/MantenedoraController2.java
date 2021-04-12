package br.com.senai.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.senai.model.Mantenedora;
import br.com.senai.persistence.MantenedoraDAO;

@Component("controleMantenedora2")
@Scope("session")
public class MantenedoraController2 implements Serializable {

	private List<Mantenedora> listagem;
	@Autowired
	private MantenedoraDAO mantenedoraDao;
	private Mantenedora mantenedora;
	private Mantenedora mantenedoraSel;
	
	
	public Mantenedora getMantenedoraSel() {
		if (mantenedoraSel == null) {
			mantenedoraSel = new Mantenedora();
		}
		return mantenedoraSel;
	}

	public void setMantenedoraSel(Mantenedora mantenedoraSel) {
		this.mantenedoraSel = mantenedoraSel;
	}

	@SuppressWarnings("unchecked")
	public List<Mantenedora> getListagem() {
		if (listagem == null) {
			listagem = new ArrayList<Mantenedora>();
			listagem = mantenedoraDao.getLista(Mantenedora.class,
					"SELECT m FROM Mantenedora m");
		}

		return listagem;
	}

	public void setListagem(List<Mantenedora> listagem) {
		this.listagem = listagem;
	}

	public MantenedoraDAO getMantenedoraDao() {
		return mantenedoraDao;
	}

	public void setMantenedoraDao(MantenedoraDAO mantenedoraDao) {
		this.mantenedoraDao = mantenedoraDao;
	}

	public Mantenedora getMantenedora() {

		if (mantenedora == null) {
			mantenedora = new Mantenedora();
		}
		return mantenedora;
	}

	public void setMantenedora(Mantenedora mantenedora) {
		this.mantenedora = mantenedora;
	}

	public String gettesteHall() {
		return "Olá galera. :)  :)";
	}

	public void create() {
		mantenedoraDao.salvar(mantenedora);

		listagem.add(mantenedora);
		mantenedora = null;
		System.out.println("PASSOU");

	}

	@SuppressWarnings("unchecked")
	public void editar() {
		
		mantenedoraDao.merge(mantenedora);

	}

	@SuppressWarnings("unchecked")
	public void excluir() {
		mantenedora = (Mantenedora) mantenedoraDao.getEntidade(
				mantenedora.getManIden(), Mantenedora.class);
		mantenedoraDao.remove(mantenedora);

		// listagem.remove(mantenedora);

	}

}
