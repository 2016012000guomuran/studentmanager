package cn.lanqiao.dao;

import java.util.List;

import cn.lanqiao.model.UserMnager;

public interface UserMnagerDao {
	//��ѯ�����û�
	public List<UserMnager> list();
	//�����û�
	public void insert(UserMnager usermnager);
}
