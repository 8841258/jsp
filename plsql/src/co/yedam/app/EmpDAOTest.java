package co.yedam.app;

public class EmpDAOTest {

	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		boolean result = dao.delete(3000);
		
		System.out.println(result);

	}

}
