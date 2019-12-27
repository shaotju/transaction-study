package canger.study.service.impl;

import canger.study.dao.StudentMapper;
import canger.study.service.StudentService;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,transactionManager = "transactionManager")
    public void updateStudent(int id,String name,int age){
        studentMapper.updateStudentAge(age,id);
        ((StudentService)AopContext.currentProxy()).updateStudentName(id,name);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,transactionManager = "transactionManager")
    public void updateStudentName(int id,String name){
        studentMapper.updateStudentName(name,id);
    }
}
