package in.mrkhan.service;


import java.util.List;
import in.mrkhan.model.TutorialEntity;

public interface ITutorialsService {
	
	public String insertTutorialsInfo(TutorialEntity entity);
	
	public List<TutorialEntity> viewAllTutorials();
	
	public TutorialEntity getTutorialbyId(Integer id);
	
	public String updateTutorial(TutorialEntity entity);
	
	public String deleteTutorialbyId(Integer id);
	
	public String deleteAllTutorials();
	
	
	
	

}
