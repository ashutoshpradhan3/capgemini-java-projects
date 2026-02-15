package com.capg.hibernate;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable{
	private int empno;
	private String ename;
	private double sal;
	private Date hiredate;
	private int deptno;
}
