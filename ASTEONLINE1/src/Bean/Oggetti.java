package Bean;

	/*private int id_oggetto;
	private String nome;
	private Double prezzo;
	private int utente_fk;
	private int categoria_fk;
	*/
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "oggetti")
	public class Oggetti{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_oggetto", nullable = false, unique = true)
		public int id_oggetto;

		@Column(name = "nome", length = 40, nullable = false)
		public String nome;
		
		@Column(name = "prezzo", length = 40, nullable = false)
		public Double prezzo;
		

		@Column(name = "utente_fk", length = 40, nullable = false)
		public int utente_fk;
		
		@Column(name = "categoria_fk", length = 40, nullable = false)
		public int categoria_fk;
	
	
	
	
	
	
	
	
	
	
	
	//costruttore
	public Oggetti(int id_oggetto, String nome, Double prezzo, int utente_fk, int categoria_fk) {
		this.setId_oggetto(id_oggetto);
		this.setNome(nome);
		this.setPrezzo(prezzo);
		this.setUtente_fk(utente_fk);
		this.setCategoria_fk(categoria_fk);
	}
	
/*	
	public Oggetti() {
		// TODO Auto-generated constructor stub
	}
*/

	public Oggetti() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id_oggetto
	 */
	public Integer getId_oggetto() {
		return id_oggetto;
	}
	/**
	 * @param id_oggetto the id_oggetto to set
	 */
	public void setId_oggetto(Integer id_oggetto) {
		this.id_oggetto = id_oggetto;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the prezzo
	 */
	public Double getPrezzo() {
		return prezzo;
	}
	/**
	 * @param prezzo the prezzo to set
	 */
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	/**
	 * @return the id_utente
	 */
	public Integer getUtente_fk() {
		return utente_fk;
	}
	/**
	 * @param id_utente the id_utente to set
	 */
	public void setUtente_fk(Integer id_utente) {
		this.utente_fk = id_utente;
	}
	/**
	 * @return the id_categoria
	 */
	public Integer getCategoria_fk() {
		return categoria_fk;
	}
	/**
	 * @param id_categoria the id_categoria to set
	 */
	public void setCategoria_fk(Integer id_categoria) {
		this.categoria_fk = id_categoria;
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

        Oggetti o = (Oggetti)obj;

        		if(this.getId_oggetto()==(o.getId_oggetto())&&
        				
                this.getNome().equals(o.getNome()) &&
                this.getPrezzo().equals(o.getPrezzo())&&
                this.getUtente_fk()==(o.getUtente_fk())&&
                this.getCategoria_fk()==(o.getCategoria_fk())
                
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

            Oggetti b = (Oggetti) super.clone();

            b.setId_oggetto(this.getId_oggetto());
            b.setNome(this.getNome());
            b.setPrezzo(this.getPrezzo());
            b.setUtente_fk(this.getUtente_fk());
            b.setCategoria_fk(this.getCategoria_fk());
            
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
