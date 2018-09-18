package activiti_test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;

class test1 {

	@Test
	void test() {
		// ��������
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getRepositoryService().
		createDeployment().name("����������").
		addClasspathResource("MyProcess.bpmn").deploy();
	}
	
	@Test
	void test2() {
		//��������
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getRuntimeService().startProcessInstanceByKey("myProcess");

	}
	
	@Test
	void test3() {
		//��������
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		List<Task> tasks=processEngine.getTaskService().createTaskQuery().taskAssignee("С��").list();
		for (Task task : tasks) {
			System.out.println("����id"+task.getId());
			
			System.out.println("����id"+task.getProcessInstanceId());
		}
	}
	
	@Test
	void test4() {
		//����
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getTaskService().complete("30004");
	}
	
}
