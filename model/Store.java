package UFACBSnack.model.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Store")
public class Product{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;
	
	@Column (name="SellerID")
	private String SellerID;
	
	@Column (name="ProductPrice")
	private Float ProductPrice;
	
	@Column (name="ProductQty")
	private Integer ProductQty;
		
	@Column (name="ProductID")
	private Integer ProductID;
		
}