package com.lk.rest.Service;


import com.lk.rest.Model.Userp;
import com.lk.rest.Repository.UserpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserpRepository userpRepository;

    public Userp findById(int id) {
        return userpRepository.findById(id);
    }

    public List<Userp> findByName(String name) {
        return userpRepository.findByName(name);
    }

    public List<Userp> findByAge(int age) {
        return userpRepository.findByAge(age);
    }

    public List<Userp> findUserByPeriod(String beginTime, String endTime) {
        return userpRepository.findUserByPeriod(beginTime, endTime);
    }

    public Userp save(Userp user) {
        Date now = new Date();
        java.sql.Date nowDate=new java.sql.Date(now.getTime());
        if (user.getId() >= 0) {
            Userp existingUser = userpRepository.findById(user.getId());
            if (null !=existingUser) {
                existingUser.setName(user.getName());
                existingUser.setAge(user.getAge());
                existingUser.setUpdatedAt(nowDate);
                return userpRepository.save(existingUser);
            }else {
                user.setCreatedAt(nowDate);
                return userpRepository.save(user);
            }
        }
        return null;
    }

    public void delete(Userp user) {
        if(null !=user) {
            Userp userp = null;
            userpRepository.deleteById(user.getId());
            userp = userpRepository.findById(user.getId());
            if (null != userp) {
                System.out.println("Delete Failed");
            }else {
                System.out.println("Delete successfully");
            }
        }
    }

    public List<Userp> findAll(int page, int size) {
        if(page < 0 || size <= 0) {
            page = 0;
            size = 2;
        }
        PageRequest pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        List<Userp> users = userpRepository.findAll(pageable).getContent();
        return users;
    }



}
