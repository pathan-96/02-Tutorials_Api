package in.mrkhan.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.mrkhan.model.TutorialEntity;
import in.mrkhan.service.ITutorialsService;


@RestController
@RequestMapping("/api")
public class TutorialRestControllerApi {

	@Autowired
	private ITutorialsService tutorialServ;
	
	
	@PostMapping(value = "/inserttutorials",consumes = { "application/json" })
	public ResponseEntity<String> createTutorils(@RequestBody TutorialEntity entity) {
	
		String msg=tutorialServ.insertTutorialsInfo(entity);
		
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	
	
			
	@GetMapping("/getalltutorials")
	public ResponseEntity<List<TutorialEntity>> getAllTutorials() {
	
		
		     List<TutorialEntity> allTutorials = tutorialServ.viewAllTutorials();
		     return new ResponseEntity<>(allTutorials,HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/gettutorial/{id}")
	public ResponseEntity<TutorialEntity>  getTutorialbyId(@PathVariable Integer id)
	{
	    try {
	         TutorialEntity viewTutorialbyId = tutorialServ.getTutorialbyId(id);
	        
	        return new ResponseEntity<TutorialEntity>(viewTutorialbyId,HttpStatus.OK);
	    } catch (Exception e) {
	    	e.printStackTrace();
	        return new ResponseEntity<TutorialEntity>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }      
	}
	
	
	@PutMapping("/updatetutorial")
	public ResponseEntity<?> updateTutorialUsingId(@RequestBody TutorialEntity entity) {
		
		try {  
			 String msg=tutorialServ.updateTutorial(entity);
			 
			return new ResponseEntity<>(msg,HttpStatus.OK);
			
		} catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deletetutorial/{id}")
	public ResponseEntity<String> deletetutorial(@PathVariable Integer id) {
			try {  
				String msg=tutorialServ.deleteTutorialbyId(id);
				
			return new ResponseEntity<String>(msg,HttpStatus.OK);
				
			} catch (Exception e) 
			{
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}
	
	
	@DeleteMapping("/deletetutorials")
	public ResponseEntity<String> deleteAllTutorials()
	{
		String msg=tutorialServ.deleteAllTutorials();
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	
	
	
	
}
