package com.huangyongsheng.hearthstone.service.impl;

import org.python.util.PythonInterpreter;

public class test {

	public static void main(String[] args) {
		PythonInterpreter interpreter = new PythonInterpreter();
		interpreter.exec("days=('mod','Tue','Wed','Thu','Fri','Sat','Sun'); ");
		interpreter.exec("print days[1];");

	}

}
