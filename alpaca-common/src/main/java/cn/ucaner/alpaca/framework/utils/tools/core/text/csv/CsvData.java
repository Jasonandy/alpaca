package cn.ucaner.alpaca.framework.utils.tools.core.text.csv;

import java.util.Collections;
import java.util.List;

/**
* @Package：cn.ucaner.alpaca.framework.utils.tools.core.text.csv   
* @ClassName：CsvData   
* @Description：   <p>  CSV数据，包括头部信息和行数据，参考：FastCSV </p>
* @Author： -    
* @CreatTime：2018年5月26日 上午12:09:21   
* @Modify By：   
* @ModifyTime：  2018年5月26日
* @Modify marker：   
* @version    V1.0
 */
public final class CsvData {

	private final List<String> header;
	private final List<CsvRow> rows;

	public CsvData(final List<String> header, final List<CsvRow> rows) {
		this.header = header;
		this.rows = rows;
	}

	/**
	 * Returns the number of rows in this container.
	 *
	 * @return the number of rows in this container
	 */
	public int getRowCount() {
		return rows.size();
	}

	/**
	 * Returns the header row - might be {@code null} if no header exists. The returned list is unmodifiable.
	 *
	 * @return the header row - might be {@code null} if no header exists
	 */
	public List<String> getHeader() {
		return header;
	}

	/**
	 * Returns a CsvRow by its index (starting with 0).
	 *
	 * @param index index of the row to return
	 * @return the row by its index
	 * @throws IndexOutOfBoundsException if index is out of range
	 */
	public CsvRow getRow(final int index) {
		return rows.get(index);
	}

	/**
	 * Returns an unmodifiable list of rows.
	 *
	 * @return an unmodifiable list of rows
	 */
	public List<CsvRow> getRows() {
		return Collections.unmodifiableList(rows);
	}

}
