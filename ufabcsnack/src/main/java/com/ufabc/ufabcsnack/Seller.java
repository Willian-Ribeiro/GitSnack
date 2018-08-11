package GitSnack.model.entity;
import GitSnack.model.entity.User;
import GitSnack.model.entity.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*  Vendedor é uma classe/Entidade
	filha de Usuário. Ela possui o diferencial
	de Descrição, Nome e Posicionamento,
	coisas que um comprador não necessita possuir.
*/

@Entity
@Table(name="Seller")
public class Seller extends User{
	
	@Id
	private String ID;
	
	@Column (name="SellerDesc")
	private String SellerDesc;
	
	@Column (name="SellerName")
	private String SellerName;
	
	@Column (name="PositionX")
	private float PositionX;
	
	@Column (name="PositionY")
	private float PositionY;
		
	@Column (name="Status")
	private integer Status;
	
	
}