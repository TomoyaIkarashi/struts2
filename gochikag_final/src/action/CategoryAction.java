package action;
import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.CategoryDAO;
import dto.CategoryDTO;

/**
 * 各カテゴリーページへ遷移するアクション
 * @author TOMOYA IKARASHI
 * @since 2017/03/21
 * @version 1.1
 */
public class CategoryAction extends ActionSupport{
	/**
	 * カテゴリー
	 */
	private String category;
	/**
	 * 商品の総数
	 */
	private List<CategoryDTO> items;

	/**
	 * 実行メソッド
	 * 各カテゴリーページへ遷移するアクション
	 * @author TOMOYA IKARASHI
	 * @return category
	 * @throws SQLException
	 */
	public String execute() throws SQLException{
		CategoryDAO dao = new CategoryDAO();
		items = dao.select(category);
		return category;
	}

	/**
	 * カテゴリーを取得します。
	 * @return カテゴリー
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * カテゴリーを設定します。
	 * @param category カテゴリー
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * 商品の総数を取得します。
	 * @return 商品の総数
	 */
	public List<CategoryDTO> getItems() {
		return items;
	}

	/**
	 * 商品の総数を設定します。
	 * @param items 商品の総数
	 */
	public void setItems(List<CategoryDTO> items) {
		this.items = items;
	}

}
