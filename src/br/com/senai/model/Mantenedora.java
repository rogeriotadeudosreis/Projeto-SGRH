package br.com.senai.model;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mantenedora database table.
 * 
 */
@Entity
public class Mantenedora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="man_iden")
	private int manIden;

	@Column(name="man_cnpj")
	private String manCnpj;

	@Column(name="man_insc_estadual")
	private int manInscEstadual;

	@Column(name="man_insc_municipal")
	private int manInscMunicipal;

	@Column(name="man_nome_fantasia")
	private String manNomeFantasia;

	@Column(name="man_razao_social")
	private String manRazaoSocial;

	private String mantenedoracol;

    public Mantenedora() {
    }

	public int getManIden() {
		return this.manIden;
	}

	public void setManIden(int manIden) {
		this.manIden = manIden;
	}

	public String getManCnpj() {
		return this.manCnpj;
	}

	public void setManCnpj(String manCnpj) {
		this.manCnpj = manCnpj;
	}

	public int getManInscEstadual() {
		return this.manInscEstadual;
	}

	public void setManInscEstadual(int manInscEstadual) {
		this.manInscEstadual = manInscEstadual;
	}

	public int getManInscMunicipal() {
		return this.manInscMunicipal;
	}

	public void setManInscMunicipal(int manInscMunicipal) {
		this.manInscMunicipal = manInscMunicipal;
	}

	public String getManNomeFantasia() {
		return this.manNomeFantasia;
	}

	public void setManNomeFantasia(String manNomeFantasia) {
		this.manNomeFantasia = manNomeFantasia;
	}

	public String getManRazaoSocial() {
		return this.manRazaoSocial;
	}

	public void setManRazaoSocial(String manRazaoSocial) {
		this.manRazaoSocial = manRazaoSocial;
	}

	public String getMantenedoracol() {
		return this.mantenedoracol;
	}

	public void setMantenedoracol(String mantenedoracol) {
		this.mantenedoracol = mantenedoracol;
	}

}