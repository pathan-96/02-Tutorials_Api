package in.mrkhan.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TUTORIAL_TAB")
public class TutorialEntity {
	
	@Id
	@Column(name = "Id")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	public TutorialEntity()
	{
		
	}
	
	public TutorialEntity(Integer id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TutorialEntity [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	
	

	
}
