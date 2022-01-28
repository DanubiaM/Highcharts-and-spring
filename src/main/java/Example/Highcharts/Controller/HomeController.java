package Example.Highcharts.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Example.Highcharts.DAO.MultipleDataDAO;
import Example.Highcharts.models.MultipleData;

@Controller
public class HomeController {

	@Autowired
	MultipleDataDAO multipleDataDAO;

	@RequestMapping("/")
	public String showHome(){
		return "index";
	}
	@RequestMapping("/multiplelinechart")	
	public ResponseEntity<Map<String, List<MultipleData>>> getDataForMultipleLine() {
		List<MultipleData> dataList = multipleDataDAO.findAll();
		
		//MapHash com chave feita de String.
		Map<String, List<MultipleData>> mappedData = new HashMap<>();
		
		for(MultipleData data : dataList) {		
			
			//Verifica se o Map possui a chave.
			if(mappedData.containsKey( data.getName() )){
				//Retorna a chave do dado e adiciona o elemento.
				mappedData.get(data.getName()).add(data);
				
			}else {
				
				List<MultipleData> tempList = new ArrayList<MultipleData>();
				tempList.add(data);
				mappedData.put(data.getName(), tempList);
				
			}					
		}
		
		return new ResponseEntity<>(mappedData, HttpStatus.OK);
	}
}
