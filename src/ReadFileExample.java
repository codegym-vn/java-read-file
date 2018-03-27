

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFileExample {

	public static void main(String[] args) {
		System.out.println("Nhập đường dẫn file: ");
		Scanner scanner = new Scanner(System.in);
		String path = scanner.nextLine();

		ReadFileExample readfileEx = new ReadFileExample();
		readfileEx.readFileText(path);
	}

	/*
	 * Viết một ứng dụng cho phép đọc một file text chứa các số nguyên và tính
	 * tổng của giá trị của các số đó. Ứng dụng cho phép nhập vào đường dẫn của
	 * file và hiển thị tổng các số chứa trong file đó. Nếu có ngoại lệ xảy ra
	 * (file không tồn tại, file chứa các giá trị không phải là số) thì hiển thị
	 * thông báo lỗi. Trong file text, mỗi số nguyên được lưu trên một dòng.
	 */
	public void readFileText(String filePath) {
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				throw new FileNotFoundException();
			}

			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			int sum = 0;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				sum += Integer.parseInt(line);
			}
			br.close();

			System.out.println("Tổng = " + sum);
		} catch (Exception e) {
			System.err.println("Fie không tồn tại or nội dung có lỗi!");
		}
	}
}
