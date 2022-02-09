package net.projects.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.projects.todolist.model.Task;
import net.projects.todolist.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public List<Task> getAllTask() {
		return taskRepository.findAll();
	}

	@Override
	public void saveTask(Task task) {
		this.taskRepository.save(task);
	}

	@Override
	public Task getTaskById(long id) {
		Optional<Task> optional = taskRepository.findById(id);
		Task task = null;
		if (optional.isPresent()) {
			task = optional.get();
		} else {
			throw new RuntimeException(" Task not found for id :: " + id);
		}
		return task;
	}

	@Override
	public void deleteTaskById(long id) {
		taskRepository.deleteById(id);
	}


}
