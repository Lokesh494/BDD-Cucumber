package externaldata.org;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static void main(String[] args) throws IOException {

		File f = new File("C:\\Users\\lokesh_s\\eclipse-workspace\\EPAM-Flex_Framework\\External Files\\TEST.xlsx");

		FileInputStream fin = new FileInputStream(f);

		XSSFWorkbook book = new XSSFWorkbook(fin);

		XSSFSheet s = book.getSheet("TestData");

		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {

			XSSFRow r = s.getRow(i);

			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {

				XSSFCell c = r.getCell(j);

				int type = c.getCellType();

				if (type == 1) {

					String name = c.getStringCellValue();
					System.out.println(name);
				} else if (DateUtil.isCellDateFormatted(c)) {

					Date da = c.getDateCellValue();

					SimpleDateFormat sim = new SimpleDateFormat("dd MMMMM , yyyy");
					String name = sim.format(da);
					System.out.println(name);
				} else {
					double d = c.getNumericCellValue();

					long lo = (long) d;

					String name = String.valueOf(lo);
					System.out.println(name);

				}
			}

		}

	}

}
