package com.todungnguyen.jpaextracolumn;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
 
@Table (name = "developer")
@Entity
@Data 
public class Developer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    private Integer id;
 
    @Column
    private String name;
 
    @OneToMany(mappedBy = "project")
    private List<DeveloperProject> projects;

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

	public List<DeveloperProject> getProjects() {
		return projects;
	}

	public void setProjects(List<DeveloperProject> projects) {
		this.projects = projects;
	}
    
    
}