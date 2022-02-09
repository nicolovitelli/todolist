package net.projects.todolist.service;

import java.util.List;

import net.projects.todolist.model.Task;

public interface TaskService {
	List<Task> getAllTask();
	void saveTask(Task employee);
	Task getTaskById(long id);
	void deleteTaskById(long id);
}
