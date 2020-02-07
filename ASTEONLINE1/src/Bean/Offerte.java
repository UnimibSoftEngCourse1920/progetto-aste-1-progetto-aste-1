package Bean;

import java.sql.Date;
/*
	private int id_offerta;
	private int asta_fk;
	private int utente_fk;
	private Double importo;
	private Date data;
	*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Offerte")
public class Offerte{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_offerta", nullable = false, unique = true)
	public int id_offerta;
	
	@Column(name = "asta_fk", length = 40, nullable = false)
	public int asta_fk;
	
	@Column(name = "utente_fk", length = 40, nullable = false)
	public int utente_fk;
	
	@Column(name = "importo", length = 40, nullable = false)
	public Double importo;
	
	@Column(name = "data", length = 40, nullable = false)
	public Date data;


	//costruttore
	public Offerte(int id_offerta, int asta_fk, int utente_fk, Double importo,Date data) {
		this.setId_offerta(id_offerta);
		this.setAsta_fk(asta_fk);
		this.setUtente_fk(utente_fk);
		this.setImporto(importo);
		this.setData(data);
	}

	/**
	 * @return the id_offerta
	 */
	public int getId_offerta() {
		return id_offerta;
	}

	/**
	 * @param id_offerta the id_offerta to set
	 */
	public void setId_offerta(int id_offerta) {
		this.id_offerta = id_offerta;
	}

	/**
	 * @return the asta_fk
	 */
	public int getAsta_fk() {
		return asta_fk;
	}

	/**
	 * @param asta_fk the asta_fk to set
	 */
	public void setAsta_fk(int id_asta) {
		this.asta_fk = id_asta;
	}

	/**
	 * @return the utente_fk
	 */
	public int getUtente_fk() {
		return utente_fk;
	}

	/**
	 * @param utente_fk the utente_fk to set
	 */
	public void setUtente_fk(int id_utente) {
		this.utente_fk = id_utente;
	}

	/**
	 * @return the importo
	 */
	public Double getImporto() {
		return importo;
	}

	/**
	 * @param importo the importo to set
	 */
	public void setImporto(Double importo) {
		this.importo = importo;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}
	
	
	
	/*

    @Override
    public boolean equals(Object obj)
    {
        if(obj == this)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (this.getClass() != obj.getClass())
            return false;

        Offerte of = (Offerte)obj;

        		if(this.getId_offerta()==(of.getId_offerta())&&
                this.getAsta_fk()==(of.getAsta_fk()) &&
                this.getUtente_fk()==(of.getUtente_fk())  &&
                this.getImporto().equals(of.getImporto())&&
                this.getData().equals(of.getData())
              )
        {
            return true;
        }
           return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        try
        {

            Offerte b = (Offerte) super.clone();
            
            b.setId_offerta(this.getId_offerta());
            b.setAsta_fk(this.getAsta_fk());
            b.setUtente_fk(this.getUtente_fk());
            b.setImporto(this.getImporto());
            b.setData(this.getData());
            
            return b;
        }

        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();

            return null;
        }

    }
  */  

}
