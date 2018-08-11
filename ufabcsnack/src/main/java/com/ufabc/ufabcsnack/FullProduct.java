package UFACBSnack.model.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*  Esta Classe extende Produto, trazendo
	um preço e quantidades, dado uma
	determinada Loja de um determinado
	Vendedor.
*/

@Entity
public class FullProduct extends Product{
	
	@Column (name="ProductQty")
	private integer ProductQty;
	
	@Column (name="ProductPrice")
	private float ProductPrice;
			
}