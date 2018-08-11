package UFACBSnack.model.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User{
	
	@Id
	private String ID;
	
	@Column (name="Password")
	private String Password;
	
	@Column (name="Type")
	private integer Type;
	
	
}