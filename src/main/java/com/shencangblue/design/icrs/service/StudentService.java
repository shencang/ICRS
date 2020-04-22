package com.shencangblue.design.icrs.service;

import com.shencangblue.design.icrs.dao.StudentDao;
import com.shencangblue.design.icrs.model.Department;
import com.shencangblue.design.icrs.model.Student;
import com.shencangblue.design.icrs.model.admin.AdminRole;
import com.shencangblue.design.icrs.model.admin.AdminUserRole;
import com.shencangblue.design.icrs.service.admin.AdminRoleService;
import com.shencangblue.design.icrs.service.admin.AdminUserRoleService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {
    @Resource
    private StudentDao studentDao;
    @Resource
    private AdminRoleService adminRoleService;
    @Resource
    private AdminUserRoleService adminUserRoleService;
    @Transactional
    public void save(Student student){
        studentDao.save(student);
    }
    @Transactional
    public Student getById(Long id){
        return studentDao.findById(id).orElse(null);
    }
    @Transactional
    public boolean isExist(String studentIdName){
        return null!= studentDao.findByStudentIdName(studentIdName);

    }
    @Transactional
    public Student getByStudentIdName(String studentIdName){
        return studentDao.findByStudentIdName(studentIdName);
    }
    @Transactional
    public Student studentIdAndPwd(String studentIdName,String password){
        return studentDao.getByStudentIdNameAndPassword(studentIdName,password);
    }

    @Transactional
    public Iterable<Student> getAll(){
        return studentDao.findAll();
    }
    @Transactional
    public void delete(Long id){
        studentDao.deleteById(id);
    }

    @Transactional
    public void updateStatus(Student student){
        studentDao.save(student);
    }

    @Transactional
    public Iterable<Student> getUnApproveAccount(){
        return studentDao.getByStatusAndRole(0,2);
    }

    @Transactional
    public Iterable<Student> getStuByDepId(int depId){
        return studentDao.getAllByDepartmentIdAndStatus(1,depId);
    }

    @Transactional
    public Iterable<Student> list() {
        Iterable<Student> students =  studentDao.findAll();
        List<AdminRole> roles;
        for (Student student : students) {
            roles = adminRoleService.listRolesByUser(student.getUsername());
            student.setRoles(roles);
        }
        return students;
    }

    @Transactional
    public boolean updateStudentStatus(Student student) {
        Student studentInDB = studentDao.findByStudentIdName(student.getStudentIdName());
        studentInDB.setEnabled(student.isEnabled());
        try {
            studentDao.save(studentInDB);
        } catch (IllegalArgumentException e) {
            return false;
        } return true;
    }

    @Transactional
    public boolean resetPassword(Student student) {
        Student studentInDB = studentDao.findByStudentIdName(student.getStudentIdName());
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        studentInDB.setSalt(salt);
        String encodedPassword = new SimpleHash("md5", "123", salt, times).toString();
        studentInDB.setPassword(encodedPassword);
        try {
            studentDao.save(studentInDB);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    @Transactional
    public boolean editUser(Student student) {
        Student studentInDB = studentDao.findByStudentIdName(student.getStudentIdName());
        studentInDB.setUsername(student.getUsername());
        studentInDB.setPhone(student.getPhone());
        studentInDB.setEmail(student.getEmail());
        try {
            studentDao.save(studentInDB);
            adminUserRoleService.saveRoleChanges((int)studentInDB.getStudentId(), student.getRoles());
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
    @Transactional
    public int register(Student student) {
        String username =student.getUsername();
        String studentIdName= student.getStudentIdName();
        String phone = student.getPhone();
        String email = student.getEmail();
        String password = student.getPassword();

        username = HtmlUtils.htmlEscape(username);
        student.setUsername(username);
        studentIdName = HtmlUtils.htmlEscape(studentIdName);
        student.setStudentIdName(studentIdName);
        phone = HtmlUtils.htmlEscape(phone);
        student.setPhone(phone);
        email = HtmlUtils.htmlEscape(email);
        student.setEmail(email);
        student.setEnabled(true);

        if (username.equals("") || password.equals("")) {
            return 0;
        }

        boolean exist = isExist(username);

        if (exist) {
            return 2;
        }

        // 默认生成 16 位盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();

        student.setSalt(salt);
        student.setPassword(encodedPassword);
        studentDao.save(student);

        return 1;
    }

}
