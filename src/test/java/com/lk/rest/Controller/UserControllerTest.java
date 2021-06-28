package com.lk.rest.Controller;

import com.lk.rest.Model.Userp;
import com.lk.rest.Service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {UserController.class})
@DisplayName("UnitTest1")
public class UserControllerTest {

    @MockBean
    UserService userService;

    @Resource
    UserController userController;

    @Test
    public void testFindById() {
        Userp user1 = new Userp(1,"Lilei",30);
        when(userService.findById(anyInt())).thenReturn(null);
        when(userService.findById(1)).thenReturn(user1);
        Userp resultUser1 = userController.findById(1);
        assertEquals(user1.getId(),resultUser1.getId());
        Userp resultUser2 = userController.findById(2);
        assertNull(resultUser2);
    }

    @Test
    public void testFindByName() {
        Userp user1 = new Userp(1,"Lilei",30);
        List<Userp> userps = new ArrayList<>();
        userps.add(user1);
        when(userService.findByName(anyString())).thenReturn(null);
        when(userService.findByName("Lilei")).thenReturn(userps);
        List<Userp> resultUser1 = userController.findByName("Lilei");
        assertEquals(user1.getId(),resultUser1.get(0).getId());
        List<Userp> resultUser2 = userController.findByName("HanMeimei");
        assertNull(resultUser2);
    }

    @Test
    public void testFindByAge() {
        Userp user1 = new Userp(1,"Lilei",30);
        List<Userp> userps = new ArrayList<>();
        userps.add(user1);
        when(userService.findByAge(anyInt())).thenReturn(null);
        when(userService.findByAge(30)).thenReturn(userps);
        List<Userp> resultUser1 = userController.findByAge(30);
        assertEquals(user1.getId(),resultUser1.get(0).getId());
        List<Userp> resultUser2 = userController.findByAge(31);
        assertNull(resultUser2);
    }

    @Test
    public void testFindByPeriod() {
        Userp user1 = new Userp(1,"Lilei",30);
        List<Userp> userps = new ArrayList<>();
        userps.add(user1);
        when(userService.findUserByPeriod(anyString(), anyString())).thenReturn(null);
        when(userService.findUserByPeriod("2021-06-21", "2021-06-30")).thenReturn(userps);
        List<Userp> resultUser1 = userController.findByPeriod("2021-06-21", "2021-06-30");
        assertEquals(user1.getId(),resultUser1.get(0).getId());
        List<Userp> resultUser2 = userController.findByPeriod("2021-06-11", "2021-06-20");
        assertNull(resultUser2);
    }

    @Test
    public void testFindAll() {
        Userp user1 = new Userp(1,"Lilei",30);
        List<Userp> userps = new ArrayList<>();
        userps.add(user1);
        when(userService.findAll(anyInt(), anyInt())).thenReturn(null);
        when(userService.findAll(0, 2)).thenReturn(userps);
        List<Userp> resultUser1 = userController.findAll(0,2);
        assertEquals(user1.getId(),resultUser1.get(0).getId());
        List<Userp> resultUser2 = userController.findAll(1, 3);
        assertNull(resultUser2);
    }

    @Test
    public void testSave() {
        Userp user1 = new Userp(1,"Lilei",30);
        when(userService.save(any())).thenReturn(null);
        when(userService.save(user1)).thenReturn(user1);
        Userp user2 = new Userp(2,"Lilei",31);
        Userp resultUser2 = userController.saveUser(user2);
        assertNull(resultUser2);
        Userp resultUser1 = userController.saveUser(user1);
        assertEquals(user1.getId(),resultUser1.getId());
    }


}
