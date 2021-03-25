package com.icebergsocialnetwork.services.InterfaceService;

import com.icebergsocialnetwork.model.user.User;
import com.icebergsocialnetwork.services.IGenericService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends IGenericService<User>, UserDetailsService {
    User findByUsername(String username);

    boolean checkLogin(User user);

    boolean isRegister(User user);

    boolean isCorrectConfirmPassword(User user);

    User findUserByIdAndInfomodifierIsTrue(Long id);

    int lockUser(String username);

    int unlockUser(String username);

    List<User> userYouMayKnow(Long id);

    List<User> findAllByFullnameContaining(String fullname);


}
