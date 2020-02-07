package Bean;

import java.sql.Date;
import java.sql.Time;

	/*
	private int id_asta;
	private Date data;
	private int utente_fk;
	private int oggetto_fk;
	private String stato;
	private Time durata_time_slot;
	private String tipo_terminazione;
	private String tipo_asta;
	private boolean rinuncia;
	
*/	
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aste")
public class Aste{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_asta", nullable = false, unique = true)
	public int id_asta;
	
	@Column(name = "data", length = 40, nullable = false)
	public Date data;

	@Column(name = "utente_fk", length = 40, nullable = false)
	public int utente_fk;
	
	@Column(name = "oggetto_fk", length = 40, nullable = false)
	public int oggetto_fk;
	
	@Column(name = "stato", length = 40, nullable = false)
	public String stato;
	
	@Column(name = "durata_time_slot", length = 40, nullable = false)
	public Time durata_time_slot;

	@Column(name = "tipo_terminazione", length = 40, nullable = false)
	public String tipo_terminazione;
	
	@Column(name = "tipo_asta", length = 40, nullable = false)
	public String tipo_asta;
	
	@Column(name = "rinuncia", length = 40, nullable = false)
	public Boolean rinuncia;
	



	
	//costruttore
	public Aste(int id_asta, Date data, int utente_fk, int oggetto_fk, String stato, 
			Time durata_time_slot, String tipo_terminazione, String tipo_asta, boolean rinuncia) {
		this.setId_asta(id_asta);
		this.setData(data);
		this.setUtente_fk(utente_fk);
		this.setOggetto_fk(oggetto_fk);
		this.setStato(stato);
		this.setDurata_time_slot(durata_time_slot);
		this.setTipo_terminazione(tipo_terminazione);
		this.setTipo_asta(tipo_asta);
		this.setRinuncia(rinuncia);
		
	}
	
	
	/**
	 * @return the id_asta
	 */
	public int getId_asta() {
		return id_asta;
	}
	/**
	 * @param id_asta the id_asta to set
	 */
	public void setId_asta(int id_asta) {
		this.id_asta = id_asta;
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
	 * @return the oggetto_fk
	 */
	public int getOggetto_fk() {
		return oggetto_fk;
	}
	/**
	 * @param oggetto_fk the oggetto_fk to set
	 */
	public void setOggetto_fk(int id_oggetto) {
		this.oggetto_fk = id_oggetto;
	}
	/**
	 * @return the stato
	 */
	public String getStato() {
		return stato;
	}
	/**
	 * @param stato the stato to set
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}
	/**
	 * @return the durata_time_slot
	 */
	public Time getDurata_time_slot() {
		return durata_time_slot;
	}
	/**
	 * @param durata_time_slot the durata_time_slot to set
	 */
	public void setDurata_time_slot(Time durata_time_slot) {
		this.durata_time_slot = durata_time_slot;
	}
	/**
	 * @return the tipo_terminazione
	 */
	public String getTipo_terminazione() {
		return tipo_terminazione;
	}
	/**
	 * @param tipo_terminazione the tipo_terminazione to set
	 */
	public void setTipo_terminazione(String tipo_terminazione) {
		this.tipo_terminazione = tipo_terminazione;
	}
	/**
	 * @return the tipo_asta
	 */
	public String getTipo_asta() {
		return tipo_asta;
	}
	/**
	 * @param tipo_asta the tipo_asta to set
	 */
	public void setTipo_asta(String tipo_asta) {
		this.tipo_asta = tipo_asta;
	}
	/**
	 * @return the rinuncia
	 */
	public boolean isRinuncia() {
		return rinuncia;
	}
	/**
	 * @param rinuncia the rinuncia to set
	 */
	public void setRinuncia(boolean rinuncia) {
		this.rinuncia = rinuncia;
	}
	

    @Override
    public String toString() {
       return "id_asta= " + id_asta + "\n"+
               "data= "+ data + "\n"+
               "utente_fk= "+ utente_fk + "\n"+
               "oggetto_fk= "+ oggetto_fk + "\n"+
               "stato="+ stato +"\n"+
               "durata_time_slot= " + durata_time_slot + "\n" +
               "tipo_terminazione=" + tipo_terminazione + "\n"+
               "tipo_asta=" + tipo_asta + "\n"+ 
               "rinuncia=" + rinuncia + "\n" ;
             
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

        Aste a = (Aste)obj;

        		if(this.getId_asta()==(a.getId_asta())&&
                this.getData().equals(a.getData()) &&
                this.getUtente_fk()==(a.getUtente_fk())&&
                this.getOggetto_fk()==(a.getOggetto_fk()) &&
                this.getStato().contentEquals(a.getStato())&&
                this.getDurata_time_slot().equals(a.getDurata_time_slot())&&
                this.getTipo_terminazione().equals(a.getTipo_terminazione()) &&
                this.getTipo_asta().equals(a.getTipo_asta()) &&
                this.isRinuncia()==(a.isRinuncia()) 
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

            Aste b = (Aste) super.clone();

            b.setId_asta(this.getId_asta());
            b.setData(this.getData());
            b.setUtente_fk(this.getUtente_fk());
            b.setOggetto_fk(this.oggetto_fk);
            b.setStato(this.getStato());
            b.setDurata_time_slot(this.getDurata_time_slot());
            b.setTipo_terminazione(this.getTipo_terminazione());
            b.setTipo_asta(this.getTipo_asta());
            b.setRinuncia(this.isRinuncia());
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


