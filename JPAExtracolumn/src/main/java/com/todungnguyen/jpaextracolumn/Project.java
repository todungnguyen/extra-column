package com.todungnguyen.jpaextracolumn;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
 
@Table (name = "project")
@Entity
@Data //does not work
public class Project implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    private Integer id;
 
    @Column
    private String name;
 
    @OneToMany(mappedBy = "developer")
    private List<DeveloperProject> developers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DeveloperProject> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<DeveloperProject> developers) {
		this.developers = developers;
	}
    
    
}
