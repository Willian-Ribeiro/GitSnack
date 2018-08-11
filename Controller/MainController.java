package UFACBSnack.controller;
import UFACBSnack.model.DAO.SellerDAO;
import UFACBSnack.model.entity.Seller;
import UFACBSnack.model.entity.FullProduct;

/*  Controller Principal e único,
	encapsulando todas as requisições HTTPS
	do FrontEnd.
*/

@Controller
public class MainController {
	
	private SellerDAO SDAO;
	
	//***************Requisições de Consultas**********************
	
	@RequestMapping("/ListSellers")
	public List<Seller> ListSellers() {
		return SDAO.ListAllActive;
	}
		
	@RequestMapping("/ListProductsSeller")
	public List<FullProduct> ListProductsSeller(String SellerID) {
		return SDAO.ListFullStore(SellerID);
	}
		
	@RequestMapping("/ListAllProducts")
	public List<FullProduct> ListProductsAll() {
		return SDAO.ListAllProducts;
	}
	
	//************Requisições de Inserção/Criação******************
	
	
	
	
	
}