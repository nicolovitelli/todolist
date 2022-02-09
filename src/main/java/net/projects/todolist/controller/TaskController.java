package net.projects.todolist.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.projects.todolist.model.Task;
import net.projects.todolist.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listTask", taskService.getAllTask());
		return "index";
	}
	
	@GetMapping("/showNewTaskForm")
	public String showNewTaskForm(Model model) {
		Task task = new Task();
		model.addAttribute("task", task);
		return "new_task";
	}
	
	@PostMapping("/saveTask")
	public String saveTask(@ModelAttribute("task") Task task) {
		taskService.saveTask(task);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		Task task = taskService.getTaskById(id);
		model.addAttribute("task", task);
		return "update_task";
	}
	
	@GetMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable (value = "id") long id) {
		this.taskService.deleteTaskById(id);
		return "redirect:/";
	}
	
}
