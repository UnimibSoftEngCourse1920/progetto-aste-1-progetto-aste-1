package Bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utenti")
public class Utenti{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utente", nullable = false, unique = true)
	public int id_utente;

	@Column(name = "nome", length = 40, nullable = false)
	public String nome;

	@Column(name = "cognome", length = 40, nullable = false)
	public String cognome;

	@Column(name = "email", length = 40, nullable = false)
	public String email;
	
	@Column(name = "username", length = 40, nullable = false)
	public String username;
	
	@Column(name = "password", length = 40, nullable = false)
	public String password;

	@Column(name = "indirizzo", length = 40, nullable = false)
	public String indirizzo;

	@Column(name = "città", length = 40, nullable = false)
	public String città;
	
	@Column(name = "ruolo", length = 40, nullable = false)
	public String ruolo;
	
	@Column(name = "saldo", length = 40, nullable = true)
	public double saldo;
	
	

		
  /*public class Utenti {
    private int id_utente;
    private String nome;
    private String cognome;
    private String email;
    private String username;
    private String password;
    private String indirizzo;
    private String città;
    private String ruolo;
    private Double saldo;*/

    //costrutore
    public Utenti( int id_utente ,String nome,String cognome, String email, String username,String password,String indirizzo, String città, String ruolo, Double saldo ) {
        this.setId_utente(id_utente);
        this.setNome(nome);
        this.setCognome(cognome);
        this.setEmail(email);
        this.setUsername(username);
        this.setPassword(password);
        this.setIndirizzo(indirizzo);
        this.setCittà(città);
        this.setRuolo(ruolo);
        this.setSaldo(saldo);
        
    }

    
	public Utenti() {
	
	}
	//get&set
	/**
	 * @return the id_utente
	 */
	public int getId_utente() {
		return id_utente;
	}

	/**
	 * @param id_utente the id_utente to set
	 */
	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
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
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * @param indirizzo the indirizzo to set
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * @return the città
	 */
	public String getCittà() {
		return città;
	}

	/**
	 * @param città the città to set
	 */
	public void setCittà(String città) {
		this.città = città;
	}

	/**
	 * @return the ruolo
	 */
	public String getRuolo() {
		return ruolo;
	}

	/**
	 * @param ruolo the ruolo to set
	 */
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	/**
	 * @return the saldo
	 */
	public Double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	/*
    @Override
    public String toString() {
       return "id_utente= " + id_utente + "\n"+
               "nome= "+ nome + "\n"+
               "cognome= "+ cognome + "\n"+
               "email= "+ email + "\n"+
               "username="+ username +"\n"+
               "password= " + password + "\n" +
               "indirizzo=" + indirizzo + "\n"+
               "città=" + città + "\n"+ 
               "ruolo=" + ruolo + "\n" +
              "saldo=" + saldo + "\n";
    }


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

        Utenti u = (Utenti)obj;

        if(this.getId_utente()==(u.getId_utente())&&
                this.getNome().equals(u.getNome()) &&
                this.getCognome().equals(u.getCognome())&&
                this.getEmail().equals(u.getEmail()) &&
                this.getUsername().contentEquals(u.getUsername())&&
                this.getPassword().equals(u.getPassword())&&
                this.getIndirizzo().equals(u.getIndirizzo()) &&
                this.getCittà().equals(u.getCittà()) &&
                this.getRuolo().equals(u.getRuolo()) &&
                this.getSaldo().equals(u.getSaldo())
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

            Utenti b = (Utenti) super.clone();

            b.setId_utente(this.getId_utente());
            b.setNome(this.getNome());
            b.setCognome(this.getCognome());
            b.setEmail(this.getEmail());
            b.setUsername(this.getUsername());
            b.setPassword(this.getPassword());
            b.setIndirizzo(this.getIndirizzo());
            b.setCittà(this.getCittà());
            b.setRuolo(this.getRuolo());
            b.setSaldo(this.getSaldo());

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

