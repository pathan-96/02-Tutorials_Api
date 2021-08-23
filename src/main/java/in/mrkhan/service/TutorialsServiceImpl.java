package in.mrkhan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mrkhan.model.TutorialEntity;
import in.mrkhan.repository.ITutorialsRepository;

@Service
public class TutorialsServiceImpl implements ITutorialsService {

	@Autowired
	private ITutorialsRepository tutorialRepo;

	public String  insertTutorialsInfo(TutorialEntity entity) {
		
		TutorialEntity saved = tutorialRepo.save(entity);
		
			return saved==null?"Insertion failed!":"Insertion succeded!";
	}
	public List<TutorialEntity> viewAllTutorials() {
		return tutorialRepo.findAll();
	}
	
	public TutorialEntity getTutorialbyId(Integer id) {
		TutorialEntity tutorialEntity = tutorialRepo.findById(id).get();
		return tutorialEntity;
	}

	  public String updateTutorial(TutorialEntity entity) {
		  boolean presentId = tutorialRepo.findById(entity.getId()).isPresent();
		  if(presentId)
		  tutorialRepo.save(entity);
		  
		  return "updation succeded";
	  } 
	  
	  
	public String deleteTutorialbyId(Integer id) {
		Boolean flag=false;
		 tutorialRepo.deleteById(id);
		 flag=true;
		 return  flag==false?"deletion failed"+id:id+"id record deleted";
	}
	
	
	public String deleteAllTutorials() {
		tutorialRepo.deleteAll();
		return"all record deleted";
	}
}
