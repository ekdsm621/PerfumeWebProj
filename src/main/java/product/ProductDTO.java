package product;

public class ProductDTO {
	private int id;
	private String name;
	private String brand;
	private String cate;
	private int price;
	private String main_img;
	private String sub_img_f;
	private String sub_img_s;
	private String sub_img_t;
	private int prod_new;
	private int prod_best;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMain_img() {
		return main_img;
	}
	public void setMain_img(String main_img) {
		this.main_img = main_img;
	}
	public String getSub_img_f() {
		return sub_img_f;
	}
	public void setSub_img_f(String sub_img_f) {
		this.sub_img_f = sub_img_f;
	}
	public String getSub_img_s() {
		return sub_img_s;
	}
	public void setSub_img_s(String sub_img_s) {
		this.sub_img_s = sub_img_s;
	}
	public String getSub_img_t() {
		return sub_img_t;
	}
	public void setSub_img_t(String sub_img_t) {
		this.sub_img_t = sub_img_t;
	}
	public int getProd_new() {
		return prod_new;
	}
	public void setProd_new(int prod_new) {
		this.prod_new = prod_new;
	}
	public int getProd_best() {
		return prod_best;
	}
	public void setProd_best(int prod_best) {
		this.prod_best = prod_best;
	}
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", brand=" + brand + ", cate=" + cate + ", price=" + price
				+ ", main_img=" + main_img + ", sub_img_f=" + sub_img_f + ", sub_img_s=" + sub_img_s + ", sub_img_t="
				+ sub_img_t + ", prod_new=" + prod_new + ", prod_best=" + prod_best + "]";
	}
	
	
	
}
