package supportwheel.data.core;

import java.util.LinkedHashMap;
import java.util.Map;

import supportwheel.common.models.EngineerDTO;

public final class TestDataSource
{
	public static final Map<Integer, EngineerDTO> testData = new LinkedHashMap<Integer, EngineerDTO>();
	static
	{
		EngineerDTO tempVar = new EngineerDTO();
			tempVar.setName("Adam");
			tempVar.setID(1);
			testData.put(1, tempVar);
			
			EngineerDTO tempVar2 = new EngineerDTO();
			tempVar2.setName("Endrew");
			tempVar2.setID(2);
			testData.put(2, tempVar2);
			
			EngineerDTO tempVar3 = new EngineerDTO();
			tempVar3.setName("Malini");
			tempVar3.setID(3);
			testData.put(3, tempVar3);
			
			EngineerDTO tempVar4 = new EngineerDTO();
			tempVar4.setName("Haris");
			tempVar4.setID(4);
			testData.put(4, tempVar4);
			
			EngineerDTO tempVar5 = new EngineerDTO();
			tempVar5.setName("John");
			tempVar5.setID(2);
			testData.put(5, tempVar5);
			
			EngineerDTO tempVar6 = new EngineerDTO();
			tempVar6.setName("Mathiv");
			tempVar6.setID(6);
			testData.put(6, tempVar6);
			
			EngineerDTO tempVar7 = new EngineerDTO();
			tempVar7.setName("Harry");
			tempVar5.setID(7);
			testData.put(7, tempVar7);
			
			EngineerDTO tempVar8 = new EngineerDTO();
			tempVar8.setName("Bob");
			tempVar8.setID(8);
			testData.put(8, tempVar8);
			
			EngineerDTO tempVar9 = new EngineerDTO();
			tempVar9.setName("Gale");
			tempVar9.setID(9);
			testData.put(9, tempVar9);
			
			EngineerDTO tempVar10 = new EngineerDTO();
			tempVar10.setName("Larry");
			tempVar10.setID(10);
			testData.put(10, tempVar10);
	}
}