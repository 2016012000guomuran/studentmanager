package cn.lanqiao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.lanqiao.model.TbClass;
import cn.lanqiao.model.TbCourse;
import cn.lanqiao.model.TbScore;
import cn.lanqiao.model.TbStudent;
import cn.lanqiao.service.TbClassService;
import cn.lanqiao.service.TbCourseService;
import cn.lanqiao.service.TbScoreService;
import cn.lanqiao.service.TbStudentService;
import cn.lanqiao.service.impl.TbClassServiceImpl;
import cn.lanqiao.service.impl.TbCourseServiceImpl;
import cn.lanqiao.service.impl.TbScoreServiceImpl;
import cn.lanqiao.service.impl.TbStudentServiceImpl;

//
public class TestStu {
	TbClassService tcs = new TbClassServiceImpl();
	
	TbScoreService tss = new TbScoreServiceImpl();
	
	TbCourseService tcss = new TbCourseServiceImpl();
	
	TbStudentService tsse = new TbStudentServiceImpl();
	
	//����ɾ��
	@Test
	public void test3() {
		TbClass tbclass = new TbClass(1, "����");
		tcs.removeTbClass(tbclass);
	}
	
	/*//���Ը���
	@Test 
	public void test2() {
		TbStudent tbstudent = new TbStudent(1, "�ճ�", "Ů", "1996-10-25", 1214);
		tsse.updateTbStudent(tbstudent);
		TbScore tbScore = new TbScore(1, 85, 1, 1);
		tss.updateTbScore(tbScore);
		TbClass tbclass = new TbClass(1214, "lll");
		tcs.updateTbClass(tbclass);
	}*/
	
	//���Բ�ѯ
/*	@Test
	public void test() {
		List<TbStudent> salgrades = tsse.getAllTbStudent();
		for (TbStudent s : salgrades) {		
			System.out.println(s);	
		}
	}*/
	
	//��������
	@Test
	public void test1() {
		TbClass tbclass = new TbClass(1, "����");
		tcs.insertTbClass(tbclass);
		
		/*TbScore tbScore = new TbScore(1, 80, 1, 1);
		tss.insertTbScore(tbScore);*/
		
	/*	TbCourse tbcourse = new TbCourse(1, "����", 1,"2.5");
		tcss.insertTbCourse(tbcourse);*/
		
		/*TbStudent tbstudent = new TbStudent(1, "�ճ�", "��", "1996-10-25", 1214);
		tsse.insertTbStudent(tbstudent);*/
}

}
