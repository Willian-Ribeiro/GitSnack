package UFACBSnack.model.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;
	
	@Column (name="ProductName")
	private String ProductName;
	
	@Column (name="ProductDesc")
	private String ProductDesc;
			
}