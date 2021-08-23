package in.mrkhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.mrkhan.model.TutorialEntity;

public interface ITutorialsRepository extends JpaRepository<TutorialEntity, Integer> {
	}
