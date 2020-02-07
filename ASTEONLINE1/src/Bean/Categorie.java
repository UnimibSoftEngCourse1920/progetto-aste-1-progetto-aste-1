package Bean;

	/*private int id_categoria;
	private String nome;
	private int utente_fk;
	*/
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "categorie")
	public class Categorie{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_categoria", nullable = false, unique = true)
		public int id_categoria;

		@Column(name = "nome", length = 40, nullable = false)
		public String nome;

		@Column(name = "utente_fk", length = 40, nullable = false)
		public int utente_fk;


	
	//costruttore
	public Categorie(int id_categoria, String nome, int utente_fk ) {
		this.setId_categoria(id_categoria);
		this.setNome(nome);
		this.setUtente_fk(utente_fk);
		
	}
	
	
	/**
	 * @return the id_categoria
	 */
	public Integer getId_categoria() {
		return id_categoria;
	}
	/**
	 * @param id_categoria the id_categoria to set
	 */
	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
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

        Categorie c = (Categorie)obj;

        		if(this.getId_categoria()==(c.getId_categoria())&&
                this.getNome().equals(c.getNome()) &&
                this.getUtente_fk()==(c.getUtente_fk())   
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

            Categorie b = (Categorie) super.clone();

            b.setId_categoria(this.getId_categoria());
            b.setNome(this.getNome());
            b.setUtente_fk(this.getUtente_fk());
            
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
