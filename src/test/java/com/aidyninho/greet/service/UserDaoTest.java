package com.aidyninho.greet.service;

import com.aidyninho.greet.dao.UserDao;
import com.aidyninho.greet.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private final UserDao userDao = UserDao.getInstance();

    @InjectMocks
    private UserService userService;

    @Test
    public void saveReturnsTrue() {
        Mockito.doReturn(true).when(userDao).save(Mockito.any(User.class));
        boolean actual = userService.save(new User(null, "John", "Doe"));
        assertTrue(actual);
    }

    @Test
    public void getByIdReturnsUser() {
        User expected = new User(1L, "John", "Doe");
        Mockito.doReturn(expected).when(userDao).getById(1L);
        User actual = userService.findById(1L);
        assertEquals(expected, actual);
    }

    @Test
    public void updateReturnsTrue() {
        Mockito.doReturn(true).when(userDao).update(Mockito.any(User.class));
        boolean actual = userService.update(new User(null, "NotJohn", "NotDoe"));
        assertTrue(actual);
    }

    @Test
    public void deleteReturnsTrue() {
        Mockito.doReturn(true).when(userDao).delete(1L);
        boolean actual = userService.delete(1L);
        assertTrue(actual);
    }

}