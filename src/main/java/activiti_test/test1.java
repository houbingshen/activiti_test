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
		// 部署流程
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getRepositoryService().
		createDeployment().name("报销单流程").
		addClasspathResource("MyProcess.bpmn").deploy();
	}
	
	@Test
	void test2() {
		//启动流程
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getRuntimeService().startProcessInstanceByKey("myProcess");

	}
	
	@Test
	void test3() {
		//启动流程
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		List<Task> tasks=processEngine.getTaskService().createTaskQuery().taskAssignee("小黄").list();
		for (Task task : tasks) {
			System.out.println("任务id"+task.getId());
			
			System.out.println("流程id"+task.getProcessInstanceId());
		}
	}
	
	@Test
	void test4() {
		//结束
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		processEngine.getTaskService().complete("30004");
	}
	
}
