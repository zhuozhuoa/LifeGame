package lifeGame;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapTest {
	private static Map map=new Map();
	private static Cell [][]cell=new Cell[30][30];
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cell=map.initial();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		;
	}

	@Test
	public void testGetLiving() {
		for(int i=0;i<36;i++) {
			for(int j=0;j<36;j++) {
				cell[i][j].setStatus(1);
			}
		}
		map.getLiving(cell);
		for(int i=0;i<36;i++) {
			for(int j=0;j<36;j++) {
				if(i>0&&i<35&&j>0&&j<35) assertEquals(8,cell[i][j].getLiving());
				else if((i==0||i==35)&&(j>0&&j<35)||(j==0||j==35)&&(i>0&&i<35)) assertEquals(5,cell[i][j].getLiving());
				else assertEquals(3,cell[i][j].getLiving());
			}
		}
		for(int i=0;i<36;i++) {
			for(int j=0;j<36;j++) {
				cell[i][j].setStatus(0);
			}
		}
		map.getLiving(cell);
		for(int i=0;i<36;i++) {
			for(int j=0;j<36;j++) {
				assertEquals(0,cell[i][j].getLiving());
			}
		}
	}

	@Test
	public void testUpdate() {
		for(int i=0;i<36;i++) {
			for(int j=0;j<36;j++) {
				cell[i][j].setStatus(1);
			}
		}
		map.getLiving(cell);
		assertEquals(4,map.update(cell));
		for(int i=0;i<36;i++) {
			for(int j=0;j<36;j++) {
				cell[i][j].setStatus(0);
			}
		}
		map.getLiving(cell);
		assertEquals(1296,map.update(cell));
	}

}

