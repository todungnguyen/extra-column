package com.todungnguyen.jpaextracolumn;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "developer_project")
@Data
public class DeveloperProject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "developer_id")
	private Developer developer;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	@Column
	private String task;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

}
